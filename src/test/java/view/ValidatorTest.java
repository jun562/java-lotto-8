package view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
}
