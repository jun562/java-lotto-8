package view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import constant.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("구입_금액이_올바른_경우")
    void validateWhenCorrectNumber() {
        int number = 1000;

        assertDoesNotThrow(() -> {
            Validator.validatePurchaseAmount(number);
        });
    }

    @Test
    @DisplayName("구입_금액이_음수인_경우")
    void validateWhenNegativeNumber() {
        int number = -1000;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validatePurchaseAmount(number);
        });

        assertEquals(ErrorMessage.NOT_POSITIVE_PURCHASE_AMOUNT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("구입_금액이_1000원_단위가_아닌_경우")
    void validateWhenNotMultipleOf1000() {
        int number = 1500;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validatePurchaseAmount(number);
        });

        assertEquals(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("당첨_번호가_올바른_경우")
    void validateWhenCorrectWinningLotto() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() -> {
            Validator.validateWinningLotto(winningLotto);
        });
    }

    @Test
    @DisplayName("당첨_번호가_6개가_아닌_경우")
    void validateWhenNotSix() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateWinningLotto(winningLotto);
        });

        assertEquals(ErrorMessage.INVALID_LOTTO_SIZE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("당첨_번호가_중복되는_경우")
    void validateWhenDuplicated() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 5);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateWinningLotto(winningLotto);
        });

        assertEquals(ErrorMessage.DUPLICATE_NUMBERS_IN_LOTTO.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("당첨_번호가_범위를_벗어나는_경우")
    void validateWhenOutOfRange() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 57);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateWinningLotto(winningLotto);
        });
        
        assertEquals(ErrorMessage.INVALID_LOTTO_RANGE.getMessage(), exception.getMessage());
    }
}
