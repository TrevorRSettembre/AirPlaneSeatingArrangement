import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {


    int passengerCount = 166;
    RandomPassengerCSV randomPassengerCSV = new RandomPassengerCSV(passengerCount);
    //creates the arraylift of random passenger data
    randomPassengerCSV.createPassengerCSV();
    //This block fills a passenegr arraylist use the passengers arraylif as the input for your sorting code
    CreatePassenegerList createPassenegerList = new CreatePassenegerList();
    ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    passengers = createPassenegerList.fillInStats();
    
       
}
}
