package drodobyte.exp.model

import kotlin.Exception

class ExpException(val what: What) : Exception() {

    enum class What { Invalid, DivByZero }
}
