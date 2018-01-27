package drodobytecom.mathexpression.view

class LoginView extends View<String> {

    @Override
    void show(String userName) {
        ui.textln "Login"
        ui.textln "-----"
        if (!userName || userName.empty)
            ui.text "write your username: "
        else
            ui.text "wellcome $userName"
    }

    String getUserName() {
        ui.readString()
    }

    def showErrorLoggin() {
        ui.textln "error login!"
        ui.textln "(invalid user)"
    }
}
