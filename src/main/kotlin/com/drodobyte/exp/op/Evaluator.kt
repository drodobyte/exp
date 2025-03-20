package com.drodobyte.exp.op

import com.drodobyte.exp.model.Exp
import com.drodobyte.exp.model.Exp.Add
import com.drodobyte.exp.model.Exp.Div
import com.drodobyte.exp.model.Exp.Err
import com.drodobyte.exp.model.Exp.Mul
import com.drodobyte.exp.model.Exp.Neg
import com.drodobyte.exp.model.Exp.Num
import com.drodobyte.exp.model.Exp.Par
import com.drodobyte.exp.model.Exp.Sub

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
            is Div -> calc.div(left.value, right.value)
            is Err -> throw IllegalArgumentException("Invalid Expression")
        }

    private companion object {
        val calc = Calculator()
    }
}
