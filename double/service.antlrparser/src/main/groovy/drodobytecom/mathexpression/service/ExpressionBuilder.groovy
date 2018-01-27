package drodobytecom.mathexpression.service

import drodobytecom.mathexpression.entity.Expression

class ExpressionBuilder {

    Stack<Expression> expressions = new Stack<>()

    def getExpression() {
        expressions.pop()
    }

    def addNumber(Expression numberExpression) {
        expressions.push numberExpression
    }

    def addUnaryOperation(Closure<Expression> unaryOperation) {
        def expression = expressions.pop()
        def unaryOperationExpression = unaryOperation expression
        expressions.push unaryOperationExpression
    }

    def addBinaryOperation(Closure<Expression> binaryOperation) {
        Expression rightExpression = expressions.pop()
        Expression leftExpression = expressions.pop()
        def binaryOperationExpression = binaryOperation leftExpression, rightExpression
        expressions.push binaryOperationExpression
    }
}
