public class Person {
    // Instance Variables
    private String firstName;
    private String[] middleNames;
    private String userName;

    // Methods

    // Getters
    public String getfirstName() {
        return firstName;

    }

    public String getmiddleNames() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < middleNames.length; i++){
            sb.append(middleNames[i] + " ");
        }
        String middleNames = sb.toString();
        return middleNames;

    }

    public String getuserName() {
        return userName;

    }

    // Setters
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setmiddleNames(String middleNames) {
        this.middleNames = middleNames.split(" ");
    }

    public void setuserName(String userName) {
        if(userName.length() > 10){
            this.userName = userName.substring(0, 10);
        }
        else{
            this.userName = userName;
        }
        
    }
}
