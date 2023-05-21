package Seminar_6.task_2;

public class Bus extends Vehicle{
    public Bus(int maxSpeed) {
        super(maxSpeed, "Bus");
    }

    @Override
    public double calculateAllowedSpeed() {
        return getMaxSpeed() * 0.6;
    }
}
