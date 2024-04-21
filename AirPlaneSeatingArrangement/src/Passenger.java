import java.util.ArrayList;

public class Passenger {

    
    private String[] name = new String[2];
    private int age;
    private String gender;
    private double comfort;
    private String carryonSize;
    private int id;

    private int carryonSizeNum;
    private boolean fit;

    private int boardingGroup;
    private String pickedSeat;//should be set to "NULL" if passenger did not choose a seat
    private String actualClass;//should be either "F" for first class or "E" for economy "P" for economy plus
    private ArrayList<Passenger> neighbors = new ArrayList<Passenger>();
    private String seat;
    private ArrayList<Passenger> group = new ArrayList<Passenger>();

    private String seatClass;// should be "F" for first, "E" for economy, and "P" for economy plus
    //Specific seat?
    //bought multiple seats?

    public void setActualClass(String actualClass)
    {
        this.actualClass = actualClass;
    }

    public String getActualClass()
    {
        return actualClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }



    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public void setBoardingGroup(int num)
    {
        this.boardingGroup = num;
    }

    public int getBourdingGroup()
    {
        return boardingGroup;
    }

    public String getSeatClass()
    {
        return seatClass;
    }


    public void setComfort(){
        if(pickedSeat != "NULL")
       {
            if(seat.equals(pickedSeat))
            {
                comfort = comfort + (Math.random() * (51-0) + 0);
            }
            else
            {
                comfort = comfort - (Math.random() * (101 - 0) + 0);
            }
       }
       if((actualClass.equals("F")&& !(seatClass.equals("F"))))
       {
            comfort = comfort + (Math.random() * (151 - 0) + 0);
       }
       else if(!(actualClass.equals("F")) && seatClass.equals("F"))
       {
            comfort = comfort - (Math.random() * (201 - 0) + 0);
       }
       else if(actualClass.equals("P") && !(seatClass.equals("P")))
       {
            comfort = comfort + (Math.random() * (101 - 0) + 0);
       }
       else if (actualClass.equals("E") && seatClass.equals("P"))
       {
            comfort = comfort - (Math.random() * (151 - 0) + 0);
       }
       Passenger currPassenger;
       for(int i = 0; i < neighbors.size(); i++)
       {
            currPassenger = neighbors.get(i);
            if(!(currPassenger.getSeat().equals(seat)))
            {
                int findGroup = 0;
                for(int j = 0; j < group.size(); j++)
                {
                    
                    Passenger currGroupMember = group.get(j);
                    if(currPassenger.getSeat().equals(currGroupMember.getSeat()))
                    {
                        comfort = comfort + (Math.random() * (101 - 0) + 0);
                        findGroup = 1;
                    }
                }
                if(findGroup == 0)
                {
                    if(age > 5 && currPassenger.getAge() <= 5)
                    {
                        comfort = comfort - (Math.random() * (51 -0) + 0);
                    }
                    else if(age - currPassenger.getAge() < 6 ||  currPassenger.getAge() - age < 5)
                    {
                        comfort = comfort + (Math.random() * (31 - 0) + 0);
                    }
                    else if(age - currPassenger.getAge() < 11 || currPassenger.getAge() - age < 11)
                    {
                        comfort = comfort + (Math.random() * (26 - 0) + 0);
                    }
                    else if(age - currPassenger.getAge() < 16 || currPassenger.getAge() - age < 16)
                    {
                        comfort = comfort + (Math.random() * (21 - 0) + 0);
                    }
                    else if(age - currPassenger.getAge() < 21 || currPassenger.getAge() - age < 21)
                    {
                        comfort = comfort + (Math.random() * (16 - 0) + 0);
                    }
                    else if(age - currPassenger.getAge() <31 || currPassenger.getAge() - age < 31)
                    {
                        comfort = comfort - (Math.random() * (6 - 0) + 0);
                    }
                    else if(age - currPassenger.getAge() < 36 || currPassenger.getAge() - age < 36)
                    {
                        comfort = comfort - (Math.random() * (11 - 0) + 0);
                    }
                    else if(age - currPassenger.getAge() < 41 || currPassenger.getAge() - age < 41)
                    {
                        comfort = comfort - (Math.random() * (16 - 0) + 0);
                    }
                    else if(age - currPassenger.getAge() > 45 || currPassenger.getAge() - age > -45)
                    {
                        comfort = comfort - (Math.random() * (21 - 0) + 0);
                    }
                    if(gender.equals(currPassenger.getGender()))
                    {
                        comfort = comfort + (Math.random() * (31 - 0) + 0);
                    }
                }
            }
       }
        

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


    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public String getPickedSeat() {
        return pickedSeat;
    }

    public void setPickedSeat(String pickedSeat) {
        this.pickedSeat = pickedSeat;
    }

    public ArrayList<Passenger> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Passenger> neighbors) {
        this.neighbors = neighbors;
    }

    public int getCarryOnSizeNum()
    {
        if(carryonSize.equalsIgnoreCase("small"))
        {
            carryonSizeNum = 2;
        }
        else if(carryonSize.equalsIgnoreCase("medium"))
        {
            carryonSizeNum = 4;
        }
        else if(carryonSize.equalsIgnoreCase("large"))
        {
            carryonSizeNum = 5;
        }
        return carryonSizeNum;
    }

    public void setCarryOnSizeNum()
    {
        if(carryonSize.equalsIgnoreCase("small"))
        {
            carryonSizeNum = 2;
        }
        else if(carryonSize.equalsIgnoreCase("medium"))
        {
            carryonSizeNum = 4;
        }
        else if(carryonSize.equalsIgnoreCase("large"))
        {
            carryonSizeNum = 5;
        }
    }


    public boolean isFit() {

        return fit;
    }

    public void setFit(boolean fit) {
       this.fit = fit;
    }


    public ArrayList<Passenger> getGroup() 
    {
        return group;
    }

    public void setGroup(ArrayList<Passenger> group)
    {
        this.group = group;
    }

    

}
