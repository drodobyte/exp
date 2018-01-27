package drodobytecom.mathexpression.usecase

import drodobytecom.core.check.ValidationException
import drodobytecom.mathexpression.entity.Expression
import org.junit.Ignore
import org.junit.Test

@Ignore("Not to be run: Base class for Testing Evaluator Test")
abstract class BaseExpressionEvaluatorTest extends BaseDomainTest {

    @Test
    void evalConstant() {
        Expression value = builder().num 22
        assertEvaluation 22, "22", value
    }

    @Test
    void evalAdd() {
        Expression add = builder().add { num 2; num 2 }
        assertEvaluation 4, "2+2", add
    }

    @Test
    void evalNeg() {
        Expression sub = builder().neg { num 2 }
        assertEvaluation(-2, "-2", sub)
    }

    @Test
    void evalPar() {
        Expression sub = builder().par { num 2 }
        assertEvaluation(2, "(2)", sub)
    }

    @Test
    void evalSub() {
        Expression sub = builder().sub { num 2; num 2 }
        assertEvaluation 0, "2-2", sub
    }

    @Test
    void evalMul() {
        Expression mul = builder().mul { num 2; num 2 }
        assertEvaluation 4, "2*2", mul
    }

    @Test
    void evalDiv() {
        Expression div = builder().div { num 2; num 2 }
        assertEvaluation 1, "2/2", div
    }

    @Test
    void process2Operators() {
        Expression add = builder().add { num 3; add { num 1; num 2 } }
        assertEvaluation 6, "3+1+2", add
    }

    @Test(expected = ValidationException)
    void invalidExpression() {
        Expression add = builder().add { num 3; add { num() ; num 2 } }
        assertEvaluation 6, "3+ +2", add
    }
}
