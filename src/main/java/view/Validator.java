package view;

import constant.ErrorMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    
    private Validator() {

    }

    public static void validatePurchaseAmount(int number) {
        validateNegative(number);
        validateAmountUnit(number);
    }

    public static void validateWinningLotto(List<Integer> winningLotto) {
        if (winningLotto.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
        Set<Integer> uniqueNumbers = new HashSet<>(winningLotto);
        if (uniqueNumbers.size() != winningLotto.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS_IN_LOTTO.getMessage());
        }
        for (int number : winningLotto) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
            }
        }
    }

    private static void validateNegative(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateAmountUnit(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
        }
    }
}
