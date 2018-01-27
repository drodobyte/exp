package drodobytecom.mathexpression

import drodobytecom.mathexpression.controller.Controller

class ConsoleApp {

    static main(args) {
        new ConsoleApp().start()
    }

    def start() {
        new Controller().run()
    }
}
