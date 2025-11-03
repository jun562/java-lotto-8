package domain;

import constant.ErrorMessage;
import constant.LottoRule;

public class WinningLotto {
    private final Lotto lotto; // 내부적으로 검증된 객체 이기에 별도의 검증 x
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicated(lotto, bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < LottoRule.MIN_LOTTO_NUMBER || bonusNumber > LottoRule.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
        }
    }

    private void validateDuplicated(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
