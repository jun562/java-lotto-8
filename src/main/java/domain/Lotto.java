package domain;

import constant.ErrorMessage;
import constant.LottoRule;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LottoRule.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS_IN_LOTTO.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(number -> number < LottoRule.MIN_LOTTO_NUMBER || number > LottoRule.MAX_LOTTO_NUMBER);

        if (isOutOfRange) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
        }
    }
}
