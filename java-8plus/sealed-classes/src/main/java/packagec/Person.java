package packagec;


//public abstract sealed class Person permits Employee, Manager {
//
//}

public abstract  class Person {

}

final class Employee extends Person {
    int getEmployeeId() {
        return 1;
    }
}

final class Manager extends Person {
    int getSupervisorId() {
        return 1;
    }
}

class Main {
    Object run(Person person) {
        if (person instanceof Employee) {
            return ((Employee) person).getEmployeeId();
        } else if (person instanceof Manager) {
            return ((Manager) person).getSupervisorId();
        }

        return null;
    }
}