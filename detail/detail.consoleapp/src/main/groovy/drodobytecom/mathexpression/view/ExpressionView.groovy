package drodobytecom.mathexpression.view

class ExpressionView extends View<Void> {

    @Override
    void show(Void aVoid) {
        ui.text "escribe una ecuación -> "
    }

    String getUserExpression() {
        ui.readString()
    }

    def showExpressionResult(int result) {
        ui.text "el resultado es $result"
        ui.ln 2
    }

    def showExpressionError(String message) {
        ui.text "la expression no es correcta: $message"
        ui.ln 2
    }
}
