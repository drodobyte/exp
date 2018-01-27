package drodobytecom.mathexpression.service;

import drodobytecom.mathexpression.entity.Expression;

public interface ExpressionParserService {

    Expression parse(String expression) throws ParserException;
}
