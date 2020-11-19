// Generated from /Users/wellhor/Projects/IdeaProjects/RuleTools/src/main/resources/g4/TextExpParser.g4 by ANTLR 4.8
package pers.wellhor.text.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;
import pers.wellhor.text.listener.TextExpParserListener;
import pers.wellhor.text.visitor.TextExpParserVisitor;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TextExpParser extends Parser {
	public static final int
			LPAREN = 1, RPAREN = 2, AND = 3, OR = 4, NOT = 5, AFTER = 6, ROLE_WORD = 7, WORD = 8,
			STAR = 9, UPPERCASE = 10, WS = 11;
	public static final int
			RULE_root = 0, RULE_expression = 1;
	public static final String _serializedATN =
			"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\r/\4\2\t\2\4\3\t" +
					"\3\3\2\3\2\3\2\6\2\n\n\2\r\2\16\2\13\3\2\3\2\3\2\3\2\3\2\5\2\23\n\2\3" +
					"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3!\n\3\r\3\16\3\"\5\3" +
					"%\n\3\3\3\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\3\2\3\4\4\2\4\2\4\3\2\5\6" +
					"\3\2\t\n\2\65\2\22\3\2\2\2\4$\3\2\2\2\6\t\5\4\3\2\7\b\t\2\2\2\b\n\5\4" +
					"\3\2\t\7\3\2\2\2\n\13\3\2\2\2\13\t\3\2\2\2\13\f\3\2\2\2\f\23\3\2\2\2\r" +
					"\16\5\4\3\2\16\17\7\2\2\3\17\23\3\2\2\2\20\21\7\13\2\2\21\23\7\2\2\3\22" +
					"\6\3\2\2\2\22\r\3\2\2\2\22\20\3\2\2\2\23\3\3\2\2\2\24\25\b\3\1\2\25\26" +
					"\7\7\2\2\26%\5\4\3\7\27\30\7\3\2\2\30\31\5\4\3\2\31\32\7\4\2\2\32%\3\2" +
					"\2\2\33%\7\n\2\2\34%\7\t\2\2\35 \t\3\2\2\36\37\7\b\2\2\37!\t\3\2\2 \36" +
					"\3\2\2\2!\"\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#%\3\2\2\2$\24\3\2\2\2$\27\3" +
					"\2\2\2$\33\3\2\2\2$\34\3\2\2\2$\35\3\2\2\2%+\3\2\2\2&\'\f\b\2\2\'(\t\2" +
					"\2\2(*\5\4\3\t)&\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-+\3" +
					"\2\2\2\7\13\22\"$+";
	public static final ATN _ATN =
			new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
			new PredictionContextCache();
	public static final String[] ruleNames = makeRuleNames();

	static {
		RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION);
	}

	private static final String[] _LITERAL_NAMES = makeLiteralNames();

	public TextExpParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;

	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() {
		return "TextExpParser.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	private static String[] makeRuleNames() {
		return new String[]{
				"root", "expression"
		};
	}

	private static String[] makeLiteralNames() {
		return new String[]{
				null, "'('", "')'", "'&'", "'|'", "'!'", "'#'", null, null, "'*'"
		};
	}

	private static String[] makeSymbolicNames() {
		return new String[]{
				null, "LPAREN", "RPAREN", "AND", "OR", "NOT", "AFTER", "ROLE_WORD", "WORD",
				"STAR", "UPPERCASE", "WS"
		};
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			setState(16);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(4);
					expression(0);
					setState(7);
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
							{
								setState(5);
								_la = _input.LA(1);
								if(!(_la == AND || _la == OR)) {
									_errHandler.recoverInline(this);
								} else {
									if(_input.LA(1) == Token.EOF) matchedEOF = true;
									_errHandler.reportMatch(this);
									consume();
								}
								setState(6);
								expression(0);
							}
						}
						setState(9);
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while (_la == AND || _la == OR);
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(11);
					expression(0);
					setState(12);
					match(EOF);
				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(14);
					match(STAR);
					setState(15);
					match(EOF);
				}
				break;
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(34);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
					case 1: {
						_localctx = new NotExpressionContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;

						setState(19);
						match(NOT);
						setState(20);
						expression(5);
					}
					break;
					case 2: {
						_localctx = new RparenExpressionContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(21);
						match(LPAREN);
						setState(22);
						expression(0);
						setState(23);
						match(RPAREN);
					}
					break;
					case 3: {
						_localctx = new SingleWordExpressionContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(25);
						match(WORD);
					}
					break;
					case 4: {
						_localctx = new RoleWordExpressionContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(26);
						match(ROLE_WORD);
					}
					break;
					case 5: {
						_localctx = new AfterWordExpressionContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(27);
						_la = _input.LA(1);
						if(!(_la == ROLE_WORD || _la == WORD)) {
							_errHandler.recoverInline(this);
						} else {
							if(_input.LA(1) == Token.EOF) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(30);
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
								case 1: {
									{
										{
											setState(28);
											match(AFTER);
										}
										setState(29);
										_la = _input.LA(1);
										if(!(_la == ROLE_WORD || _la == WORD)) {
											_errHandler.recoverInline(this);
										} else {
											if(_input.LA(1) == Token.EOF) matchedEOF = true;
											_errHandler.reportMatch(this);
											consume();
										}
									}
								}
								break;
								default:
									throw new NoViableAltException(this);
							}
							setState(32);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input, 2, _ctx);
						} while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
					}
					break;
				}
				_ctx.stop = _input.LT(-1);
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if(_alt == 1) {
						if(_parseListeners != null) triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							{
								_localctx = new BinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
								((BinaryExpressionContext) _localctx).leftExpr = _prevctx;
								pushNewRecursionContext(_localctx, _startState, RULE_expression);
								setState(36);
								if(!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
								setState(37);
								((BinaryExpressionContext) _localctx).operator = _input.LT(1);
								_la = _input.LA(1);
								if(!(_la == AND || _la == OR)) {
									((BinaryExpressionContext) _localctx).operator = (Token) _errHandler.recoverInline(this);
								} else {
									if(_input.LA(1) == Token.EOF) matchedEOF = true;
									_errHandler.reportMatch(this);
									consume();
								}
								setState(38);
								((BinaryExpressionContext) _localctx).rightExpr = expression(7);
							}
						}
					}
					setState(43);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
			case 1:
				return expression_sempred((ExpressionContext) _localctx, predIndex);
		}
		return true;
	}

	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
			case 0:
				return precpred(_ctx, 6);
		}
		return true;
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	public static class RootContext extends ParserRuleContext {
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public List<TerminalNode> AND() {
			return getTokens(TextExpParser.AND);
		}

		public TerminalNode AND(int i) {
			return getToken(TextExpParser.AND, i);
		}

		public List<TerminalNode> OR() {
			return getTokens(TextExpParser.OR);
		}

		public TerminalNode OR(int i) {
			return getToken(TextExpParser.OR, i);
		}

		public TerminalNode EOF() {
			return getToken(TextExpParser.EOF, 0);
		}

		public TerminalNode STAR() {
			return getToken(TextExpParser.STAR, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_root;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if(listener instanceof TextExpParserListener) ((TextExpParserListener) listener).enterRoot(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if(listener instanceof TextExpParserListener) ((TextExpParserListener) listener).exitRoot(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if(visitor instanceof TextExpParserVisitor)
				return ((TextExpParserVisitor<? extends T>) visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public ExpressionContext() {
		}

		@Override
		public int getRuleIndex() {
			return RULE_expression;
		}

		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}

	public static class BinaryExpressionContext extends ExpressionContext {
		public ExpressionContext leftExpr;
		public Token operator;
		public ExpressionContext rightExpr;

		public BinaryExpressionContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public TerminalNode AND() {
			return getToken(TextExpParser.AND, 0);
		}

		public TerminalNode OR() {
			return getToken(TextExpParser.OR, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if(listener instanceof TextExpParserListener)
				((TextExpParserListener) listener).enterBinaryExpression(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if(listener instanceof TextExpParserListener) ((TextExpParserListener) listener).exitBinaryExpression(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if(visitor instanceof TextExpParserVisitor)
				return ((TextExpParserVisitor<? extends T>) visitor).visitBinaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class NotExpressionContext extends ExpressionContext {
		public NotExpressionContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		public TerminalNode NOT() {
			return getToken(TextExpParser.NOT, 0);
		}

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if(listener instanceof TextExpParserListener) ((TextExpParserListener) listener).enterNotExpression(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TextExpParserListener ) ((TextExpParserListener)listener).exitNotExpression(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TextExpParserVisitor ) return ((TextExpParserVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class RparenExpressionContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(TextExpParser.LPAREN, 0); }

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}

		public TerminalNode RPAREN() { return getToken(TextExpParser.RPAREN, 0); }

		public RparenExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }

		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TextExpParserListener ) ((TextExpParserListener)listener).enterRparenExpression(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TextExpParserListener ) ((TextExpParserListener)listener).exitRparenExpression(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TextExpParserVisitor ) return ((TextExpParserVisitor<? extends T>)visitor).visitRparenExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class RoleWordExpressionContext extends ExpressionContext {
		public TerminalNode ROLE_WORD() { return getToken(TextExpParser.ROLE_WORD, 0); }

		public RoleWordExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }

		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TextExpParserListener ) ((TextExpParserListener)listener).enterRoleWordExpression(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TextExpParserListener ) ((TextExpParserListener)listener).exitRoleWordExpression(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TextExpParserVisitor ) return ((TextExpParserVisitor<? extends T>)visitor).visitRoleWordExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class SingleWordExpressionContext extends ExpressionContext {
		public TerminalNode WORD() { return getToken(TextExpParser.WORD, 0); }

		public SingleWordExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }

		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TextExpParserListener ) ((TextExpParserListener)listener).enterSingleWordExpression(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if(listener instanceof TextExpParserListener)
				((TextExpParserListener) listener).exitSingleWordExpression(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if(visitor instanceof TextExpParserVisitor)
				return ((TextExpParserVisitor<? extends T>) visitor).visitSingleWordExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public static class AfterWordExpressionContext extends ExpressionContext {
		public AfterWordExpressionContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		public List<TerminalNode> WORD() {
			return getTokens(TextExpParser.WORD);
		}

		public TerminalNode WORD(int i) {
			return getToken(TextExpParser.WORD, i);
		}

		public List<TerminalNode> ROLE_WORD() {
			return getTokens(TextExpParser.ROLE_WORD);
		}

		public TerminalNode ROLE_WORD(int i) {
			return getToken(TextExpParser.ROLE_WORD, i);
		}

		public List<TerminalNode> AFTER() {
			return getTokens(TextExpParser.AFTER);
		}

		public TerminalNode AFTER(int i) {
			return getToken(TextExpParser.AFTER, i);
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if(listener instanceof TextExpParserListener)
				((TextExpParserListener) listener).enterAfterWordExpression(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if(listener instanceof TextExpParserListener)
				((TextExpParserListener) listener).exitAfterWordExpression(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if(visitor instanceof TextExpParserVisitor)
				return ((TextExpParserVisitor<? extends T>) visitor).visitAfterWordExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}