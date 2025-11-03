package view;

import static constant.LottoRule.LOTTO_NUMBER_COUNT;
import static constant.LottoRule.LOTTO_PRICE_UNIT;
import static constant.LottoRule.MAX_LOTTO_NUMBER;
import static constant.LottoRule.MIN_LOTTO_NUMBER;

import constant.ErrorMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private Validator() {

    }

    public static void validatePurchaseAmount(int number) {
        validatePositive(number);
        validateAmountUnit(number);
    }

    public static void validateWinningLotto(List<Integer> winningLotto) {
        validateLottoSize(winningLotto);
        validateLottoDuplicated(winningLotto);
        validateLottoRange(winningLotto);
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningLotto) {
        validateLottoRange(bonusNumber);
        validateBonusNumberDuplicated(bonusNumber, winningLotto);
    }

    private static void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateAmountUnit(int number) {
        if (number % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
        }
    }

    private static void validateLottoSize(List<Integer> winningLotto) {
        if (winningLotto.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private static void validateLottoDuplicated(List<Integer> winningLotto) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningLotto);
        if (uniqueNumbers.size() != winningLotto.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS_IN_LOTTO.getMessage());
        }
    }

    private static void validateLottoRange(List<Integer> winningLotto) {
        boolean isOutOfRange = winningLotto.stream()
                .anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER);
        if (isOutOfRange) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
        }
    }

    private static void validateLottoRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
        }
    }

    private static void validateBonusNumberDuplicated(int bonusNumber, List<Integer> winningLotto) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
