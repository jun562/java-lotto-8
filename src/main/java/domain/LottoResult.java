package domain;

import constant.LottoRank;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public double calculateProfitRate() {
        long totalPrize = calculateTotalPrizeMoney();
        double profitRate = (double) totalPrize / (double) purchaseAmount * 100.0;

        BigDecimal bigDecimal = BigDecimal.valueOf(profitRate);
        BigDecimal roundedRate = bigDecimal.setScale(1, RoundingMode.HALF_UP);
        
        return roundedRate.doubleValue();
    }
}
