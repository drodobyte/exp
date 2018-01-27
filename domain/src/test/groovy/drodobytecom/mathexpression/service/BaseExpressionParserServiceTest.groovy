package drodobytecom.mathexpression.service

import drodobytecom.mathexpression.entity.Expression
import org.junit.Ignore
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

@Ignore("Not to be run: Base class for Testing parser service implementations")
abstract class BaseExpressionParserServiceTest {

    abstract ExpressionParserService instance()

    @Test
    void withoutSpacesSimple() {
        assertParse("2+2", "2 + 2")
    }

    @Test
    void withoutSpacesLong() {
        assertParse("2-1+3", "2 -1 + 3")
    }

    @Test
    void withoutSpaces() {
        assertParse("5-88", "5 -        88")
    }

    @Test(expected = ParserException.class)
    void invalidDoubleOperandExpression() {
        parse("2 - 1++ 3")
    }

    @Test
    void validMostSimpleExpression() {
        assertValid("2 + 2")
    }

    @Test
    void validateMoreThanOneDigitExpression() {
        assertValid("25 + 287")
    }

    @Test
    void validAllOperationsExpression() {
        assertValid("25 - 287")
        assertValid("25 + 287")
        assertValid("25 / 287")
        assertValid("25 * 287")
    }

    @Test
    void validWithSpaces() {
        assertValid("25  *      287")
        assertValid("25  *287")
        assertValid("  25*287")
        assertValid("25*287   ")
    }

    @Test
    void validComplexExpression() {
        assertValid("2 + 7 - 2 * 4")
    }

    @Test(expected = ParserException.class)
    void invalidWrongExpressions() {
        parse("2 s 7")
//        assertInvalid("2 + 7 a 2 b 4");
//        assertInvalid("2 + 7 3");
//        assertInvalid("2 3");
    }

    @Test(expected = ParserException.class)
    void validateMultipleOperators() {
        parse("2 ++ 7")
        parse("+ + 7")
        parse("2 + +")
    }

    @Test
    void validateWithNegativeNumbers() {
        assertValid("-2 + 2")
    }

    @Test
    void validateWithWrongNegativeNumbers() {
        assertValid("-2 - -2")
    }

    @Test
    void validateSuperComplexExpression() {
        assertValid("-7 - -1 * 2 / 3 + -5")
    }

    private void assertParse(String parsed, String expression) {
        assertEquals(parsed, parse(expression).toString())
    }

    private void assertValid(String expression) {
        assertNotNull(parse(expression))
    }

    private Expression parse(String expression) {
        return instance().parse(expression)
    }
}