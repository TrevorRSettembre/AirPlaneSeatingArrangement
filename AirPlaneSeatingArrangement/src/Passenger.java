public class Passenger {

    
    private String[] name = new String[2];
    private int age;
    private String gender;
    private double comfort;
    private String carryonSize;
    private int carryonWeight;

    //Specific seat?
    //bought multiple seats?

    

    public void setFirstName(String firstName){
        name[0] = firstName;
    }

    public String getFirstName(){
        return name[0];
    }

    public void setLastName(String LastName){
        name[1] = LastName;
    }

    public String getLastName(){
        return name[1];
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    /**
     * put comort setter here 
     */
    public void setComfort(){
       
    }

    public double getComfort(){
        return comfort;
    }

    public void setCarryonSize(String carryonSize) {
        this.carryonSize = carryonSize;
    }

    public String getCarryonSize() {
        return carryonSize;
    }

    public void setCarryonWeight(int carryonWeight) {
        this.carryonWeight = carryonWeight;
    }

    public int getCarryonWeight() {
        return carryonWeight;
    }








}
