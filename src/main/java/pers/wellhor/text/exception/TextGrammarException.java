package pers.wellhor.text.exception;

import pers.wellhor.text.utils.CommonsUtils;

/**
 * 文本语法异常
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/9/4 3:36 下午
 **/
public class TextGrammarException extends RuntimeException {

    /**
     * 报错所在行
     */
    private int line;

    /**
     * 报错所在列
     */
    private int charPositionInLine;

    /**
     * 表达式
     */
    private String express;

    public TextGrammarException(int line, int charPositionInLine, String express, String msg) {
        super(msg);
        this.line = line;
        this.express = express;
        this.charPositionInLine = charPositionInLine;
    }

    public int getLine() {
        return line;
    }

    public int getCharPositionInLine() {
        return charPositionInLine;
    }

    public String getExpress() {
        return express;
    }

    public String printEnglishErrorTip() {
        return printErrorTip("  [A Grammar Error Near Line:%d Position:%d]");
    }

    public String printChineseErrorTip() {
        return printErrorTip("  [第%d行的第%d个字符附近有语法错误]");
    }


    public String printErrorTip(String tipFormat) {
        StringBuilder builder = new StringBuilder();
        String express = getExpress();
        if(CommonsUtils.isNotEmpty(express)) {
            String[] es = express.split("[\r\n]");
            int line = this.getLine();
            int position = this.getCharPositionInLine();
            if(CommonsUtils.isNotEmpty(es) && es.length >= line) {
                String lineText = es[line - 1];
                builder.append(lineText);
                builder.insert(position, " ⇨ ");
                builder.append(String.format(tipFormat, line, position));
            }
        }
        return builder.toString();
    }


}
