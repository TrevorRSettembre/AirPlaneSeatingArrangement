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


    private String pickedSeat;//should be set to "NULL" if passenger did not choose a seat
    private String pickedClass;//should be either "F" for first class or "E" for economy "P" for economy plus
    private ArrayList<Passenger> neighbors = new ArrayList<Passenger>();
    private String seat;
    private ArrayList<Passenger> group = new ArrayList<Passenger>();

    private String seatClass;// should be "F" for first, "E" for economy, and "P" for economy plus
    //Specific seat?
    //bought multiple seats?

    public String getSeatClass() {
        return seatClass;
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
       if((seatClass.equals("F")&& !(pickedClass.equals("F"))))
       {
            comfort = comfort + (Math.random() * (151 - 0) + 0);
       }
       else if(!(seatClass.equals("F")) && pickedClass.equals("F"))
       {
            comfort = comfort - (Math.random() * (201 - 0) + 0);
       }
       else if(seatClass.equals("P") && !(pickedClass.equals("P")))
       {
            comfort = comfort + (Math.random() * (101 - 0) + 0);
       }
       else if (seatClass.equals("E") && pickedClass.equals("P"))
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
                    else if(age - currPassenger.getAge() == 5 || age - currPassenger.getAge() == -5)
                    {
                        comfort = comfort + (Math.random() * (21 - 0) + 0);
                    }
                    else if(age - currPassenger.getAge() == 10 || age - currPassenger.getAge() == -10)
                    {
                        comfort = comfort + (Math.random() * (16 - 0) + 0);
                    }
                    else if(age - currPassenger.getAge() == 15 || age - currPassenger.getAge() == -15)
                    {
                        comfort = comfort + (Math.random() * (11 - 0) + 0);
                    }
                    else if(age - currPassenger.getAge() == 20 || age - currPassenger.getAge() == -20)
                    {
                        comfort = comfort + (Math.random() * (6 - 0) + 0);
                    }
                    else if(age - currPassenger.getAge() == 30 || age - currPassenger.getAge() == -30)
                    {
                        comfort = comfort - (Math.random() * (6 - 0) + 0);
                    }
                    else if(age - currPassenger.getAge() == 35 || age - currPassenger.getAge() == -35)
                    {
                        comfort = comfort - (Math.random() * (11 - 0) + 0);
                    }
                    else if(age - currPassenger.getAge() == 40 || age - currPassenger.getAge() == -40)
                    {
                        comfort = comfort - (Math.random() * (16 - 0) + 0);
                    }
                    else if(age - currPassenger.getAge() == 45 || age - currPassenger.getAge() == -45)
                    {
                        comfort = comfort - (Math.random() * (21 - 0) + 0);
                    }
                    if(gender.equals(currPassenger.getGender()))
                    {
                        comfort = comfort + (Math.random() * (21 - 0) + 0);
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
        return carryonSizeNum;
    }

    public void setCarryOnSizeNum(int carryonSizeNum)
    {
        this.carryonSizeNum = carryonSizeNum;
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
