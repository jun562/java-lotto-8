package view;

import constant.ErrorMessage;

public class Validator {

    private Validator() {

    }

    public static void validatePurchaseAmount(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_PURCHASE_AMOUNT.getMessage());
        }
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
        }
    }

}
