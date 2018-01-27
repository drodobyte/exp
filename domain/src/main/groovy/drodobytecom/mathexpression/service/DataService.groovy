package drodobytecom.mathexpression.service

interface DataService {

    void createFile(String path) throws IOException

    void getUser(String userName, Closure userRetrieved, Closure error)

    void loginUser(String userName, Closure ok, Closure error)

    void signUpUser(String userName, Closure ok, Closure error)
}
