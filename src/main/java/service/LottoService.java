package service;

import constant.LottoRule;

public class LottoService {

    public LottoService() {

    }

    public int calculateLottoCount(int purchaseAmount) {
        return (purchaseAmount / LottoRule.LOTTO_PRICE_UNIT);
    }
}
