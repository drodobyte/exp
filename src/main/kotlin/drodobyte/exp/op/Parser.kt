package drodobyte.exp.op

import drodobyte.exp.gen.ExpBaseVisitor
import drodobyte.exp.gen.ExpLexer
import drodobyte.exp.gen.ExpParser
import drodobyte.exp.gen.ExpParser.AddOrSubContext
import drodobyte.exp.gen.ExpParser.ExpContext
import drodobyte.exp.gen.ExpParser.MulOrDivContext
import drodobyte.exp.gen.ExpParser.NegContext
import drodobyte.exp.gen.ExpParser.NumContext
import drodobyte.exp.gen.ExpParser.ParContext
import drodobyte.exp.model.Exp
import drodobyte.exp.model.Exp.Add
import drodobyte.exp.model.Exp.Div
import drodobyte.exp.model.Exp.Err
import drodobyte.exp.model.Exp.Mul
import drodobyte.exp.model.Exp.Neg
import drodobyte.exp.model.Exp.Num
import drodobyte.exp.model.Exp.Par
import drodobyte.exp.model.Exp.Sub
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class Parser(exp: String) {
    val exp by lazy { exp.parse }

    private val String.parse
        get() = runCatching { Visitor().visit(expr)!! }.getOrElse { Err }

    private val String.expr
        get() = ExpParser(
            CommonTokenStream(
                ExpLexer(
                    CharStreams.fromString(
                        this
                    )
                )
            )
        ).exp()

    private inner class Visitor : ExpBaseVisitor<Exp>() {

        override fun visitNum(ctx: NumContext) = Num(ctx.text.toInt())

        override fun visitNeg(ctx: NegContext) = Neg(ctx.exp)

        override fun visitPar(ctx: ParContext) = Par(ctx.exp)

        override fun visitAddOrSub(ctx: AddOrSubContext) =
            when (ctx.op) {
                "+" -> Add(ctx.left, ctx.right)
                else -> Sub(ctx.left, ctx.right)
            }

        override fun visitMulOrDiv(ctx: MulOrDivContext) =
            when (ctx.op) {
                "*" -> Mul(ctx.left, ctx.right)
                else -> Div(ctx.left, ctx.right)
            }

        private val ExpContext.left get() = visit(getChild(0))
        private val ExpContext.right get() = visit(getChild(2))
        private val ExpContext.exp get() = left
        private val ExpContext.op get() = getChild(1).text
    }
}
