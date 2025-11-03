package view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import constant.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @Test
    @DisplayName("문자열을_정수로_변환하는_테스트")
    void parseInputToInteger() {
        String input = "1000";

        int result = Parser.parseStringToInteger(input);

        assertEquals(1000, result);
    }

    @Test
    @DisplayName("문자열에_공백이_포함된_경우")
    void parseStringToIntegerWithWhiteSpace() {
        String input = " 1000 ";

        int result = Parser.parseStringToInteger(input);

        assertEquals(1000, result);
    }

    @Test
    @DisplayName("쉼표를_기준으로_정수형_리스트_변환")
    void parseStringToListOfInteger() {
        String input = "1,2,3,4,5,6";
        List<Integer> parsedInput = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> result = Parser.parseStringToList(input);

        assertEquals(parsedInput, result);
    }

    @Test
    @DisplayName("쉼표_사이에_공백이_존재하는_경우_정수형_리스트_변환")
    void parseStringToListOfIntegerWithWhiteSpace() {
        String input = "1, 2, 3 ,4 ,5, 6";
        List<Integer> parsedInput = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> result = Parser.parseStringToList(input);

        assertEquals(parsedInput, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc", // 숫자가 아닌 문자열인 경우
            "1000.123", // 실수인 경우
    })
    @DisplayName("문자열이_숫자가_아닌_경우")
    void parseStringToIntegerWhenNotInteger(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Parser.parseStringToInteger(input);
        });

        assertEquals(ErrorMessage.NON_NUMERIC.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,!,4,5",
            "@@@",
            "1,,,3"
    })
    @DisplayName("쉼표를_기준으로_숫자가_아닌_값이_포함된_경우")
    void parseStringtoListOfIntegerWhenNotNumber(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Parser.parseStringToList(input)
        );

        assertEquals(ErrorMessage.NOT_NUMBER_IN_LIST.getMessage(), exception.getMessage());
    }
}
