package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setService() {
        this.lottoService = new LottoService();
    }

    @Test
    @DisplayName("구입_금액을_계산하여_로또의_개수_측정")
    void calculateLotto() {
        int purchaseAmount = 8000;

        int lottoCount = lottoService.calculateLottoCount(purchaseAmount);

        assertEquals(8, lottoCount);
    }

}
