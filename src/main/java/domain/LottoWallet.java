package domain;

import java.util.Collections;
import java.util.List;

public class LottoWallet {

    private final List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
