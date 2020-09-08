package pers.wellhor.text.exception;

import org.antlr.v4.runtime.*;

/**
 * 解析错误监听器
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/9/4 3:32 下午
 **/
public class TextParseErrorListener extends BaseErrorListener {

    public static final TextParseErrorListener INSTANCE = new TextParseErrorListener();

    private TextParseErrorListener() {
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new TextGrammarException(line, charPositionInLine, getExpress(offendingSymbol), msg);
    }

    private String getExpress(Object offendingSymbol) {
        if(offendingSymbol instanceof CommonToken) {
            CommonToken commonToken = (CommonToken) offendingSymbol;
            CharStream charStream = commonToken.getInputStream();
            if(charStream != null) {
                return charStream.toString();
            }
        }
        return "";
    }

}
