package constant;

public enum ErrorMessage {
    NON_NUMERIC("입력은 숫자여야 합니다."),
    NOT_NUMBER_IN_LIST("당첨 번호 목록에 숫자가 아닌 값이 포함되어 있습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
