package drodobytecom.mathexpression.service

import drodobytecom.mathexpression.entity.Builder
import drodobytecom.mathexpression.usecase.BaseDomainTest
import org.junit.Ignore
import org.junit.Test

import static org.junit.Assert.assertTrue

@Ignore("Not to be run: Base class for Testing parser service implementations")
abstract class BaseDataServiceTest extends BaseDomainTest {

    abstract DataService dataService()

    @Test
    void createUsersFile() {
        reset()
        def path = validFile().path

        dataService().createFile path

        assertTrue validFile().exists()
    }

    @Test(expected = Exception)
    void createUsersFileError() {
        reset()
        def path = invalidFile().path

        dataService().createFile path
    }

    static def reset() {
        validFile().delete()
    }

    static File validFile() {
        file('/home/dev/Descargas/tmp/users.txt')
    }

    static File invalidFile() {
        file('/root/tmp/users.txt')
    }

    static File file(String path) {
        new File(path)
    }

    @Override
    Builder builder() {
        return null
    }
}