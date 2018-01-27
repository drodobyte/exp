package drodobytecom.mathexpression.controller

import drodobytecom.mathexpression.presenter.ExpressionPresenter
import drodobytecom.mathexpression.presenter.LoginPresenter
import drodobytecom.mathexpression.presenter.Presenter

import static drodobytecom.mathexpression.controller.Controller.State.*

class Controller {

    Presenter expressionPresenter = new ExpressionPresenter()
    Presenter loginPresenter = new LoginPresenter()

    enum State {
        login, expressionWrite, exit
    }

    def run() {
        State state = login
        while (state != exit)
            if (state == login)
                loginPresenter.present { loginSucceed ->
                    if (loginSucceed)
                        state = expressionWrite
                }
            else if (state == expressionWrite)
                expressionPresenter.present { end ->
                    if (end)
                        state = exit
                }
    }
}