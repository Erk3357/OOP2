package ie.gmit.employeemanager;

public class Car {

    //Private Instance Variables
    private String name;
    private double topSpeed;
    private String doors;


    //Constructor
    public Car(String name){
        this.name = name;
    }

    //Getter Methods
    public String getName(){
        return name;

    }

    public double getTopSpeed(){
        return topSpeed;

    }

    public String getDoors(){
        return doors;

    }

    //Setter Methods
    public void setName(String name){
        this.name = name;
    }

    public void setTopSpeed(double topSpeed){
        if(topSpeed > 200){
            System.out.println("Top Speed is Too High!");
        }
        else{
            this.topSpeed = topSpeed;
        }
        

    }

    public void setDoors(String doors){
        this.doors = doors;
    }

}