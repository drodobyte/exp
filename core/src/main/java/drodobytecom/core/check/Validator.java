package drodobytecom.core.check;

public interface Validator<T> {

    void ok(T value) throws ValidationException;
}
