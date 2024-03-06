import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        RandomNumberGen randomNumberGen = new RandomNumberGen();

    //passengerGroup.get(firstclass).get(firstClass group one).get(id)

    /**
     * 
     */
    //randomNumberGen.RandomInt(50, 56)
    int passengerCount = 50;
    //fix plane max later
    RandomPassengerCSV randomPassengerCSV = new RandomPassengerCSV(202, passengerCount);

    randomPassengerCSV.createPassengerCSV();

    FileManager fileManager = new FileManager("passengerInfo.csv");

    ArrayList<String[]> passengerStats = new ArrayList<String[]>();
    passengerStats = fileManager.randomPassengerFileReader();
    // for(String[] i : passengerStats){
    //     for(String p : i){
    //         System.out.print(p + " ");
    //     }
    //     System.out.println();
    // }

    ArrayList<Passenger> passengers = new ArrayList<Passenger>();    

    for(int i = 0;i<passengerStats.size()-1;i++){
        passengers.add(new Passenger());

    }
//write a commment for order of p stats
    for(int i = 0;i<passengers.size()-1;i++){
        passengers.get(i).setId(Integer.parseInt(passengerStats.get(i)[0]));
    }
    System.out.println(passengers.size());
    // for(int i = 0;i<passengers.size()-1;i++){
    //     System.out.println(passengers.get(i).getId());
    // }

    }
}
