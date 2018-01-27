package drodobytecom.mathexpression.usecase

import drodobytecom.mathexpression.entity.Builder
import drodobytecom.mathexpression.entity.Expression
import drodobytecom.mathexpression.service.ExpressionParserService
import org.junit.Ignore

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

@Ignore("Not to be run: Base class for Domain Tests")
abstract class BaseDomainTest {

    abstract Builder builder()

    static assertEvaluation(int expected, String userExpression, Expression parsedExpression) {
        ExpressionParserService parser = parserMock()
        when(parser.parse(userExpression)).thenReturn parsedExpression
        assertEquals expected, evaluator(parser).evaluate(userExpression)
    }

    static assertNumber(Integer expected, Expression number) {
        assertTrue number.isANumber()
        assertEquals expected, number.number
    }

    static evaluator(ExpressionParserService parser) {
        new ExpressionEvaluator(parser, operator(), new ExpressionValidator())
    }

    static parserMock() {
        mock(ExpressionParserService)
    }

    static def operator() {
        operator(-100, 100)
    }

    static def operator(int min, int max) {
        new CalculatorOperator(new Calculator(), new LimitValidator(min, max))
    }
}
