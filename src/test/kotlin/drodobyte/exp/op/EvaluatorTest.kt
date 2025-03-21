package drodobyte.exp.op

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EvaluatorTest {

    @Test
    fun `3 = 3`() =
        "3" eq 3

    @Test
    fun `3+4 = 7`() =
        "3+4" eq 7

    @Test
    fun `3-4 = -1`() =
        "3-4" eq -1

    @Test
    fun `3 x 4 = 12`() =
        "3*4" eq 12

    @Test
    fun `4 div 1 = 1`() =
        "4/4" eq 1

    @Test
    fun `4 x (3 + 1) = 16`() =
        "4 * (3 + 1)" eq 16

    @Test
    fun `4 x 3 + 1 = 13`() =
        "4 * 3 + 1" eq 13

    @Test
    fun `4 x 3 + -1 = 11`() =
        "4 * 3 + -1" eq 11

    private infix fun String.eq(other: Int) = assertEquals(value, other)
    private val String.value get() = Evaluator(Parser(this).exp).value
}
