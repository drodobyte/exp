package drodobytecom.mathexpression.entity

import drodobytecom.mathexpression.service.FactoryService

final class FactoryImp implements FactoryService {

    @Override
    User user(long id, String name) {
        new UserImp(id, name)
    }

    @Override
    Expression expression(Expression expression) {
        if (expression.ANumber)
            number expression.number
        else if (expression.isNegate())
            negate expression.negated
        else if (expression.isParentheses())
            parentheses expression.parenthesed
        else if (expression.isAdd())
            add expression.left, expression.right
        else if (expression.isSubtract())
            subtract expression.left, expression.right
        else if (expression.isMultiply())
            multiply expression.left, expression.right
        else if (expression.isDivide())
            divide expression.left, expression.right
    }

    @Override
    Expression number(Integer value) {
        ExpressionImp.number value
    }

    @Override
    Expression add(Expression left, Expression right) {
        ExpressionImp.add left, right
    }

    @Override
    Expression subtract(Expression left, Expression right) {
        ExpressionImp.subtract left, right
    }

    @Override
    Expression multiply(Expression left, Expression right) {
        ExpressionImp.multiply left, right
    }

    @Override
    Expression divide(Expression left, Expression right) {
        ExpressionImp.divide left, right
    }

    @Override
    Expression parentheses(Expression expression) {
        ExpressionImp.parentheses expression
    }

    @Override
    Expression negate(Expression expression) {
        ExpressionImp.negate expression
    }
}
