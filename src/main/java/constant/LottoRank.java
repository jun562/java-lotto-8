package constant;

public enum LottoRank {

    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),   // 5개 일치 + 보너스
    THIRD(5, 1_500_000L),    // 5개 일치
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    MISS(0, 0L);

    private final int matchCount;
    private final long prizeMoney;

    LottoRank(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
