package pers.wellhor.text.visitor;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import pers.wellhor.text.parser.TextExpParser;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TextExpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TextExpParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TextExpParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(TextExpParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpression(TextExpParser.BinaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code afterWordExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfterWordExpression(TextExpParser.AfterWordExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(TextExpParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rparenExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRparenExpression(TextExpParser.RparenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code roleWordExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoleWordExpression(TextExpParser.RoleWordExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleWordExpression}
	 * labeled alternative in {@link TextExpParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleWordExpression(TextExpParser.SingleWordExpressionContext ctx);
}