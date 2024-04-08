import java.util.ArrayList;

public class loadingTimes {
    private double estUnloadingTime;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    private Passenger planeSeatingChart[][] = new Passenger[][] {
        new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2],
        new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3], 
        new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3]

    };
    
    public loadingTimes(ArrayList<Passenger> passengers, Passenger planeSeatingChart[][])
    {
        this.passengers = passengers;
        this.planeSeatingChart = planeSeatingChart;
    }

    public double getEstUnloadingTime() {
        return estUnloadingTime;
    }


    public void setEstUnloadingTime()
    {   
        //estUnloadingTime = passengers.size() * 2;
        for(int i = 0; i < passengers.size(); i++)
        {
            if(passengers.get(i).getAge() < 10)
            {
                estUnloadingTime += 4;
            }
            else if(passengers.get(i).getAge() < 30)
            {
                estUnloadingTime += 1;
            }
            else if(passengers.get(i).getAge() < 50)
            {
                estUnloadingTime += 2;
            }
            else if(passengers.get(i).getAge() < 70)
            {
                estUnloadingTime += 3;
            }
            else {
                estUnloadingTime +=4;
            }

            if(passengers.get(i).getCarryonSize().equals("NULL"))
            {
                estUnloadingTime += 30;
            }
        }  
    }

}
