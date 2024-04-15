import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {


    int passengerCount = 166;
    RandomPassengerCSV randomPassengerCSV = new RandomPassengerCSV(passengerCount);

    randomPassengerCSV.createPassengerCSV();

    CreatePassenegerList createPassenegerList = new CreatePassenegerList();

    ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    passengers = createPassenegerList.fillInStats();
    
    // for (Passenger passenger : passengers) {
    //     System.out.print(passenger.getId());
    //     System.out.print(passenger.getFirstName());
    //     System.out.print(passenger.getLastName());
    //     System.out.print(passenger.getGender());
    //     System.out.print(passenger.getAge());
    //     System.out.print(passenger.getCarryonSize());
    //     if(passenger.getSeat() != null){
    //         System.out.print(passenger.getSeat());
    //     }
    //     System.out.println();
    // }
    
}
}
