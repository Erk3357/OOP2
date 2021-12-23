public class Bicycle {

	// the Bicycle class has three fields
	private int cadence;
	private int gear;
	private int speed;
	
    // Default constructor
    public Bicycle(){
        int cadence = 0;
        int gear = 0;
        int speed = 0;
        System.out.println("I just created a Bicyle!");
    }

	// Parameterised constructor
    public Bicycle(int cadence, int gear, int speed) {
         this.cadence = cadence;
         this.gear = gear;
         this.speed = speed;


	}
	
    //Getters
    public int getCadence() {
        return cadence;

    }

    public int getGear() {
        return gear;

    }

    public int getSpeed() {
        return speed;

    }
    
    //Setters
    public void setCadence(int cadence) {
        this.cadence = cadence;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

	// Extra methods here
	public void applyBrake(int speedDecrement) {
        //speed -= speedDecrement;
        speed = speed - speedDecrement;
	}

	public void speedUp(int speedIncrement) {
		speed += speedIncrement;
	}

}
