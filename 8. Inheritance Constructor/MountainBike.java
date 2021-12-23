public class MountainBike extends Bicycle {
    
    // the MountainBike subclass adds one field
    public int seatHeight;

    // Default Constructor
    public MountainBike() {
        seatHeight = 0;;
    }
    
    // Paramiterised constructor using super keyword 
    public MountainBike(int cadence, int gear, int speed, int seatHeight) {
        super(cadence, speed, gear);
        this.seatHeight = seatHeight;
        System.out.println("I just created a MountainBike!");
    } 
    
    // Paramiterised constructor
    public MountainBike(int startHeight){
        seatHeight = startHeight;
    }
        
    //Getters
    public int getSeatHeight() {
        return seatHeight;

    }

    //Setters
    public void setSeatHeight(int seatHeight) {
        this.seatHeight = seatHeight;
    }

}
