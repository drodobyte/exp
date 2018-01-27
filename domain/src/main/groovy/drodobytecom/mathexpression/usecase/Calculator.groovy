package drodobytecom.mathexpression.usecase

class Calculator {

    int add(int arg1, int arg2) {
        arg1 + arg2
    }

    int subtract(int arg1, int arg2) {
        add(arg1, -arg2)
    }

    int multiply(int arg1, int arg2) {
        arg1 * arg2
    }

    int divide(int nom, int den) {
        nom / den
    }
}
