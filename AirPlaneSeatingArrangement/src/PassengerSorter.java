

import java.util.ArrayList;
public class PassengerSorter 
{
    private ArrayList<Passenger> gender;
    private ArrayList<Passenger> age;
    private ArrayList<Passenger> firstClassSeats;
    private ArrayList<Passenger> economySeats;
    private ArrayList<Passenger> economyPlusSeats;
    private ArrayList<Passenger> smallCarryOns;
    private ArrayList<Passenger> mediumCarryOns;
    private ArrayList<Passenger> largeCarryOns;

    
    private double avgComfort;





    public void femaleSorter(ArrayList<Passenger>passengerList) 
    {
        gender = new ArrayList<Passenger>();
        for (int i = 0; i < passengerList.size(); i++) {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getGender().toLowerCase().equals("f"))
                gender.add(currentPassenger);
        }
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
  
    public void maleSorter(ArrayList<Passenger>passengerList)
    {
        gender = new ArrayList<Passenger>();
        for (int i = 0; i < passengerList.size(); i++) {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getGender().toLowerCase().equals("m"))
                gender.add(currentPassenger);
        }
    }

    public void ageSorter(ArrayList<Passenger>passengerList)
    {
        age = new ArrayList<Passenger>();
        age = passengerList;
        for (int i = 0; i < age.size(); i++) {
            for (int j = i + 1; j < age.size() - 1; j++) {
                if (age.get(j).getAge() < age.get(i).getAge()) {
                    Passenger temp = age.get(i);
                    age.set(i, age.get(j));
                    age.set(j, temp);
                }
            }
        }
    }

    public void smallCarryOnSorter(ArrayList<Passenger>passengerList)
    {
        smallCarryOns = new ArrayList<Passenger>();
        for (int i = 0; i < passengerList.size(); i++) {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getCarryonSize().equalsIgnoreCase("small"))
                smallCarryOns.add(currentPassenger);
        }
    }

    public void mediumCarryOnSorter(ArrayList<Passenger>passengerList)
    {
        mediumCarryOns = new ArrayList<Passenger>();
        for (int i = 0; i < passengerList.size(); i++) {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getCarryonSize().equalsIgnoreCase("medium"))
                mediumCarryOns.add(currentPassenger);
        }
    }

    public void largeCarryOnSorter(ArrayList<Passenger>passengerList)
    {
        largeCarryOns = new ArrayList<Passenger>();
        for (int i = 0; i < passengerList.size(); i++) {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getCarryonSize().equalsIgnoreCase("large"))
                largeCarryOns.add(currentPassenger);
        }
    }

    public void firstClassSeatsSorter(ArrayList<Passenger>passengerList)
    {
        firstClassSeats = new ArrayList<Passenger>();
        for (int i = 0; i < passengerList.size(); i++) {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getSeatClass().equalsIgnoreCase("f"))
                firstClassSeats.add(currentPassenger);
        }
    }

    public void economySeatsSorter(ArrayList<Passenger>passengerList)
    {
        economySeats = new ArrayList<Passenger>();
        for (int i = 0; i < passengerList.size(); i++) {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getSeatClass().equalsIgnoreCase("e"))
                economySeats.add(currentPassenger); 
        }
    }

    public void economyPlusSeatsSorter(ArrayList<Passenger>passengerList)
    {
        economyPlusSeats = new ArrayList<Passenger>();
        for (int i = 0; i < passengerList.size(); i++) {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getSeatClass().equalsIgnoreCase("p"))
                economyPlusSeats.add(currentPassenger); 
        }
    }

    public ArrayList<Passenger> getGenderList()
    {
        return gender;
    }

    public ArrayList<Passenger> getAgeList()
    {
        return age;
    }

    public ArrayList<Passenger> getFirstClassList()
    {
        return firstClassSeats;
    }

    public ArrayList<Passenger> getEconomySeatsList()
    {
        return economySeats;
    }

    public ArrayList<Passenger> getEconomyPlusSeatsList()
    {
        return economyPlusSeats;
    }

    public ArrayList<Passenger> getSmallCarryOnsList()
    {
        return smallCarryOns;
    }

    public ArrayList<Passenger> getMediumCarryOnsList()
    {
        return mediumCarryOns;
    }

    public ArrayList<Passenger> getLargeCarryOnsList()
    {
        return largeCarryOns;
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

        boolean fit = true;

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
            fit = false;
        }
        else {
            fit = true;
        }

        return fit;
    }
}
