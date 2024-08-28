package generics;


import java.util.List;

class Building {
    void paint() {
        System.out.println("wierd, but painting a building man..");
    }
}

class House extends Building {

    @Override
    void paint() {
        System.out.println("Painting the damn house");
    }
}

class Office extends Building {

    @Override
    void paint() {
        System.out.println("Painting the damn office building");
    }

    void repair(){
        System.out.println("repair");
    }
}

class Generics {

    public <T extends Building> void paintAllBuildings(List<T> buildings) {
        buildings.forEach(Building::paint);
    }

    public void paintModern(List<? extends Building> buildings) {
        buildings.forEach(Building::paint);
    }

    /**
     * Will only work if the type is house or super type of house,
     * and we are not sure that all the super classes would contain a certain method on a lower bound scenario
     * @param buildings
     */
    public void repair(List<? super House> buildings) {
        buildings.add(new House());
    }

    /**
     * above two methods are same.
     * the real use of T comes when you use it inside the method
     * @param args
     */
    public static void main(String[] args) {
        Generics generics = new Generics();
        List<House> houseList = List.of(new House());
        List<Building> buildings = List.of(new Building());

        generics.paintAllBuildings(houseList);
        generics.paintModern(houseList);
        generics.repair(buildings);
    }
}
