package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {

    }

    public static String getPurchaseAmount() {
        return Console.readLine();
    }

    public static String getWinningNumbers() {
        return Console.readLine();
    }

    public static String getBonusNumber() {
        return Console.readLine();
    }
}
