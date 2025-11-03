package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Lotto;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

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
}
