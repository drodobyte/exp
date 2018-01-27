package drodobytecom.mathexpression.usecase

import drodobytecom.mathexpression.service.DataService

class UserStorage {

    private DataService dataService

    UserStorage(DataService dataService) {
        this.dataService = dataService
    }
}
