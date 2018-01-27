package drodobytecom.mathexpression.usecase

import drodobytecom.mathexpression.entity.Builder
import drodobytecom.mathexpression.service.DataService
import org.junit.Ignore
import org.junit.Test

@Ignore('not to be run')
abstract class BaseUserStorageTest extends BaseDomainTest {

    abstract DataService dataService()

    @Test
    void configUserFile() {
        def path = '/home/dev/Descargas/tmp/data.txt'
        def storage = new UserStorage(dataService())
    }

    @Override
    Builder builder() {
    }
}