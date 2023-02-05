package packagea;

public final class Truck extends Vehicle implements VehicleService {
    private int loadCapacity;

    public Truck(String registrationNumber, int loadCapacity) {
        super(registrationNumber);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public int getMaxServiceIntervalInMonths() {
        return 0;
    }
}
