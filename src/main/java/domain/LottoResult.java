package domain;

import constant.LottoRank;
import java.util.Map;

public class LottoResult {

    private final int purchaseAmount;
    private final Map<LottoRank, Integer> rankCounts;

    public LottoResult(int purchaseAmount, Map<LottoRank, Integer> rankCounts) {
        this.purchaseAmount = purchaseAmount;
        this.rankCounts = rankCounts;
    }

    public long calculateTotalPrizeMoney() {
        long totalPrize = 0L;

        for (Map.Entry<LottoRank, Integer> entry : rankCounts.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();

            totalPrize += rank.getPrizeMoney() * count;
        }
        return totalPrize;
    }
}
