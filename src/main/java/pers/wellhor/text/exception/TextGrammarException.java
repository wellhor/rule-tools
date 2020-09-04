package pers.wellhor.text.exception;

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

    public TextGrammarException(int line, int charPositionInLine, String msg) {
        super(msg);
        this.line = line;
        this.charPositionInLine = charPositionInLine;
    }

    public int getLine() {
        return line;
    }

    public int getCharPositionInLine() {
        return charPositionInLine;
    }

}
