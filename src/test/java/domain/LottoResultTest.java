package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import constant.LottoRank;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("당첨_통계를_바탕으로_총_상금_금액_계산")
    void calculateTotalPrizeMoney() {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);

        rankCounts.put(LottoRank.FIRST, 1);
        rankCounts.put(LottoRank.SECOND, 0);
        rankCounts.put(LottoRank.THIRD, 2);
        rankCounts.put(LottoRank.FOURTH, 5);
        rankCounts.put(LottoRank.FIFTH, 10);
        rankCounts.put(LottoRank.MISS, 1);

        long expectedTotalPrize = 2_003_300_000L;

        LottoResult lottoResult = new LottoResult(10000, rankCounts);
        long actualTotalPrize = lottoResult.calculateTotalPrizeMoney();

        assertEquals(expectedTotalPrize, actualTotalPrize);
    }
}
