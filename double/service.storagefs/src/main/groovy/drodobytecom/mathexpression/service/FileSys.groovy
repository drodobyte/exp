package drodobytecom.mathexpression.service

class FileSys {

    def createFile(String path) {
        new File(path).createNewFile()
    }
}
