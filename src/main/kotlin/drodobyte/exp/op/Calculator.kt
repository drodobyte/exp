package drodobyte.exp.op

import drodobyte.exp.model.ExpException
import drodobyte.exp.model.ExpException.What.DivByZero

internal class Calculator {
    fun neg(value: Int) = -value
    fun add(left: Int, right: Int) = left + right
    fun sub(left: Int, right: Int) = left - right
    fun mul(left: Int, right: Int) = left * right
    fun div(left: Int, right: Int) =
        if (right == 0) throw ExpException(DivByZero) else left / right
}
