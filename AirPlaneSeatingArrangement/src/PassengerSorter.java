

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
    private ArrayList<Passenger> noCarryOns;



    public void femaleSorter(ArrayList<Passenger>passengerList) 
    {
        gender = new ArrayList<Passenger>();
        for (int i = 0; i < passengerList.size(); i++) {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getGender().toLowerCase().equals("f")) {
                gender.add(currentPassenger);
            }
        }
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

    public void noCarryOnSorter(ArrayList<Passenger>passengerList)
    {
        noCarryOns = new ArrayList<Passenger>();
        for (int i = 0; i < passengerList.size(); i++) {
            Passenger currentPassenger = passengerList.get(i);
            if (currentPassenger.getCarryonSize().equalsIgnoreCase("NULL"))
                noCarryOns.add(currentPassenger);
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

    public ArrayList<Passenger> getNoCarryOnsList()
    {
        return noCarryOns;
    }

    



}
