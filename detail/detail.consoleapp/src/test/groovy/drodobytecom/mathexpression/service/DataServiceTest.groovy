package drodobytecom.mathexpression.service

class DataServiceTest extends BaseDataServiceTest {

    @Override
    DataService dataService() {
        new DataServiceImp()
    }
}
