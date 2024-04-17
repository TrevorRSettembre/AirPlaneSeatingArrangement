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
    
     //for (Passenger passenger : passengers) {
       //  System.out.print(passenger.getId());
         //System.out.print(passenger.getFirstName());
         //System.out.print(passenger.getLastName());
         //System.out.print(passenger.getGender());
         //System.out.print(passenger.getAge());
        //System.out.print(passenger.getCarryonSize());
         //System.out.print(passenger.getSeat());
        //System.out.println(passenger.getSeatClass());
     //System.out.println();
     //}
      
     for (Passenger passenger : passengers) 
     {
        passenger.setPickedSeat(passenger.getSeat());
        passenger.setSeat(null);
     }

    
    PassengerSorterSelector pss = new PassengerSorterSelector(passengers);
    SeatingChart sc = new SeatingChart();
    sc.setSelected(pss);
    sc.setPassList();
    sc.startSort();
    createCSV cc = new createCSV(sc, "seatingChart.csv");
    cc.csv();

    SeatingChart rand = new SeatingChart();
    rand.setSelected(pss);
    rand.setPassList();;
    rand.seatRandom();
    createCSV randcsv = new createCSV(rand, "randSeatingChart.csv");
    randcsv.randomCsv();
}
}
