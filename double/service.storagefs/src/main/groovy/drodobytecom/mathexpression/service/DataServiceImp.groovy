package drodobytecom.mathexpression.service

class DataServiceImp implements DataService {

    private FileSys fileSys = new FileSys()
    private Ws ws

    DataServiceImp(FactoryService factory) {
        ws = new Ws(factory)
    }

    @Override
    void createFile(String path) throws IOException {
        fileSys.createFile path
    }

    @Override
    void getUser(String userName, Closure userRetrieved, Closure error = null) {
        ws.getUser userName, userRetrieved
    }

    @Override
    void loginUser(String userName, Closure ok, Closure error) {
        ws.login userName, ok, error
    }

    @Override
    void signUpUser(String userName, Closure ok, Closure error) {
        ws.signUp userName, ok, error
    }
}
