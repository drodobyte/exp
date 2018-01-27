package drodobytecom.mathexpression.presenter

import drodobytecom.mathexpression.Context
import drodobytecom.mathexpression.usecase.LoginUserUseCase
import drodobytecom.mathexpression.view.LoginView

class LoginPresenter extends Presenter<LoginView> {

    private LoginUserUseCase useCase

    LoginPresenter() {
        super(new LoginView())
        useCase = new LoginUserUseCase(Context.data)
    }

    @Override
    void present(Closure loginSucceed) {
        view.show null
        String name = view.getUserName()
        useCase.login(name,
                {
                    loginSucceed true
                },
                {
                    view.showErrorLoggin()
                    loginSucceed false
                })
    }
}