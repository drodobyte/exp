package drodobyte.exp.model

sealed interface Exp {

    data class Num(val value: Int) : Exp
    data class Neg(val exp: Exp) : Exp
    data class Par(val exp: Exp) : Exp // Parenthesis
    data class Add(val left: Exp, val right: Exp) : Exp
    data class Sub(val left: Exp, val right: Exp) : Exp
    data class Mul(val left: Exp, val right: Exp) : Exp
    data class Div(val left: Exp, val right: Exp) : Exp
}
