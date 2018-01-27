package drodobytecom.mathexpression.service

import drodobytecom.mathexpression.entity.FactoryImp

class ExpressionParserServiceTest extends BaseExpressionParserServiceTest {

    @Override
    ExpressionParserService instance() {
        new AntlrExpressionParserService(new FactoryImp())
    }
}
