package view;

public class Parser {
    private Parser() {

    }

    public static int parseStringToInteger(String input) {
        try {
            return Integer.parseInt(trimInput(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자를 입력해야 합니다.");
        }
    }

    private static String trimInput(String input) {
        return input.trim();
    }
}
