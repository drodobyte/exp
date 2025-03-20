// Generated from resources/Exp.g4 by ANTLR 4.13.2
package drodobyte.exp.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpParser}.
 */
public interface ExpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExpParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExpParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code par}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 */
	void enterPar(ExpParser.ParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code par}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 */
	void exitPar(ExpParser.ParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code neg}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 */
	void enterNeg(ExpParser.NegContext ctx);
	/**
	 * Exit a parse tree produced by the {@code neg}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 */
	void exitNeg(ExpParser.NegContext ctx);
	/**
	 * Enter a parse tree produced by the {@code num}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 */
	void enterNum(ExpParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code num}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 */
	void exitNum(ExpParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulOrDiv}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 */
	void enterMulOrDiv(ExpParser.MulOrDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulOrDiv}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 */
	void exitMulOrDiv(ExpParser.MulOrDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addOrSub}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 */
	void enterAddOrSub(ExpParser.AddOrSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addOrSub}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 */
	void exitAddOrSub(ExpParser.AddOrSubContext ctx);
}
