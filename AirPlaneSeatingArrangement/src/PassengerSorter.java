import java.util.ArrayList;


public class PassengerSorter 
{
    private ArrayList<Passenger> femalePassengers = new ArrayList<Passenger>();
    private ArrayList<Passenger> malePassengers = new ArrayList<Passenger>();
    private ArrayList<Passenger> smallCarryOns = new ArrayList<Passenger>();
    private ArrayList<Passenger> mediumCarryOns = new ArrayList<Passenger>();
    private ArrayList<Passenger> largeCarryOns = new ArrayList<Passenger>();
    private double avgComfort;




    public PassengerSorter(ArrayList<Passenger>passengerList)
    {
        femalePassengerSorter(passengerList);
        malePassengerSorter(passengerList);
        smallCarryOnSorter(passengerList);
        mediumCarryOnSorter(passengerList);
        largeCarryOnSorter(passengerList);
        setAvgComfort(passengerList);
    }

    public double getAvgComfort() {
        return avgComfort;
    }


    public void setAvgComfort(ArrayList<Passenger>passengerList) {
        double averageCom = 0;
        double comfortSum = 0;
        for(int i = 0; i < passengerList.size(); i++)
        {
            Passenger currPassenger = passengerList.get(i);
            comfortSum = comfortSum + currPassenger.getComfort();
        }

        averageCom = comfortSum/passengerList.size();

        avgComfort = averageCom;
    }

    public void femalePassengerSorter(ArrayList<Passenger>passengerList)
    {
        for (int i = 0; i < passengerList.size(); i++)
        {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getGender().equalsIgnoreCase("f"))
                femalePassengers.add(currentPassenger);
        }
        for (int i = 0; i < femalePassengers.size(); i++)
        {
            for (int j = i + 1; j < femalePassengers.size(); j++)
            {
                if (femalePassengers.get(j).getAge() < femalePassengers.get(i).getAge())
                {
                    Passenger temp = femalePassengers.get(i);
                    femalePassengers.set(i, femalePassengers.get(j));
                    femalePassengers.set(j, temp);
                }
            }
        }
    }

    public void malePassengerSorter(ArrayList<Passenger>passengerList)
    {
        for (int i = 0; i < passengerList.size(); i++)
        {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getGender().equalsIgnoreCase("m"))
                malePassengers.add(currentPassenger);
        }
        for (int i = 0; i < malePassengers.size(); i++)
        {
            for (int j = i + 1; j < malePassengers.size(); j++)
            {
                if (malePassengers.get(j).getAge() < malePassengers.get(i).getAge())
                {
                    Passenger temp = malePassengers.get(i);
                    malePassengers.set(i, malePassengers.get(j));
                    malePassengers.set(j, temp);
                }
            }
        }
    }

    public void smallCarryOnSorter(ArrayList<Passenger>passengerList)
    {
        for (int i = 0; i < passengerList.size(); i++)
        {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getCarryonSize().equalsIgnoreCase("small"))
                smallCarryOns.add(currentPassenger);
        }
    }

    public void mediumCarryOnSorter(ArrayList<Passenger>passengerList)
    {
        for (int i = 0; i < passengerList.size(); i++)
        {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getCarryonSize().equalsIgnoreCase("medium"))
                mediumCarryOns.add(currentPassenger);
        }
    }

    public void largeCarryOnSorter(ArrayList<Passenger>passengerList)
    {
        for (int i = 0; i < passengerList.size(); i++)
        {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getCarryonSize().equalsIgnoreCase("large"))
                largeCarryOns.add(currentPassenger);
        }
    }

    public boolean checkLuggageFit(Passenger pOne, Passenger pTwo, Passenger pThree)
    {
        int capacity = 10;
        int large = 5;
        int medium = 4;
        int small = 2;

        String pOneSize = pOne.getCarryonSize();
        String pTwoSize = pOne.getCarryonSize();
        String pThreeSize = pOne.getCarryonSize();

        int oneSize = 0;
        int twoSize = 0;
        int threeSize = 0;

        if(pOneSize.equalsIgnoreCase("small"))
        {
            oneSize = small;
        }
        else if(pOneSize.equalsIgnoreCase("medium"))
        {
            oneSize = medium;
        }
        else if(pOneSize.equalsIgnoreCase("large"))
        {
            oneSize = large;
        }

        if(pTwoSize.equalsIgnoreCase("small"))
        {
            twoSize = small;
        }
        else if(pTwoSize.equalsIgnoreCase("medium"))
        {
            twoSize = medium;
        }
        else if(pTwoSize.equalsIgnoreCase("large"))
        {
            twoSize = large;
        }

        if(pThreeSize.equalsIgnoreCase("small"))
        {
            threeSize = small;
        }
        else if(pThreeSize.equalsIgnoreCase("medium"))
        {
            threeSize = medium;
        }
        else if(pThreeSize.equalsIgnoreCase("large"))
        {
            threeSize = large;
        }

        int currentFill = oneSize + twoSize + threeSize;

        if(currentFill <= capacity)
        {
            return true;
        }
        else {
            return false;
        }


    }

}
