package domain;

public class CarName {

    public static final int LIMIT_LENGTH = 5;

    private final String carName;

    private CarName(String carName) {
        validate(carName);
        this.carName = carName;
    }

    public static CarName from(String carName) {
        return new CarName(carName);
    }

    private void validate(String carName) {
        validateLength(carName);
    }

    private void validateLength(String carName) {
        if (carName.length() > LIMIT_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이는 5를 넘을 수 없습니다.");
        }
    }

    public String getCarName() {
        return carName;
    }
}
