package service;

import constant.LottoRule;
import domain.Lotto;
import domain.LottoGenerator;
import domain.LottoWallet;
import domain.WinningLotto;
import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public int calculateLottoCount(int purchaseAmount) {
        return (purchaseAmount / LottoRule.LOTTO_PRICE_UNIT);
    }

    public LottoWallet generateLottoWallet(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            lottos.add(lottoGenerator.generate());
        }
        return new LottoWallet(lottos);
    }

    public Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public WinningLotto createWinningLotto(Lotto winningLotto, int bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }
}
