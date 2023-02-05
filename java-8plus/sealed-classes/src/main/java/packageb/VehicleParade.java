package packageb;

import packagea.Car;
import packagea.Truck;
import packagea.Vehicle;

public class VehicleParade {
    public void planSomething(){
        Vehicle vehicle = new Car("1234",4);
        vehicle.getRegistrationNumber();
    }


    /**
     * When sealing a class we (client code) know all the possible subclasses
     * @param vehicle
     * @return
     */
    // Pattern matching - in java 14
    public int doSomeOtherThing(Vehicle vehicle){
        if (vehicle instanceof Car car) {
            return car.getNuOfSeats();
        } else if (vehicle instanceof Truck truck) {
            return truck.getLoadCapacity();
        } else {
            throw new RuntimeException("Unknown instance of Vehicle");
        }
    }
}
