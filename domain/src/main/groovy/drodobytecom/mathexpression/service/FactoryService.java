package drodobytecom.mathexpression.service;

import drodobytecom.mathexpression.entity.Expression;
import drodobytecom.mathexpression.entity.User;

public interface FactoryService {

    User user(long id, String name);

    Expression expression(Expression expression);

    Expression number(Integer value);

    Expression add(Expression left, Expression right);

    Expression subtract(Expression left, Expression right);

    Expression multiply(Expression left, Expression right);

    Expression divide(Expression left, Expression right);

    Expression parentheses(Expression expression);

    Expression negate(Expression expression);
}
