package domain;

public class Car {

    private final CarName carName;
    private final Position position;
    private final PowerStrategy powerStrategy;

    private Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
        this.powerStrategy = PowerStrategy.from();
    }

    public static Car of(String name, int position) {
        CarName carName = CarName.from(name);
        Position carPosition = Position.from(position);
        return new Car(carName, carPosition);
    }

    public Integer getPosition() {
        return this.position.getPosition();
    }

    public String getCarName() {
        return this.carName.getCarName();
    }

    public void tryMove() {
        if (canMove()) {
            move();
        }
    }

    private boolean canMove() {
        return powerStrategy.checkRandomNumberRange();
    }

    private void move() {
        position.increase();
    }
}
