package drodobytecom.mathexpression.usecase

import drodobytecom.core.check.Validator
import drodobytecom.mathexpression.entity.Expression
import drodobytecom.mathexpression.service.ExpressionParserService

class ExpressionEvaluator {

    private CalculatorOperator operator
    private ExpressionParserService parser
    private Validator<Expression> validator

    ExpressionEvaluator(ExpressionParserService parser, CalculatorOperator operator, Validator<Expression> validator) {
        this.validator = validator
        this.parser = parser
        this.operator = operator
    }

    int evaluate(String expression) {
        evaluate parser.parse(expression)
    }

    int evaluate(Expression expression) {
        validator?.ok expression
        if (expression.isANumber())
            operator.validate expression.number
        else if (expression.isParentheses())
            evaluate(expression.parenthesed)
        else if (expression.isNegate())
            operator.negate evaluate(expression.negated)
        else if (expression.isAdd())
            operator.add evaluate(expression.left), evaluate(expression.right)
        else if (expression.isSubtract())
            operator.subtract evaluate(expression.left), evaluate(expression.right)
        else if (expression.isMultiply())
            operator.multiply evaluate(expression.left), evaluate(expression.right)
        else if (expression.isDivide())
            operator.divide evaluate(expression.left), evaluate(expression.right)
    }
}
