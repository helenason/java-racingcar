package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @DisplayName("자동차 이름이 5자가 넘지 않을 경우 정상적으로 도메인이 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "4444", "55555"})
    void createByValidNameLength(String name) {
        assertThatCode(() -> CarName.from(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름이 5자 초과 또는 0자 이하일 경우 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "666666"})
    void createByInvalidNameLength(String name) {
        assertThatThrownBy(() -> CarName.from(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
