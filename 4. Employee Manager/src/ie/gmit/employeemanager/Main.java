package ie.gmit.employeemanager;

public class Main {
    public static void main(String[] args) {
        //System.out.println("This is the main method");
        Car carObj1 = new Car("Tesla");

        System.out.println("Name: "+carObj1.getName());
        System.out.println("Top Speed: "+carObj1.getTopSpeed());

        carObj1.setTopSpeed(10000);
        System.out.println("Top Speed: "+carObj1.getTopSpeed());


        carObj1.setDoors("No");
        System.out.println("Doors: "+carObj1.getDoors());
    }
}
