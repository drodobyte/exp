// Generated from /home/dev/draft/mathexpression/detail/src/main/resources/Expression.g4 by ANTLR 4.7
package drodobytecom.mathexpression.service.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code MultiplyOrDivide}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyOrDivide(ExpressionParser.MultiplyOrDivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplyOrDivide}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyOrDivide(ExpressionParser.MultiplyOrDivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddOrSubtract}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddOrSubtract(ExpressionParser.AddOrSubtractContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddOrSubtract}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddOrSubtract(ExpressionParser.AddOrSubtractContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegate(ExpressionParser.NegateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegate(ExpressionParser.NegateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(ExpressionParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(ExpressionParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInt(ExpressionParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInt(ExpressionParser.IntContext ctx);
}