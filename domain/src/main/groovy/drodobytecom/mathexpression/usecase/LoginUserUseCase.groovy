package drodobytecom.mathexpression.usecase

import drodobytecom.mathexpression.entity.User
import drodobytecom.mathexpression.service.DataService

class LoginUserUseCase {

    private DataService service

    LoginUserUseCase(DataService service) {
        this.service = service
    }

    void isLoggedUser(String userName, Closure isLogged, Closure error = null) {
        service.getUser(userName,
                {
                    isLogged true
                },
                {
                    isLogged false
                })
    }

    void getUser(String userName, Closure userRetrieved, Closure error = null) {
        service.getUser(userName,
                {
                    userRetrieved it as User
                },
                {
                    error it as Exception
                })
    }

    void login(String userName, Closure ok, Closure error) {
        service.loginUser(userName,
                {
                    ok()
                },
                {
                    error it as Exception
                })
    }

    void signUp(String newUserName, Closure ok, Closure error) {
        service.signUpUser(newUserName,
                {
                    ok()
                },
                {
                    error it as Exception
                })
    }
}
