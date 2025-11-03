package domain;

import constant.LottoRank;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoWallet {

    private final List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    /*
     * Map <등수, 당첨 개수>
     */
    public Map<LottoRank, Integer> calculateRanks(WinningLotto winningLotto) {
        Map<LottoRank, Integer> rankCounts = initializeRankMap();

        processLottoMatches(winningLotto, rankCounts);

        return rankCounts;
    }
    
    private Map<LottoRank, Integer> initializeRankMap() {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
        return rankCounts;
    }

    private void processLottoMatches(WinningLotto winningLotto, Map<LottoRank, Integer> rankCounts) {
        for (Lotto lotto : lottos) {
            LottoRank rank = lotto.match(winningLotto);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
