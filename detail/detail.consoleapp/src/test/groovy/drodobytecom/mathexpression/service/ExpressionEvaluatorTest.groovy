package drodobytecom.mathexpression.service

import drodobytecom.mathexpression.entity.Builder
import drodobytecom.mathexpression.entity.FactoryImp
import drodobytecom.mathexpression.usecase.BaseExpressionEvaluatorTest

class ExpressionEvaluatorTest extends BaseExpressionEvaluatorTest {

    @Override
    Builder builder() {
        new Builder(new FactoryImp())
    }
}
