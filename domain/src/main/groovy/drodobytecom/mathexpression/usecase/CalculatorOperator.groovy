package drodobytecom.mathexpression.usecase

import drodobytecom.core.check.Validator

class CalculatorOperator {

    private final Calculator calculator
    private final Validator<Integer> validator

    CalculatorOperator(calculator, validator) {
        this.calculator = calculator
        this.validator = validator
    }

    int add(int arg1, int arg2) {
        operate '+', arg1, arg2
    }

    int subtract(int arg1, int arg2) {
        operate '-', arg1, arg2
    }

    int negate(int value) {
        subtract 0, value
    }

    int multiply(int arg1, int arg2) {
        operate '*', arg1, arg2
    }

    int divide(int arg1, int arg2) {
        operate '/', arg1, arg2
    }

    int operate(def op, int arg1, int arg2) {
        validate arg1
        validate arg2
        int result = calculate op, arg1, arg2
        validate result
        result
    }

    int validate(int arg) {
        validator?.ok arg
        arg
    }

    private int calculate(def op, int op1, int op2) {
        switch (op) {
            case '+': return calculator.add(op1, op2)
            case '-': return calculator.subtract(op1, op2)
            case '*': return calculator.multiply(op1, op2)
            case '/': return calculator.divide(op1, op2)
        }
    }
}
