package constant;

public enum ErrorMessage {

    NON_NUMERIC("입력은 숫자여야 합니다."),
    NOT_NUMBER_IN_LIST("당첨 번호 목록에 숫자가 아닌 값이 포함되어 있습니다."),
    NOT_POSITIVE_PURCHASE_AMOUNT("구입 금액은 0보다 커야 합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("구입 금액은 1,000원 단위여야 합니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    DUPLICATE_NUMBERS_IN_LOTTO("입력값에 중복된 숫자가 있습니다."),
    INVALID_LOTTO_RANGE("로또 번호는 1부터 45 사이여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
