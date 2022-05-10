package pers.wellhor.text.exception;

import org.antlr.v4.runtime.*;

/**
 * 解析错误监听器
 *
 * @author robin luo
 * @version 1.0
 * @date 2022/5/10 10:59 上午
 **/
public class TextLexerErrorListener extends BaseErrorListener {

    public static final TextLexerErrorListener INSTANCE = new TextLexerErrorListener();

    private TextLexerErrorListener() {
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new TextGrammarException(line, charPositionInLine, getExpress(recognizer), msg);
    }


    private String getExpress(Recognizer<?, ?> recognizer) {
        if (recognizer != null) {
            IntStream inputStream = recognizer.getInputStream();
            if (inputStream instanceof CharStream) {
                CharStream charStream = (CharStream) inputStream;
                if (charStream != null) {
                    return charStream.toString();
                }
            }
        }
        return "";
    }

}
