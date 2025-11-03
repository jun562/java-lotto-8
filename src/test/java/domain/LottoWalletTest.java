package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWalletTest {

    @Test
    @DisplayName("로또가_저장되는지_테스트")
    void generateLottoWallet() {
        Lotto lotto1 = new Lotto(List.of(1, 6, 2, 3, 4, 5));
        Lotto lotto2 = new Lotto(List.of(6, 7, 8, 9, 10, 11));
        Lotto lotto3 = new Lotto(List.of(12, 35, 13, 15, 16, 20));

        LottoWallet lottoWallet = new LottoWallet(List.of(lotto1, lotto2, lotto3));

        assertThat(lottoWallet.getLottos()).hasSize(3);
        assertThat(lottoWallet.getLottos()).containsExactly(lotto1, lotto2, lotto3);
    }
}
