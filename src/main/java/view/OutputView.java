package view;

import constant.LottoRank;
import domain.Lotto;
import domain.LottoResult;
import domain.LottoWallet;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static void printPurchasedLottos(LottoWallet lottoWallet) {
        lottoWallet.getLottos().forEach(OutputView::printSingleLotto);
        System.out.println();
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    private static void printSingleLotto(Lotto lotto) {
        String formattedNumbers = lotto.getNumbers().stream().map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(formattedNumbers);
    }

    private static final List<LottoRank> RESULT_RANKS = Arrays.asList(
            LottoRank.FIFTH,
            LottoRank.FOURTH,
            LottoRank.THIRD,
            LottoRank.SECOND,
            LottoRank.FIRST
    );

    public static void printLottoResult(LottoResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<LottoRank, Integer> rankCounts = result.getRankCounts();
        printRankDetails(rankCounts);

        double profitRate = result.calculateProfitRate();
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private static void printRankDetails(Map<LottoRank, Integer> rankCounts) {
        for (LottoRank rank : RESULT_RANKS) {
            if (rank == LottoRank.MISS) {
                continue;
            }
            String matchDescription = getMatchDescription(rank);
            String prizeMoney = formatPrizeMoney(rank.getPrizeMoney());
            int count = rankCounts.getOrDefault(rank, 0);

            System.out.printf("%s (%s) - %d개\n", matchDescription, prizeMoney, count);
        }
    }

    private static String getMatchDescription(LottoRank rank) {
        if (rank == LottoRank.SECOND) {
            return "5개 일치, 보너스 볼 일치";
        }
        if (rank == LottoRank.FIRST) {
            return rank.getMatchCount() + "개 일치";
        }
        return rank.getMatchCount() + "개 일치";
    }

    private static String formatPrizeMoney(long money) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(money) + "원";
    }

}
