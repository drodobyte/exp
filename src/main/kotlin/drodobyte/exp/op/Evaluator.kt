package drodobyte.exp.op

import drodobyte.exp.model.Exp
import drodobyte.exp.model.Exp.Add
import drodobyte.exp.model.Exp.Div
import drodobyte.exp.model.Exp.Mul
import drodobyte.exp.model.Exp.Neg
import drodobyte.exp.model.Exp.Num
import drodobyte.exp.model.Exp.Par
import drodobyte.exp.model.Exp.Sub

class Evaluator(exp: Exp) {
    val value = exp.value

    @Suppress("RecursivePropertyAccessor")
    private val Exp.value: Int
        get() = when (this) {
            is Num -> value
            is Par -> exp.value
            is Neg -> calc.neg(exp.value)
            is Add -> calc.add(left.value, right.value)
            is Sub -> calc.sub(left.value, right.value)
            is Mul -> calc.mul(left.value, right.value)
            is Div -> calc.div(dividend.value, divisor.value)
        }

    private companion object {
        val calc = Calculator()
    }
}
