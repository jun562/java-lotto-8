package view;

import static constant.LottoRule.DELIMITER;

import constant.ErrorMessage;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private Parser() {

    }

    public static int parseStringToInteger(String input) {
        try {
            return Integer.parseInt(trimInput(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC.getMessage());
        }
    }

    public static List<Integer> parseStringToList(String input) {
        try {
            List<String> trimmedInput = trimInput(splitInput(input));

            return trimmedInput.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_IN_LIST.getMessage());
        }
    }

    private static String trimInput(String input) {
        return input.trim();
    }

    private static List<String> splitInput(String input) {
        return List.of(input.split(DELIMITER));
    }

    private static List<String> trimInput(List<String> input) {
        return input.stream().map(String::trim).collect(Collectors.toList());
    }


}
