import java.util.ArrayList;

public class loadingTimes {
    private double estUnloadingTime;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    private ArrayList<ArrayList<Passenger>> seatedPassengers = new ArrayList<ArrayList<Passenger>>();
    
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }


    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
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


    public void setEstUnloadingTime(double estUnloadingTime) {
        this.estUnloadingTime = estUnloadingTime;
    }


    public ArrayList<ArrayList<Passenger>> getSeatedPassengers() {
        return seatedPassengers;
    }


    public void setSeatedPassengers(ArrayList<ArrayList<Passenger>> seatedPassengers) {
        this.seatedPassengers = seatedPassengers;
    }
}
