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

    
    PassengerSorterSelector pss = new PassengerSorterSelector(passengers);
    pss.sortSelect();
    SeatingChart sc = new SeatingChart();
    sc.setSelected(pss);
    sc.setPassList();
    sc.startSort();
    LoadingGroups lg = new LoadingGroups(passengers);
    createCSV cc = new createCSV(sc, "seatingChart.csv");
    cc.csv();

    SeatingChart rand = new SeatingChart();
    rand.setSelected(pss);
    rand.setPassList();
    rand.seatRandom();
    LoadingGroups lgs = new LoadingGroups(passengers);
    createCSV randcsv = new createCSV(rand, "randSeatingChart.csv");
    randcsv.randomCsv();

}
}
