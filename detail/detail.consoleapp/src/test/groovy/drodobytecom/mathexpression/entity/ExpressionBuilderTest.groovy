package drodobytecom.mathexpression.entity

class ExpressionBuilderTest extends BaseExpressionBuilderTest {

    @Override
    Builder builder() {
        new Builder(new FactoryImp())
    }
}
