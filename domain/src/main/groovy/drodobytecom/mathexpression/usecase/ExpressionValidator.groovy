package drodobytecom.mathexpression.usecase

import drodobytecom.core.check.BaseValidator
import drodobytecom.core.check.ValidationException
import drodobytecom.mathexpression.entity.Expression

class ExpressionValidator extends BaseValidator<Expression> {

    @Override
    void ok(Expression expression) throws ValidationException {
        check.notNull expression, "expression missing"
        if (expression.isANumber())
            check.notNull expression.number, "number missing"
        else if (expression.isNegate())
            check.notNull expression.negated, "negation missing"
        else if (expression.isParentheses())
            check.notNull expression.parenthesed, "parentheses missing"
        else { // binary
            check.notNull expression.left, "left expression missing"
            check.notNull expression.right, "right expression missing"
        }
    }
}