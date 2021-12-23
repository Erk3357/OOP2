public class Puppy {
    // Insance Variables
    String name;
    int age;
    String breed;
    
    // Default Contructor
    Puppy(){
        name = "Richard";
    }

    // Parametarised Contructor
    Puppy(String newName){
        name = newName;
    }

    // Parametarised Contructor
    Puppy(String newName, int newAge, String newBreed){
        name = newName;
        age = newAge;
        breed = newBreed;
    }
}