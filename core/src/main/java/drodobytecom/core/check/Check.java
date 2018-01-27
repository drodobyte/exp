package drodobytecom.core.check;

import java.util.Objects;

public class Check {

    /**
     * Handy singleton for static imports
     */
    public static Check check = new Check();

    Check() {
    }

    public void notNull(Object value) {
        notNull(value, null);
    }

    public void notNull(Object value, String errorMessage) {
        check(value != null, errorMessage);
    }

    public void isNull(Object value) {
        isNull(value, null);
    }

    public void isNull(Object value, String errorMessage) {
        check(value == null, errorMessage);
    }

    public void isTrue(boolean condition) {
        isTrue(condition, null);
    }

    public void isTrue(boolean condition, String errorMessage) {
        check(condition, errorMessage);
    }

    public void equal(Object expected, Object value) {
        equal(expected, value, null);
    }

    public void equal(Object expected, Object value, String message) {
        if (expected == null || value == null)
            check(expected == value, message);
        else
            check(expected.equals(value), message);
    }

    public void in(Object candidate, Iterable possibleCandidates) {
        in(candidate, possibleCandidates, null);
    }

    public void in(Object expected, Iterable candidates, String message) {
        boolean found = false;
        for (Object candidate : candidates)
            if (Objects.equals(candidate, expected))
                found = true;
        check(found, message);
    }

    public void isA(Class<Integer> type, Object value) {
        isA(type, value, null);
    }

    public void isA(Class<Integer> type, Object value, String message) {
        check(type.isAssignableFrom(value.getClass()), message);
    }

    public void fail() throws ValidationException {
        fail(null);
    }

    public void fail(String message) throws ValidationException {
        check(false, message);
    }

    private void check(boolean condition, String message) throws ValidationException {
        if (!condition)
            throw new ValidationException(message);
    }
}
