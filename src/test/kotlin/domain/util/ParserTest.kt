package domain.util

import com.drodobyte.exp.model.Exp
import com.drodobyte.exp.model.Exp.Add
import com.drodobyte.exp.model.Exp.Div
import com.drodobyte.exp.model.Exp.Err
import com.drodobyte.exp.model.Exp.Mul
import com.drodobyte.exp.model.Exp.Neg
import com.drodobyte.exp.model.Exp.Num
import com.drodobyte.exp.model.Exp.Par
import com.drodobyte.exp.model.Exp.Sub
import com.drodobyte.exp.op.Parser
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
    fun `parse empty as Err`() =
        "  " parse Err

    @Test
    fun `parse unrecognized symbol as Err`() =
        " f " parse Err

    @Test
    fun `parse malformed as Err`() =
        " 1 2 " parse Err

    private infix fun String.parse(what: Exp) = assertEquals(what, Parser(this).exp)
}
