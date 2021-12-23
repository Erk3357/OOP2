class Car {

    // instance variables
    int topSpeed;
    int year;
    String manufacturer;
    String model;
    String colour;
    float cost;
    int seats;

    int reduceSeats(){
        return seats--;

    }

    int yearGoneBy(){
        year++;
        return year;
    }

    String newManufacturer(String manufacturer){
        manufacturer = "Toyota";
        return manufacturer;
    }

}