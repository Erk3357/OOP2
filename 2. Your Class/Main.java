
public class Main {

    public static void main(String[] args) {

        // Car carObject1 = new Car();
        // Car carObject2 = new Car();

        // carObject1.manufacturer = "Audi";
        // carObject1.colour = "red";
        // carObject1.seats = 5;
        // carObject1.year = 2001;

        // System.out.println(carObject1.manufacturer);
        // System.out.println(carObject1.colour);
        // System.out.println(carObject1.seats);
        // System.out.println(carObject1.year);

        // carObject2.manufacturer = "mercedes";
        // carObject2.colour = "blue";
        // carObject2.seats = 2;
        // carObject2.year = 2018;

        // System.out.println(carObject2.manufacturer);
        // System.out.println(carObject2.colour);
        // System.out.println(carObject2.seats);
        // System.out.println(carObject2.year);

        // carObject1.reduceSeats();
        // System.out.println(carObject1.seats);
        
        // System.out.println(carObject1.yearGoneBy());

        // carObject1.newManufacturer();
        // System.out.println(carObject1.newManufacturer);

        
        // Puppy
        Puppy puppyObject1 = new Puppy();
        Puppy puppyObject2 = new Puppy("Bingo");
        Puppy puppyObject3 = new Puppy("Rex",10,"Pitbull");

        System.out.println(puppyObject1.name);
        System.out.println(puppyObject2.name);
        System.out.println(puppyObject3.name);

        System.out.println(puppyObject1.age);
        System.out.println(puppyObject2.age);
        System.out.println(puppyObject3.age);

    }
    
}