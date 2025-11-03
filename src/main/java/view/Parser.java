package view;

import constant.ErrorMessage;

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

    private static String trimInput(String input) {
        return input.trim();
    }
}
