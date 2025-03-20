// Generated from resources/Exp.g4 by ANTLR 4.13.2
package com.drodobyte.exp.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ExpParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code par}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPar(ExpParser.ParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code neg}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeg(ExpParser.NegContext ctx);
	/**
	 * Visit a parse tree produced by the {@code num}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(ExpParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulOrDiv}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOrDiv(ExpParser.MulOrDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addOrSub}
	 * labeled alternative in {@link ExpParser#exp()}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOrSub(ExpParser.AddOrSubContext ctx);
}
