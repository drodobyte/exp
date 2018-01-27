package drodobytecom.mathexpression.entity

interface Expression {

    boolean isANumber()

    boolean isUnary()

    boolean isNegate()

    boolean isParentheses()

    boolean isBinary()

    boolean isMultiply()

    boolean isDivide()

    boolean isAdd()

    boolean isSubtract()

    Integer getNumber()

    Expression getLeft()

    Expression getRight()

    Expression getNegated()

    Expression getParenthesed()
}
