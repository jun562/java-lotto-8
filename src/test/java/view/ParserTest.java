package view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @Test
    @DisplayName("로또_구입_금액을_정수로_변환하는_테스트")
    void parseInputToInteger() {
        String purchaseAmount = "1000";

        int result = Parser.parseStringToInteger(purchaseAmount);

        assertEquals(1000, result);
    }

    @Test
    @DisplayName("로또_구입_금액에_공백이_포함된_경우")
    void parseStringToIntegerWithWhiteSpace() {
        String purchaseAmount = " 1000 ";

        int result = Parser.parseStringToInteger(purchaseAmount);

        assertEquals(1000, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc", // 숫자가 아닌 문자열인 경우
            "1000.123", // 실수인 경우
    })
    @DisplayName("로또_구입_금액이_숫자가_아닌_경우")
    void parseStringToIntegerWhenNotInteger(String purchaseAmount) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Parser.parseStringToInteger(purchaseAmount);
        });

        assertEquals(ErrorMessage.NON_NUMERIC.getMessage(), exception.getMessage());
    }
}
