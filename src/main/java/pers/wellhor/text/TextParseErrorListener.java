package pers.wellhor.text;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import pers.wellhor.text.exception.TextGrammarException;

/**
 * 解析错误监听器
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/9/4 3:32 下午
 **/
public class TextParseErrorListener extends BaseErrorListener {

    public static final TextParseErrorListener INSTANCE = new TextParseErrorListener();

    private TextParseErrorListener(){}

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new TextGrammarException(line, charPositionInLine, msg);
    }

}
