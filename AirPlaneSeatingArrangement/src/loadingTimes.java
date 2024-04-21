import java.util.ArrayList;

public class loadingTimes {
    private double estUnloadingTime;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    
    
    public loadingTimes(ArrayList<Passenger> passengers)
    {
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
        estUnloadingTime = estUnloadingTime/60;  
    }

}
