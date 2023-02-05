package packagea;

public sealed interface VehicleService permits Car, Truck, Helicopter {

    int getMaxServiceIntervalInMonths();

    default int getMaxDistanceBetweenServicesInKilometers() {
        return 100000;
    }
}
