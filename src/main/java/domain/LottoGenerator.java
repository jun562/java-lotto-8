package domain;

import camp.nextstep.edu.missionutils.Randoms;
import constant.LottoRule;
import java.util.List;

public class LottoGenerator {

    public LottoGenerator() {

    }

    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoRule.MIN_LOTTO_NUMBER,
                LottoRule.MAX_LOTTO_NUMBER,
                LottoRule.LOTTO_NUMBER_COUNT
        );
        return new Lotto(numbers);
    }
}
