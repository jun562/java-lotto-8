package view;

public class Parser {
    private Parser() {

    }

    public static int parseStringToInteger(String input) {
        String trimmedInput = input.trim();
        try {
            return Integer.parseInt(trimmedInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자를 입력해야 합니다.");
        }
    }
}
