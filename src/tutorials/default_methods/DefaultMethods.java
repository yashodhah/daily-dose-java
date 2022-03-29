package tutorials.default_methods;

interface Vehicle {
    String getBrand();

    String speedUp();

    String slowDown();


    /**
     * Default methods are used to push functionalities to subclasses in a controlled manner
     * + With backward compatibility
     *
     * @return
     */
    default String turnAlarmOn() {
        return "Turning the vehicle alarm on.";
    }

    default String turnAlarmOff() {
        return "Turning the vehicle alarm off.";
    }

    /**
     * Static interfaces :
     * Group related utility methods together | Cohesion
     * Abstract classes have STATES | CONSTRUCTOR
     *
     * @param rpm
     * @param torque
     * @return
     */
    static int getHorsePower(int rpm, int torque) {
        return (rpm * torque) / 5252;
    }
}

interface Alarm {
    default String turnAlarmOn() {
        return "Turning the alarm on.";
    }

    default String turnAlarmOff() {
        return "Turning the alarm off.";
    }

    default String buzzAlarm() {
        return "Buzzing the alarm on/off.";
    }
}

class Car implements Vehicle, Alarm {
    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The car is speeding up.";
    }

    @Override
    public String slowDown() {
        return "The car is slowing down.";
    }

    @Override
    public String turnAlarmOn() {
        return Vehicle.super.turnAlarmOn();
    }

    @Override
    public String turnAlarmOff() {
        return Vehicle.super.turnAlarmOff();
    }
}

class DefaultMethods {
    public static void main(String[] args) {
        Vehicle car = new Car("BMW");

        System.out.println(car.getBrand());
        System.out.println(car.speedUp());
        System.out.println(car.slowDown());
        System.out.println(car.turnAlarmOn());
        System.out.println(car.turnAlarmOff());

        System.out.println(Vehicle.getHorsePower(10000, 23));
    }
}