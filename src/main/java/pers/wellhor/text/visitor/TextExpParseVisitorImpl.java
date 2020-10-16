package pers.wellhor.text.visitor;

import org.antlr.v4.runtime.tree.ParseTree;
import pers.wellhor.text.index.Index;
import pers.wellhor.text.index.Pair;
import pers.wellhor.text.parser.TextExpParser;
import pers.wellhor.text.unit.HitResult;
import pers.wellhor.text.utils.CommonsUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/8/20 4:35 下午
 **/
public class TextExpParseVisitorImpl extends TextExpParserBaseVisitor<HitResult> {

    private final static Pattern ROLE_PATTERN = Pattern.compile("[A-Z]-");

    private final static Pattern WORD_ROLE_PATTERN = Pattern.compile("^[A-Z]-");

    private final static Integer DEFAULT_DISTANCE = 10;

    private final String context;

    private final char[] roleBits;

    public TextExpParseVisitorImpl(String context) {
        this.context = context;
        this.roleBits = parseRole(context);
    }

    /**
     * 获取命中结果
     *
     * @param parseTree 命中树
     * @return 命中结果
     */
    private HitResult getResult(ParseTree parseTree) {
        HitResult result = parseTree.accept(this);
        return result == null ? new HitResult() : result;
    }

    @Override
    public HitResult visitRoot(TextExpParser.RootContext ctx) {
        return getResult(ctx.getChild(0));
    }

    @Override
    public HitResult visitBinaryExpression(TextExpParser.BinaryExpressionContext ctx) {
        ParseTree leftTree = ctx.getChild(0);
        ParseTree operatorTree = ctx.getChild(1);
        ParseTree rightTree = ctx.getChild(2);

        HitResult leftHitResult = getResult(leftTree);
        HitResult rightHitResult = getResult(rightTree);

        HitResult newHitResult = new HitResult();
        if("|".equalsIgnoreCase(operatorTree.getText())) {
            //或运算
            newHitResult.setHit(leftHitResult.isHit() || rightHitResult.isHit());
        } else {
            //与运算
            newHitResult.setHit(leftHitResult.isHit() && rightHitResult.isHit());
        }

        if(leftHitResult.isHit()) {
            newHitResult.getHitWords().addAll(leftHitResult.getHitWords());
        }

        if(rightHitResult.isHit()) {
            newHitResult.getHitWords().addAll(rightHitResult.getHitWords());
        }

        return newHitResult;
    }

    @Override
    public HitResult visitNotExpression(TextExpParser.NotExpressionContext ctx) {
        ParseTree parseTree = ctx.getChild(1);
        HitResult hitResult = getResult(parseTree);
        HitResult newHitResult = new HitResult();
        //取非运算
        newHitResult.setHit(!hitResult.isHit());
        if(newHitResult.isHit()) {
            HitResult.HitWord hitWord = new HitResult.HitWord()
                    .setExpress(ctx.getText())
                    .setMsg("非运算符 无内容显示");
            newHitResult.getHitWords().add(hitWord);
        }
        return newHitResult;
    }

    @Override
    public HitResult visitRparenExpression(TextExpParser.RparenExpressionContext ctx) {
        ParseTree parseTree = ctx.getChild(1);
        return getResult(parseTree);
    }

    @Override
    public HitResult visitRoleWordExpression(TextExpParser.RoleWordExpressionContext ctx) {
        String text = ctx.getText();
        char role = text.charAt(0);
        String word = text.substring(2);
        int offset = 0, index;
        HitResult hitResult = new HitResult().setHit(false);
        String subString = this.context;
        while ((index = subString.indexOf(word)) > 0) {
            if(role == roleBits[index + offset]) {
                hitResult.setHit(true);
                HitResult.HitWord hitWord = new HitResult.HitWord().setExpress(text);
                hitWord.addIndex(new Index(role, word, index + offset, index + offset + word.length() - 1));
                hitResult.getHitWords().add(hitWord);
            }
            offset += index + word.length();
            subString = subString.substring(index + word.length());
            ++index;
        }
        return hitResult;
    }

    @Override
    public HitResult visitSingleWordExpression(TextExpParser.SingleWordExpressionContext ctx) {
        String text = ctx.getText();
        boolean isHit = CommonsUtils.isNotEmpty(context) && context.contains(text);
        HitResult hitResult = new HitResult().setHit(isHit);
        if(isHit) {
            int offset = 0, index;
            while ((index = context.indexOf(text, offset)) >= 0) {
                HitResult.HitWord hitWord = new HitResult.HitWord().setExpress(text);
                hitWord.addIndex(new Index(null, text, index, index + text.length() - 1));
                hitResult.getHitWords().add(hitWord);
                offset += index + text.length();
            }
        }
        return hitResult;
    }


    @Override
    public HitResult visitDefaultDistanceAfter(TextExpParser.DefaultDistanceAfterContext ctx) {
        return this.matchDistance(ctx.getText() + "#" + DEFAULT_DISTANCE);
    }

    @Override
    public HitResult visitDistanceAfter(TextExpParser.DistanceAfterContext ctx) {
        return this.matchDistance(ctx.getText());
    }

    /**
     * 递归遍历寻找符合表达式的index组合
     *
     * @param indexMap    key为词名称 value 是索引数组
     * @param words       表达式词语
     * @param wordIndex   表达式词语遍历到的下标
     * @param fromIndex   从哪个下标开始寻找符合条件的index  这个fromIndex 是表达式#前一个词的最后一个字的下标
     * @param maxDistance 最大距离
     * @return 查询结果
     */
    private Stack<Index> travelWords(Map<String, List<Index>> indexMap,
                                     String[] words,
                                     int wordIndex,
                                     int fromIndex,
                                     int maxDistance) {
        // 最后一个是距离
        if(wordIndex >= words.length - 1) {
            return new Stack<>();
        } else {
            String word = words[wordIndex];
            List<Index> indices = indexMap.get(word);
            if(indices == null || indices.size() == 0) {
                // 中间的词 只要有一个木有 整个#表达式整体肯定不会满足 直接return null
                return null;
            }
            for (Index index : indices) {
                // 索引下标 要大于前一个词的下标
                if(index.getStart() < fromIndex) {
                    continue;
                }
                // 如果子词没有符合条件的则跳过
                Stack<Index> indexStack = travelWords(indexMap, words, wordIndex + 1, index.getEnd(), maxDistance);
                if(indexStack == null) {
                    continue;
                }
                // 距离超出 最后一个词的最后一个字 - 减去当前的词的 第一个字的距离 如果大于最大距离 则判断为超过距离
                if(!indexStack.isEmpty() && (indexStack.get(0).getEnd() - index.getStart() >= maxDistance)) {
                    continue;
                }

                indexStack.push(index);
                return indexStack;
            }
            return null;
        }
    }

    /**
     * 匹配距离
     *
     * @param exp 表达式
     * @return 是否匹配
     */
    private HitResult matchDistance(String exp) {
        String[] words = exp.split(Pattern.quote("#"));

        int maxDistance = Integer.parseInt(words[words.length - 1]);

        // 距离不包含 需要命中的字
        // 比如 你好#明天#谢谢#啊#10
        // 表示
        // ①从你好 到 啊 之间 要包含 明天和谢谢
        // ②然后从你好到啊 中 去掉所有表达式词语 最多只能剩10个字 多了则为距离超出
        Map<String, List<Index>> indexMap = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            if(CommonsUtils.isNotEmpty(words[i])) {
                Character r = splitRole(words[i]);

                Pair<String, List<Index>> indexPair = indexWord(this.context, words[i]);
                if(indexPair != null) {
                    indexMap.put(indexPair.getLeft(), indexPair.getRight());
                }

                // 加到最后 maxDistance 值为 表达式最后一个#后面的距离+ 所有字的长度 故 不用考虑#中间有多少字了 如果满足的话 从 第一个命中词的第一个命中到最后一个命中词的最后一个字的距离 小于等于maxDistance即可
                maxDistance += words[i].length() - (r == null ? 0 : 2);
            }
        }

        HitResult hitResult = new HitResult();

        int lastIndex = 0;
        Stack<Index> indexStack;
        while (isNotEmpty(indexStack = travelWords(indexMap, words, 0, lastIndex, maxDistance))) {
            hitResult.setHit(true);
            HitResult.HitWord hitWord = new HitResult.HitWord().setExpress(exp);
            hitResult.getHitWords().add(hitWord);
            List<Index> indices = hitWord.getIndices();
            boolean isFirstWord = true;
            while (!indexStack.isEmpty()) {
                Index index = indexStack.pop();
                if(index != null) {
                    if(isFirstWord) {
                        lastIndex = index.getStart() + 1;
                        isFirstWord = false;
                    }
                    indices.add(index);
                }
            }
        }
        return hitResult;
    }

    private boolean isNotEmpty(Stack<Index> indexStack) {
        return indexStack != null && !indexStack.isEmpty();
    }

    /**
     * 按词语检索
     *
     * @param context 文本内容
     * @param word    词
     * @return 索引列表
     */
    private Pair<String, List<Index>> indexWord(String context, String word) {
        if(CommonsUtils.isNotEmpty(word) && CommonsUtils.isNotEmpty(context)) {
            String w = splitWord(word);
            Character r = splitRole(word);
            int curs = 0;
            int index;
            List<Index> indices = new ArrayList<>();
            while ((index = this.context.indexOf(w, curs)) >= 0) {
                if(r == null || r == roleBits[index]) {
                    indices.add(new Index(r, w, index, index + w.length() - 1));
                }
                curs = index + w.length();
            }
            return indices.size() == 0 ? null : new Pair<>(word, indices);
        }
        return null;
    }

    /**
     * 分离出词语中的角色 无角色 返回null
     *
     * @param word 词语
     * @return 角色
     */
    private Character splitRole(String word) {
        Matcher matcher = WORD_ROLE_PATTERN.matcher(word);
        if(matcher.find()) {
            String role = matcher.group();
            return role.charAt(0);
        }
        return null;
    }

    /**
     * 分离出词语中的词 去除角色
     *
     * @param word 词语
     * @return 词语
     */
    private String splitWord(String word) {
        Matcher matcher = WORD_ROLE_PATTERN.matcher(word);
        if(matcher.find()) {
            return word.substring(2);
        }
        return word;
    }

    private char[] parseRole(String context) {
        char[] bits = new char[context.length()];
        Matcher matcher = ROLE_PATTERN.matcher(context);
        int lastStart = 0;
        String lastRole = "";
        while (matcher.find()) {
            String roleStr = matcher.group();
            int start = matcher.start();
            if(!lastRole.equals("")) {
                char role = lastRole.charAt(0);
                for (int i = lastStart; i < start; i++) {
                    bits[i] = role;
                }
            }
            lastRole = roleStr;
            lastStart = start;
        }
        if(CommonsUtils.isNotEmpty(lastRole) && lastStart < bits.length) {
            for (int i = lastStart; i < bits.length; i++) {
                bits[i] = lastRole.charAt(0);
            }
        }
        return bits;
    }

}
