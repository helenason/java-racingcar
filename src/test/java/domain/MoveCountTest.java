package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 이동 횟수 도메인 테스트")
class MoveCountTest {

    @DisplayName("움직일 수 있는 횟수를 차감할 수 있다")
    @Test
    void testConsumeCount() {
        MoveCount moveCount = MoveCount.from(1);
        moveCount.consume();
        assertThat(moveCount.isCountZero()).isTrue();
    }

    @DisplayName("움직일 수 있는 횟수가 0인지 체크할 수 있다")
    @Test
    void testDetectCountZero() {
        MoveCount moveCount = MoveCount.from(1);
        moveCount.consume();
        assertThat(moveCount.isCountZero()).isTrue();
    }

    @DisplayName("움직일 수 있는 횟수가 0이 아닌지 체크할 수 있다.")
    @Test
    void testDetectCountNonZero() {
        MoveCount moveCount = MoveCount.from(1);
        assertThat(moveCount.isCountZero()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -99999})
    @DisplayName("자동차 이동 횟수가 0 또는 음수인 경우 에러가 발생한다.")
    void createByInvalidValue(int value) {
        assertThatThrownBy(() -> MoveCount.from(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoveCount.ERROR_OF_MOVE_COUNT_RANGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 99999})
    @DisplayName("자동차 이동 횟수가 양의 정수인 경우 에러가 발생하지 않는다.")
    void createByValidValue(int value) {
        assertThatCode(() -> MoveCount.from(value))
                .doesNotThrowAnyException();
    }
}