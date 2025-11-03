package view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
