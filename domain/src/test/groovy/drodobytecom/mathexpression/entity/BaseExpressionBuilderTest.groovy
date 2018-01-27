package drodobytecom.mathexpression.entity

import drodobytecom.core.check.ArgumentException
import drodobytecom.mathexpression.usecase.BaseDomainTest
import org.junit.Ignore
import org.junit.Test

import static org.junit.Assert.assertTrue

@Ignore('not to be run: base test class for testing expression Builder')
abstract class BaseExpressionBuilderTest extends BaseDomainTest {

    @Test
    void simple1() {
        Expression one = builder().num(1)
        Expression otherOne = builder().num 1
        assertNumber 1, one
        assertNumber 1, otherOne
    }

    @Test
    void simpleNegated1() {
        Expression minusOne = builder().neg { num 1 }
        assertTrue minusOne.isNegate()
        assertNumber 1, minusOne.negated
    }

    @Test
    void simpleParentheses() {
        Expression parentheses = builder().par { num 1 }
        assertTrue parentheses.isParentheses()
        assertNumber 1, parentheses.parenthesed
    }

    @Test
    void simpleAdd() {
        Expression add = builder().add { num 1; num 2 }
        assertTrue add.isAdd()
        assertNumber 1, add.left
        assertNumber 2, add.right
    }

    @Test
    void simpleSubtract() {
        Expression subtract = builder().sub { num 1; num 2 }
        assertTrue subtract.isSubtract()
        assertNumber 1, subtract.left
        assertNumber 2, subtract.right
    }

    @Test
    void simpleMultiply() {
        Expression multiply = builder().mul { num 1; num 2 }
        assertTrue multiply.isMultiply()
        assertNumber 1, multiply.left
        assertNumber 2, multiply.right
    }

    @Test
    void simpleDivide() {
        Expression divide = builder().div { num 1; num 2 }
        assertTrue divide.isDivide()
        assertNumber 1, divide.left
        assertNumber 2, divide.right
    }

    @Test(expected = ArgumentException)
    void wrongNumber() {
        builder().num()
    }

    @Test(expected = ArgumentException)
    void wrongNumber2() {
        builder().num(null)
    }

    @Test(expected = ArgumentException)
    void wrongNegateEmpty() {
        builder().neg()
    }

    @Test(expected = ArgumentException)
    void wrongNegateEmpty2() {
        builder().neg() {}
    }

    @Test(expected = ArgumentException)
    void wrongNegateNotUnary() {
        builder().neg() { num 1; num 2 }
    }

    @Test(expected = ArgumentException)
    void wrongParenthesesEmpty() {
        builder().par()
    }

    @Test(expected = ArgumentException)
    void wrongParenthesesEmpty2() {
        builder().par() {}
    }

    @Test(expected = ArgumentException)
    void wrongParenthesesNotUnary() {
        builder().par() { num 1; num 2 }
    }

    @Test(expected = ArgumentException)
    void wrongAddEmpty() {
        builder().add()
    }

    @Test(expected = ArgumentException)
    void wrongAddUnary() {
        builder().add { num 1 }
    }

    @Test(expected = ArgumentException)
    void wrongAddTernary() {
        builder().add { num 1; num 2; num 3 }
    }

    @Test(expected = ArgumentException)
    void wrongSubtractEmpty() {
        builder().sub()
    }

    @Test(expected = ArgumentException)
    void wrongSubtractUnary() {
        builder().sub { num 1 }
    }

    @Test(expected = ArgumentException)
    void wrongSubtractTernary() {
        builder().sub { num 1; num 2; num 3 }
    }

    @Test(expected = ArgumentException)
    void wrongMultiplyEmpty() {
        builder().mul()
    }

    @Test(expected = ArgumentException)
    void wrongMultiplyUnary() {
        builder().mul { num 1 }
    }

    @Test(expected = ArgumentException)
    void wrongMultiplyTernary() {
        builder().mul { num 1; num 2; num 3 }
    }

    @Test(expected = ArgumentException)
    void wrongDivideEmpty() {
        builder().div()
    }

    @Test(expected = ArgumentException)
    void wrongDivideUnary() {
        builder().div { num 1 }
    }

    @Test(expected = ArgumentException)
    void wrongDivideTernary() {
        builder().div { num 1; num 2; num 3 }
    }
}
