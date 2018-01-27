package drodobytecom.mathexpression.usecase

import drodobytecom.mathexpression.service.ExpressionParserService

class UserWritesExpressionUseCase implements In {

    interface In {
        void userExpression(String expression, Out out)
    }

    interface Out {
        void provide(Integer result)

        void provide(Exception e)
    }

    private ExpressionParserService parser

    UserWritesExpressionUseCase(ExpressionParserService parser) {
        this.parser = parser
    }

    void userExpression(String expression, Out out) {
        try {
            out.provide newEvaluator().evaluate(expression)
        } catch (Exception e) {
            out.provide(e)
        }
    }

    private newEvaluator() {
        def operator = new CalculatorOperator(new Calculator(), new LimitValidator(-100, 100))
        new ExpressionEvaluator(parser, operator, new ExpressionValidator())
    }
}
