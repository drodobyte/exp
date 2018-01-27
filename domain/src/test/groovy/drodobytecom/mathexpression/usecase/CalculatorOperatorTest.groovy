package drodobytecom.mathexpression.usecase

import drodobytecom.core.check.ValidationException
import drodobytecom.mathexpression.entity.Builder
import org.junit.Test

import static org.junit.Assert.assertEquals

class CalculatorOperatorTest extends BaseDomainTest {

    @Test
    void add() {
        assertEquals 4, operator().add(2, 2)
    }

    @Test
    void subtract() {
        assertEquals 2, operator().subtract(5, 3)
    }

    @Test
    void negate() {
        assertEquals(-5, operator().negate(5))
    }

    @Test
    void multiply() {
        assertEquals 10, operator().multiply(5, 2)
    }

    @Test
    void divide() {
        assertEquals 5, operator().divide(10, 2)
    }

    @Test
    void addWithDifferentArguments() {
        assertEquals 7, operator().add(2, 5)
    }

    @Test
    void subtractReturnNegative() {
        assertEquals(-2, operator().subtract(3, 5))
    }

    @Test(expected = ValidationException)
    void argumentsExceedLimit() {
        operator(-10, 10).add(30, 50)
    }

    @Test(expected = ValidationException)
    void argumentsExceedLimitInverse() {
        operator(-10, 10).add(-30, -50)
    }

    @Test(expected = ValidationException)
    void validateResultExceedingUpperLimit() {
        operator(-10, 10).add(10, 10)
    }

    @Test(expected = ValidationException)
    void validateResultExceedingLowerLimit() {
        operator(-10, 10).add(-10, -1)
    }

    @Test(expected = ValidationException)
    void subtractExceedingLowerLimit() {
        operator().subtract(10, 150)
    }

    @Test(expected = ValidationException)
    void addExceedingUpperLimit() {
        operator().add(10, 150)
    }

    @Test(expected = ValidationException)
    void subtractArgumentExceed() {
        operator().subtract(101, -101)
    }

    @Test(expected = ValidationException)
    void addArgumentExceed() {
        operator().add(101, -101)
    }

    @Test(expected = ValidationException)
    void addResultExceed() {
        operator().add(100, 100)
    }

    @Test(expected = ValidationException)
    void subtractResultExceed() {
        operator().subtract(-100, 100)
    }

    @Test
    void subtractUsingValidator() {
    }

    @Override
    Builder builder() {
        return null
    }
}
