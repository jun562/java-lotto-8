package view;

import constant.ErrorMessage;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String DELIMITER = ",";

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
        List<String> splitInput = List.of(input.split(DELIMITER));
        List<String> trimmedInput = splitInput.stream().map(String::trim).toList();
        try {
            return trimmedInput.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_IN_LIST.getMessage());
        }
    }

    private static String trimInput(String input) {
        return input.trim();
    }
}
