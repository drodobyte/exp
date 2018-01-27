package drodobytecom.mathexpression

import drodobytecom.mathexpression.entity.FactoryImp
import drodobytecom.mathexpression.service.*

/**
 * CDI injected dependencies container
 */
class Context {

    static FactoryService factory = new FactoryImp()
    static ExpressionParserService parser = new AntlrExpressionParserService(factory)
    static DataService data = new DataServiceImp(factory)

}
