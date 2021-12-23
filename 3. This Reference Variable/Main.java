/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        // Create a Date object using the default constructor
        Date dateObject1 = new Date();
        //System.out.println(dateObject1.year);
        // Create 3 more Date objects using all the paramiterised constructors
        Date dateObject2 = new Date(20, 1, 2020);
        //System.out.println(dateObject2.day);
        
        Date dateObject3 = new Date(31);
        //System.out.println(dateObject3.day);
        //System.out.println(dateObject3.year);

        Date dateObject4 = new Date(15, 12);
        //System.out.println(dateObject4.month);

        Date dateObject5 = new Date(17, 3, 2020, "St.Paddy");
        //System.out.println(dateObject5.event);
        // Call the printDate() method for each object you create.
        dateObject5.printDate();
    }
}
