import java.util.ArrayList;

public class CreatePassenegerList {

    String fileName = "passengerInfo.csv";
    FileManager fileManager = new FileManager(fileName);

    
    public ArrayList<Passenger> fillInStats(){
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();

        ArrayList<String[]> stats = new ArrayList<String[]>();
        stats = fileManager.randomPassengerFileReader();

        //index id, seat, first name, last name, gender, age, carryon size, seat number
        for(int i = 0; i < stats.size();i++){
            Passenger passengerObj = new Passenger();
            passengers.add(passengerObj);
            passengers.get(i).setId(Integer.parseInt(stats.get(i)[0]));
            passengers.get(i).setFirstName(stats.get(i)[1]);
            passengers.get(i).setLastName(stats.get(i)[2]);
            passengers.get(i).setGender(stats.get(i)[3]);
            passengers.get(i).setAge(Integer.parseInt(stats.get(i)[4]));
            passengers.get(i).setCarryonSize(stats.get(i)[5]);
            if(stats.get(i).length == 7){
                passengers.get(i).setSeat(stats.get(i)[6]);
            }
        }

        return passengers;
    }
    
    
}
