package drodobytecom.mathexpression.service

import drodobytecom.mathexpression.entity.User

class Ws {

    def logged = []
    def users = []
    FactoryService factory
    long unusedId = 0

    Ws(FactoryService factory) {
        this.factory = factory
    }

    void getUser(String userName, Closure userRetrieved, Closure error = null) {
        def user = users.find { User user ->
            user.name == userName
        }
        if (user == null)
            error new Exception("user not found")
        else
            userRetrieved user
    }

    void login(String userName, Closure ok, Closure error) {
        if (userName.empty)
            error new Exception("invalid user")
        else if (userName in logged)
            error new Exception("already logged in")
        else if (!userName in users)
            error new Exception("user not found")
        else {
            logged << userName
            ok()
        }
    }

    void signUp(String newUserName, Closure ok, Closure error) {
        if (newUserName in users)
            error new Exception("user already signed")
        else
            users << factory.user(unusedId++, newUserName)
    }
}
