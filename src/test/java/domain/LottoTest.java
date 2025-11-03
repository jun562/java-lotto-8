package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import constant.LottoRank;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또_번호_오름차순_생성_테스트")
    void generateSortedLotto() {
        List<Integer> unsortedNumbers = List.of(41, 2, 7, 5, 1, 30);

        Lotto lotto = new Lotto(unsortedNumbers);

        List<Integer> expectedNumbers = List.of(1, 2, 5, 7, 30, 41);
        assertEquals(lotto.getNumbers(), expectedNumbers);
    }

    @Test
    @DisplayName("로또_번호_개수가_6이_아닌_경우")
    void validateWhenCountNotSix() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또_번호가_중복되는_경우")
    void validateWhenDuplicated() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또_번호가_범위를_벗어난_경우")
    void validateWhenOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 51)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("6개_번호_일치_시_1등을_반환한다")
    void matchFirstRank() {
        Lotto winningNums = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNums, 7);

        assertEquals(LottoRank.FIRST, lotto.match(winningLotto));
    }

    // --- 2. 2등 테스트 (5개 일치 + 보너스) ---
    @Test
    @DisplayName("5개_번호와_보너스_일치_시_2등을_반환한다")
    void matchSecondRank() {
        Lotto winningNums = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        WinningLotto winningLotto = new WinningLotto(winningNums, 6);

        assertEquals(LottoRank.SECOND, lotto.match(winningLotto));
    }

    @Test
    @DisplayName("5개_번호_일치_시_3등을_반환한다")
    void matchThirdRank() {
        Lotto winningNums = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        WinningLotto winningLotto = new WinningLotto(winningNums, 7);

        assertEquals(LottoRank.THIRD, lotto.match(winningLotto));
    }

    @Test
    @DisplayName("4개_번호_일치_시_4등을_반환한다")
    void matchFourthRank() {
        Lotto winningNums = new Lotto(List.of(1, 2, 3, 4, 11, 10));
        WinningLotto winningLotto = new WinningLotto(winningNums, 7);

        assertEquals(LottoRank.FOURTH, lotto.match(winningLotto));
    }

    @Test
    @DisplayName("3개_번호_일치_시_5등을_반환한다")
    void matchFifthRank() {
        Lotto winningNums = new Lotto(List.of(1, 2, 3, 12, 11, 10));
        WinningLotto winningLotto = new WinningLotto(winningNums, 7);

        assertEquals(LottoRank.FIFTH, lotto.match(winningLotto));
    }

    @Test
    @DisplayName("2개_이하_일치_시_꽝을_반환한다")
    void matchMissRank() {
        Lotto winningNums = new Lotto(List.of(1, 2, 40, 41, 42, 43));
        WinningLotto winningLotto = new WinningLotto(winningNums, 7);

        assertEquals(LottoRank.MISS, lotto.match(winningLotto));
    }
}
