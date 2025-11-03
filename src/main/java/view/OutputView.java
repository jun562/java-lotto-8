package view;

public class OutputView {

    private OutputView() {

    }

    public static void printPurchaseAmountPrompt() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printWinningNumbersPrompt() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberPrompt() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
