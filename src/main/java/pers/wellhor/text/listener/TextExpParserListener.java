package pers.wellhor.text.listener;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import pers.wellhor.text.parser.TextExpParser;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TextExpParser}.
 */
public interface TextExpParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TextExpParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(TextExpParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link TextExpParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(TextExpParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(TextExpParser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(TextExpParser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code afterWordExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAfterWordExpression(TextExpParser.AfterWordExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code afterWordExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAfterWordExpression(TextExpParser.AfterWordExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(TextExpParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(TextExpParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rparenExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRparenExpression(TextExpParser.RparenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rparenExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRparenExpression(TextExpParser.RparenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code roleWordExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRoleWordExpression(TextExpParser.RoleWordExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code roleWordExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRoleWordExpression(TextExpParser.RoleWordExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleWordExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSingleWordExpression(TextExpParser.SingleWordExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleWordExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSingleWordExpression(TextExpParser.SingleWordExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defaultDistanceAfter}
	 * labeled alternative in {@link TextExpParser#afterword}.
	 * @param ctx the parse tree
	 */
	void enterDefaultDistanceAfter(TextExpParser.DefaultDistanceAfterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defaultDistanceAfter}
	 * labeled alternative in {@link TextExpParser#afterword}.
	 * @param ctx the parse tree
	 */
	void exitDefaultDistanceAfter(TextExpParser.DefaultDistanceAfterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code distanceAfter}
	 * labeled alternative in {@link TextExpParser#afterword}.
	 * @param ctx the parse tree
	 */
	void enterDistanceAfter(TextExpParser.DistanceAfterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code distanceAfter}
	 * labeled alternative in {@link TextExpParser#afterword}.
	 * @param ctx the parse tree
	 */
	void exitDistanceAfter(TextExpParser.DistanceAfterContext ctx);
}