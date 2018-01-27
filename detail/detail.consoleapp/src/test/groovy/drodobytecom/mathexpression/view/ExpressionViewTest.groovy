package drodobytecom.mathexpression.view

import org.junit.Test

import static org.junit.Assert.assertEquals

class ExpressionViewTest {

    private Appendable output
    private InputStream input
    PipedOutputStream inputWriter

    @Test
    void writeExpressionScreenShown() {
        ExpressionView view = getViewAndStartIO()

        view.showExpressionScreen()

        assertEquals "escribe una ecuación -> ", getViewOutput()
    }

    @Test
    void userWroteSomething() {
        ExpressionView view = getViewAndStartIO()

        writeInput(3)
        assertEquals 3, view.getUserExpression()
    }

    ExpressionView getViewAndStartIO() {
        output = newOutput()
        input = newInput()
        new ExpressionView()
    }

    InputStream newInput() {
        def input = new PipedInputStream()
        inputWriter = new PipedOutputStream(input)
        input
    }

    def getViewOutput() {
        output.toString()
    }

    def writeInput(data) {
        inputWriter.write(data)
    }

    def newOutput() {
        output = new StringBuffer()
    }
}