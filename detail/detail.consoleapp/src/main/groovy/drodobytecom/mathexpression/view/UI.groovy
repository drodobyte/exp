package drodobytecom.mathexpression.view

import static java.lang.System.lineSeparator

class UI {

    private Appendable output
    private InputStream input

    UI(Appendable output, InputStream input) {
        this.input = input
        this.output = output
    }

    void text(String message) {
        output.append message
    }

    void textln(String message, int lineCount = 1) {
        text message
        ln lineCount
    }

    def ln(int count = 1) {
        1.upto(count) {
            output.append('\n')
        }
    }

    String readString() {
        def buffer = new StringBuffer()
        while (true) {
            char key = readChar()
            if (key == lineSeparator())
                return buffer.toString()
            else
                buffer.append key
        }
    }

    char readChar() {
        input.read() as char
    }
}
