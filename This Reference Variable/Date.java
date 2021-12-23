/**
 * Date
 */
public class Date {
    
    // Instance Variables
    int day;
    int month;
    int year;
    String event;

    // Default Constructor (No Parameters)
    public Date(){
        day = 1;
        month = 1;
        year = 1;
    }

    // Parameterized constructor (3 Parameters)
    public Date(int day, int month, int year){
        this(day, month);
        this.year = year;
    }
    
    // Parameterized constructor (2 Parameters)
    public Date(int day, int month){
        this(day);
        this.month = month;
    }
    
    // Parameterized constructor (1 Parameter)
    public Date(int day){
        this.day = day;
        this.year = 2000;
    }

    // Parameterized constructor (3 Parameters)
    public Date(int day, int month, int year, String event){
        this(day, month, year);
        this.event = event;
    }
    
    // A simple print method
    public void printDate(){
        // Print the date like this: day/month/year
        System.out.println(this.day+"/"+this.month+"/"+this.year+" "+this.event);
    }

}
