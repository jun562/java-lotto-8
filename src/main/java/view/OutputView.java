package view;

public class OutputView {

    private OutputView() {

    }

    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
