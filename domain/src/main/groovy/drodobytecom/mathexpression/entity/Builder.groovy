package drodobytecom.mathexpression.entity

import drodobytecom.core.creation.NodeAdapterBuilder
import drodobytecom.mathexpression.service.FactoryService

import static drodobytecom.core.check.Check.check

class Builder extends NodeAdapterBuilder<Expression> {

    private FactoryService factory

    Builder(FactoryService factory) {
        this.factory = factory
    }

    @Override
    protected Expression adapt(Node node) {
        try {
            validateAndAdapt node
        } catch (Exception e) {
            check.fail("wrong expression: $e.message")
        }
    }

    private validateAndAdapt(Node node) {
        def token = node.name()
        def value = node.value()
        def children = node.children()
        validateExpression token, value, children
        adaptExpression token, value, children
    }

    private static void validateExpression(token, value, List children) {
        check.in token, ['num', 'neg', 'par', 'add', 'sub', 'mul', 'div'], "$token is not valid keyword"
        if (token == 'num')
            check.isA Integer, value, "integer expected"
        else if (['par', 'neg'].contains(token))
            check.equal 1, children.size(), "$token wrong unary expression"
        else if (['add', 'sub', 'mul', 'div'].contains(token))
            check.equal 2, children.size(), "$token wrong binary expression"
    }

    private Expression adaptExpression(token, value, List children) {
        switch (token) {
            case 'num': return factory.number(value as Integer)
            case "neg": return factory.negate(adapt(children.get(0) as Node))
            case "par": return factory.parentheses(adapt(children.get(0) as Node))
            case "add": return factory.add(adapt(children.get(0) as Node), adapt(children.get(1) as Node))
            case "sub": return factory.subtract(adapt(children.get(0) as Node), adapt(children.get(1) as Node))
            case "mul": return factory.multiply(adapt(children.get(0) as Node), adapt(children.get(1) as Node))
            case "div": return factory.divide(adapt(children.get(0) as Node), adapt(children.get(1) as Node))
        }
    }
}
