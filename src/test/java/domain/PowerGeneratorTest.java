package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("범위 난수 생성 테스트")
class PowerGeneratorTest {

    @DisplayName("생성된 난수는 지정된 범위를 벗어나지 않는다")
    @RepeatedTest(50)
    void testRangeOfRandomNumber() {
        PowerGenerator powerGenerator = new PowerGenerator();
        int randomNumber = powerGenerator.makeRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }
}