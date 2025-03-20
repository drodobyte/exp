package drodobyte.exp.op

import drodobyte.exp.model.Exp
import drodobyte.exp.model.Exp.Add
import drodobyte.exp.model.Exp.Div
import drodobyte.exp.model.Exp.Mul
import drodobyte.exp.model.Exp.Neg
import drodobyte.exp.model.Exp.Num
import drodobyte.exp.model.Exp.Par
import drodobyte.exp.model.Exp.Sub
import drodobyte.exp.model.ExpException
import drodobyte.exp.model.ExpException.What
import drodobyte.exp.model.ExpException.What.Invalid
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals


class ParserTest {

    @Test
    fun `parse number`() =
        " 2   " parse Num(2)

    @Test
    fun `parse par`() =
        " (2 )  " parse Par(Num(2))

    @Test
    fun `parse neg`() =
        " -2  " parse Neg(Num(2))

    @Test
    fun `parse add`() =
        " 2 + 1 " parse Add(Num(2), Num(1))

    @Test
    fun `parse sub`() =
        " 2 - 1 " parse Sub(Num(2), Num(1))

    @Test
    fun `parse mul`() =
        " 2 * 1 " parse Mul(Num(2), Num(1))

    @Test
    fun `parse div`() =
        " 2 / 1 " parse Div(Num(2), Num(1))

    @Test
    fun `parse exp`() =
        " 2 / 1 + 3 + 2 + 3 * 1" parse Add(Add(Add(Div(Num(2), Num(1)), Num(3)), Num(2)), Mul(Num(3), Num(1)))

    @Test
    fun `parse exp 2`() =
        " 2 / (1 + 3) + 2 + 3 * 1" parse
            Add(Add(Div(Num(2), Par(Add(Num(1), Num(3)))), Num(2)), Mul(Num(3), Num(1)))

    @Test
    fun `parse empty throws Invalid`() =
        "  " throws Invalid

    @Test
    fun `parse unrecognized symbol throws Invalid`() =
        " f " throws Invalid

    private infix fun String.parse(what: Exp) = assertEquals(what, exp)
    private infix fun String.throws(what: What) = assertEquals(what, assertThrows<ExpException> { exp }.what)
    private val String.exp get() = Parser(this).exp
}
