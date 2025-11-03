package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.LottoGenerator;
import domain.LottoWallet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setService() {
        this.lottoService = new LottoService(new LottoGenerator());
    }

    @Test
    @DisplayName("구입_금액을_계산하여_로또의_개수_측정")
    void calculateLotto() {
        int purchaseAmount = 8000;

        int lottoCount = lottoService.calculateLottoCount(purchaseAmount);

        assertEquals(8, lottoCount);
    }

    @Test
    @DisplayName("로또의_개수에_따른_로또_발행")
    void generateLotto() {
        int lottoCount = 4;

        LottoWallet lottoWallet = lottoService.generateLottoWallet(lottoCount);

        assertEquals(lottoCount, lottoWallet.getLottos().size());
    }

}
