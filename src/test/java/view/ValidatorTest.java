package view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import constant.ErrorMessage;
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

        assertEquals(ErrorMessage.NOT_POSITIVE_AMOUNT.getMessage(), exception.getMessage());
    }
}
