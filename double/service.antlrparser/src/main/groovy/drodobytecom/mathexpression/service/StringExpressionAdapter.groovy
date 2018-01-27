package drodobytecom.mathexpression.service

import drodobytecom.mathexpression.entity.Expression
import drodobytecom.mathexpression.service.gen.ExpressionParser
import org.antlr.v4.runtime.RecognitionException

import static java.lang.Integer.parseInt

class StringExpressionAdapter extends BaseExpressionParser {

    private ExpressionBuilder builder
    private FactoryService factory

    StringExpressionAdapter(FactoryService factory) {
        this.factory = factory
    }

    Expression adapt(String expression) {
        builder = new ExpressionBuilder()
        parseAndListen expression
        builder.expression
    }

    @Override
    protected void number(ExpressionParser.IntContext ctx) {
        builder.addNumber asNumber(ctx)
    }

    @Override
    protected void addOrSubtract(ExpressionParser.AddOrSubtractContext ctx) {
        builder.addBinaryOperation asOperation(ctx)
    }

    @Override
    protected void multiplyOrDivide(ExpressionParser.MultiplyOrDivideContext ctx) {
        builder.addBinaryOperation asOperation(ctx)
    }

    @Override
    protected void parentheses(ExpressionParser.ParenthesesContext ctx) {
        builder.addUnaryOperation asOperation(ctx)
    }

    @Override
    protected void negate(ExpressionParser.NegateContext ctx) {
        builder.addUnaryOperation asOperation(ctx)
    }

    @Override
    protected void error(RecognitionException e) {
        throw new ParserException(e)
    }

    private Expression asNumber(ExpressionParser.IntContext number) {
        factory.number parseInt(number.text)
    }

    private Closure<Expression> asOperation(ExpressionParser.ExpressionContext operation) {
        if (operation instanceof ExpressionParser.NegateContext)
            return factory.&negate
        else if (operation instanceof ExpressionParser.ParenthesesContext)
            return factory.&parentheses
        else
            switch (operation.getChild(1).text) {
                case "+": return factory.&add
                case "-": return factory.&subtract
                case "*": return factory.&multiply
                case "/": return factory.&divide
            }
    }
}
