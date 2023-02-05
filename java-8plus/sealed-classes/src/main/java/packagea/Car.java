package packagea;

public non-sealed class Car extends Vehicle implements VehicleService {
    int nuOfSeats;

    public Car(String registrationNumber, int nuOfSeats) {
        super(registrationNumber);
        this.nuOfSeats = nuOfSeats;
    }

    @Override
    public int getMaxServiceIntervalInMonths() {
        return 0;
    }

    public int getNuOfSeats() {
        return nuOfSeats;
    }
}
