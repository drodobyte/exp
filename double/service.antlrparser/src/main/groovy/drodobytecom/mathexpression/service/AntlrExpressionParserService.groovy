package drodobytecom.mathexpression.service

import drodobytecom.mathexpression.entity.Expression

class AntlrExpressionParserService implements ExpressionParserService {

    private FactoryService factoryService

    AntlrExpressionParserService(FactoryService factoryService) {
        this.factoryService = factoryService
    }

    @Override
    Expression parse(String expression) throws ParserException {
        new StringExpressionAdapter(factoryService).adapt expression
    }
}
