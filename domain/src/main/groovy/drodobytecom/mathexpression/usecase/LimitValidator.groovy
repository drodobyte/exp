package drodobytecom.mathexpression.usecase

import drodobytecom.core.check.BaseValidator

class LimitValidator extends BaseValidator<Integer> {

    private final int min
    private final int max

    LimitValidator(int min, int max) {
        this.min = min
        this.max = max
    }

    @Override
    void ok(Integer value) {
        check.isTrue value >= min && value <= max
    }
}
