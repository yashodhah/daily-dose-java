package packagea;

public record Helicopter(String regNumber, String model) implements VehicleService{


    @Override
    public int getMaxServiceIntervalInMonths() {
        return 12;
    }
}
