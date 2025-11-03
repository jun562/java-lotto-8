package constant;

public enum ErrorMessage {

    NON_NUMERIC("입력은 숫자여야 합니다."),
    NOT_NUMBER_IN_LIST("당첨 번호 목록에 숫자가 아닌 값이 포함되어 있습니다."),
    NOT_POSITIVE_PURCHASE_AMOUNT("구입 금액은 0보다 커야 합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("구입 금액은 1,000원 단위여야 합니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
