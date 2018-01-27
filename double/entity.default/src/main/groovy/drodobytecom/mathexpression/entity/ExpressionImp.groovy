package drodobytecom.mathexpression.entity

final class ExpressionImp implements Expression {

    private static final char TYPE_NUMBER = '#'
    private static final char TYPE_NEG = '_'
    private static final char TYPE_PAR = '('
    private static final char TYPE_ADD = '+'
    private static final char TYPE_SUB = '-'
    private static final char TYPE_MUL = '*'
    private static final char TYPE_DIV = '/'

    private final char type
    private final Integer number
    private final Expression left
    private final Expression right

    private ExpressionImp(char type,
                          Integer number,
                          Expression left, Expression right) {
        this.type = type
        this.number = number
        this.left = left
        this.right = right
    }

    static ExpressionImp number(Integer value) {
        new ExpressionImp(TYPE_NUMBER, value, null, null)
    }

    static ExpressionImp add(Expression left, Expression right) {
        new ExpressionImp(TYPE_ADD, null, left, right)
    }

    static ExpressionImp subtract(Expression left, Expression right) {
        new ExpressionImp(TYPE_SUB, null, left, right)
    }

    static ExpressionImp multiply(Expression left, Expression right) {
        new ExpressionImp(TYPE_MUL, null, left, right)
    }

    static ExpressionImp divide(Expression left, Expression right) {
        new ExpressionImp(TYPE_DIV, null, left, right)
    }

    static ExpressionImp parentheses(Expression expression) {
        new ExpressionImp(TYPE_PAR, null, expression, null)
    }

    static ExpressionImp negate(Expression expression) {
        new ExpressionImp(TYPE_NEG, null, expression, null)
    }

    @Override
    boolean isANumber() {
        type == TYPE_NUMBER
    }

    @Override
    boolean isUnary() {
        return isNegate() || isParentheses()
    }

    @Override
    boolean isBinary() {
        return !isANumber() && !isUnary()
    }

    @Override
    boolean isNegate() {
        type == TYPE_NEG
    }

    @Override
    boolean isParentheses() {
        type == TYPE_PAR
    }

    @Override
    boolean isMultiply() {
        type == TYPE_MUL
    }

    @Override
    boolean isDivide() {
        type == TYPE_DIV
    }

    @Override
    boolean isAdd() {
        type == TYPE_ADD
    }

    @Override
    boolean isSubtract() {
        type == TYPE_SUB
    }

    @Override
    Integer getNumber() {
        return number
    }

    @Override
    Expression getLeft() {
        return left
    }

    @Override
    Expression getRight() {
        return right
    }

    @Override
    Expression getNegated() {
        return left
    }

    @Override
    Expression getParenthesed() {
        return left
    }

    @Override
    String toString() {
        isANumber() ? "$number" :
                isNegate() ? "-$negated" :
                        isParentheses() ? "($parenthesed)" :
                                "$left${type}$right"
    }
}
