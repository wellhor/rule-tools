package pers.wellhor.text;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pers.wellhor.text.exception.TextGrammarException;
import pers.wellhor.text.hl.BitMap;
import pers.wellhor.text.hl.HighLight;
import pers.wellhor.text.index.Index;
import pers.wellhor.text.lexer.TextExpLexer;
import pers.wellhor.text.parser.TextExpParser;
import pers.wellhor.text.unit.HitResult;
import pers.wellhor.text.visitor.TextExpParseVisitorImpl;
import pers.wellhor.text.visitor.TextExpParserBaseVisitor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文本解析器
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/8/26 4:52 下午
 **/
public final class TextAnalysis {

    private TextAnalysis() {
    }

    /**
     * 表达式校验
     *
     * @param formula 表达式
     * @throws TextGrammarException 语法解析异常
     */
    public static void formulaVerification(String formula) throws TextGrammarException {
        getParseTree(formula);
    }

    /**
     * 解析文本表达式
     *
     * @param context 文本内容
     * @param formula 表达式
     * @return 文本内容
     */
    public static HitResult parse(String context, String formula) {
        ParseTree tree = getParseTree(formula);
        TextExpParserBaseVisitor<HitResult> vtaParserVisitor = new TextExpParseVisitorImpl(context);
        return vtaParserVisitor.visit(tree);
    }

    /**
     * 根据公式 获取语法🌲
     *
     * @param formula 公式
     * @return 语法树
     * @throws TextGrammarException 语法解析异常
     */
    public static ParseTree getParseTree(String formula) throws TextGrammarException {
        CharStream input = CharStreams.fromString(formula);
        TextExpLexer lexer = new TextExpLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TextExpParser parser = new TextExpParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(TextParseErrorListener.INSTANCE);
        return parser.root();
    }

    /**
     * 词语高亮
     *
     * @param context 文本内容
     * @param formula 表达式
     * @return 高亮结果
     */
    public static List<HighLight> highLight(String context, String formula) {
        HitResult hitResult = parse(context, formula);
        return highLight(hitResult, context, "<font color='red'>", "</font>", 20, null);
    }

    /**
     * 词语高亮
     *
     * @param context  文本内容
     * @param formula  表达式
     * @param hlPre    高亮前缀
     * @param hlSuffix 高亮后缀
     * @return 高亮结果
     */
    public static List<HighLight> highLight(String context, String formula, String hlPre, String hlSuffix) {
        HitResult hitResult = parse(context, formula);
        return highLight(hitResult, context, hlPre, hlSuffix, 10, null);
    }

    /**
     * 词语高亮
     *
     * @param context   文本内容
     * @param formula   表达式
     * @param hlPre     高亮前缀
     * @param hlSuffix  高亮后缀
     * @param defHLSize 默认高亮片段显示长度
     * @return 高亮结果
     */
    public static List<HighLight> highLight(String context, String formula, String hlPre, String hlSuffix, int defHLSize) {
        HitResult hitResult = parse(context, formula);
        return highLight(hitResult, context, hlPre, hlSuffix, defHLSize, null);
    }


    /**
     * 词语高亮
     *
     * @param context     文本内容
     * @param formula     表达式
     * @param hlPre       高亮前缀
     * @param hlSuffix    高亮后缀
     * @param defHLSize   默认高亮片段显示长度
     * @param defaultShow 在没有可显示内容时 显示的高亮片段值 比如非表达式的情况下
     * @return 高亮结果
     */
    public static List<HighLight> highLight(String context, String formula, String hlPre, String hlSuffix, int defHLSize, String defaultShow) {
        HitResult hitResult = parse(context, formula);
        return highLight(hitResult, context, hlPre, hlSuffix, defHLSize, defaultShow);
    }

    /**
     * 词语高亮
     *
     * @param hitResult 命中结果
     * @param context   文本内容
     * @param hlPre     高亮前缀
     * @param hlSuffix  高亮后缀
     * @param defHLSize 默认高亮片段显示长度
     * @return 高亮结果
     */
    public static List<HighLight> highLight(HitResult hitResult, String context, String hlPre, String hlSuffix, int defHLSize, String defaultShow) {
        if(hitResult != null && hitResult.isHit()) {
            return hitResult.getHitWords().stream().map(item -> {
                HighLight highLight = new HighLight();
                String exp = item.getExpress();
                highLight.setExpress(exp);

                List<Index> indices = item.getIndices();
                if(indices == null || indices.size() == 0) {
                    highLight.setSnapshot(defaultShow != null ? defaultShow : item.getMsg());
                } else {
                    String snapshot = parseSnapshot(indices, context, hlPre, hlSuffix, defHLSize, defaultShow);
                    highLight.setSnapshot(snapshot);
                }
                return highLight;
            }).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    /**
     * 解析出snapshot
     *
     * @param indices     命中词索引集合
     * @param context     文本内容
     * @param hlPre       高亮前缀
     * @param hlSuffix    高亮后缀
     * @param defHLSize   默认尺寸
     * @param defaultShow 在没有可显示内容时 显示的高亮片段值 比如非表达式的情况下
     * @return 返回响应的高亮片段
     */
    private static String parseSnapshot(List<Index> indices, String context, String hlPre, String hlSuffix, int defHLSize, String defaultShow) {
        List<Index> filteredHit = indices.stream().filter(hitCharacter -> hitCharacter.getStart() >= 0 && hitCharacter.getEnd() >= 0).collect(Collectors.toList());
        if(filteredHit.size() > 0) {
            Index minHit = filteredHit.stream().min(Comparator.comparing(Index::getStart)).orElse(null);
            Index maxHit = filteredHit.stream().max(Comparator.comparing(Index::getEnd)).orElse(null);
            int begin = Math.max(minHit.getStart() - 5, 0);
            int end = Math.min(Math.max(minHit.getStart() + defHLSize, maxHit.getEnd()), context.length());
            String highLightStr = context.substring(begin, end);
            BitMap bitMap = new BitMap(highLightStr.length());
            filteredHit.forEach(hc -> {
                int highStartIndex = hc.getStart() - begin;
                int highEndIndex = hc.getEnd() - begin;
                for (int i = highStartIndex; i <= highEndIndex; i++) {
                    bitMap.add(i);
                }
            });
            StringBuilder highLightBuilder = new StringBuilder();
            // 记录前一个字符是否高亮
            boolean preCode = false;
            for (int i = 0; i < highLightStr.length(); i++) {
                if(!preCode && bitMap.contain(i)) {
                    // 前一个字符不是高亮，当前字符高亮，在当前字符前面拼接prefix
                    highLightBuilder.append(hlPre).append(highLightStr.charAt(i));
                    preCode = bitMap.contain(i);
                } else if(preCode && !bitMap.contain(i)) {
                    // 前一个字符高亮，当前字符不高亮，在当前字符前面拼接suffix
                    highLightBuilder.append(hlSuffix).append(highLightStr.charAt(i));
                    preCode = bitMap.contain(i);
                } else {
                    // 其他情况正常拼接
                    highLightBuilder.append(highLightStr.charAt(i));
                    preCode = bitMap.contain(i);
                }
            }
            return highLightBuilder.toString();
        }
        return defaultShow;
    }

}
