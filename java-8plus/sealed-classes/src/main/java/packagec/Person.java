package packagec;


import org.junit.jupiter.api.Test;

public abstract sealed class Person permits Employee, Manager {

}

//public abstract  class Person {
//
//}

final class Employee extends Person {
    int getEmployeeId() {
        return 1;
    }
}

final class Manager extends Person {
    int getSupervisorId() {
        return 12;
    }
}


class Main {

    @Test
    public void matchEmKEvin() {
        getUniqueId(new Manager());
    }

    /**
     * preview mode
     * @param person
     * @return
     */
    int getUniqueId(Person person) {
        return switch (person) {
            case Employee t -> t.getEmployeeId();
            case Manager c -> c.getSupervisorId();
        };
    }

    Object run(Person person) {
        if (person instanceof Employee) {
            return ((Employee) person).getEmployeeId();
        } else if (person instanceof Manager) {
            return ((Manager) person).getSupervisorId();
        }

        return null;
    }
}