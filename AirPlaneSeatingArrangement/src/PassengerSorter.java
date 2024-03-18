import java.util.ArrayList;


public class PassengerSorter 
{
    private ArrayList<Passenger> femalePassengers = new ArrayList<Passenger>();
    private ArrayList<Passenger> malePassengers = new ArrayList<Passenger>();
    private ArrayList<Passenger> age = new ArrayList<Passenger>();
    private ArrayList<Passenger> smallCarryOns = new ArrayList<Passenger>();
    private ArrayList<Passenger> mediumCarryOns = new ArrayList<Passenger>();
    private ArrayList<Passenger> largeCarryOns = new ArrayList<Passenger>();
    private ArrayList<Passenger> firstClassSeats = new ArrayList<Passenger>();
    private ArrayList<Passenger> economySeats = new ArrayList<Passenger>();
    private ArrayList<Passenger> economyPlusSeats = new ArrayList<Passenger>();


    public PassengerSorter(ArrayList<Passenger>passengerList)
    {
        genderSorter(passengerList);
        ageSorter(passengerList);
        carryOnSorter(passengerList);
        seatsSorter(passengerList);
    }

    public void genderSorter(ArrayList<Passenger>passengerList) 
    {
        for (int i = 0; i < passengerList.size(); i++)
        {
            Passenger currentPassenger = passengerList.get(i);
            String gender = currentPassenger.getGender().toLowerCase();
            switch (gender) {
                case "f":
                    femalePassengers.add(currentPassenger);
                    break;
                case "m":
                    malePassengers.add(currentPassenger);
                    break;
                default:
                    System.out.println("Invalid gender");
            }
        }

        for (int i = 0; i < femalePassengers.size(); i++)
        {
            for (int j = i + 1; j < femalePassengers.size() - 1; j++)
            {
                if (femalePassengers.get(j).getAge() < femalePassengers.get(i).getAge())
                {
                    Passenger temp = femalePassengers.get(i);
                    femalePassengers.set(i, femalePassengers.get(j));
                    femalePassengers.set(j, temp);
                }
            }
        }

        for (int i = 0; i < malePassengers.size(); i++)
        {
            for (int j = i + 1; j < malePassengers.size() - 1; j++)
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

    public void ageSorter(ArrayList<Passenger>passengerList)
    {
        age = passengerList; 
        for (int i = 0; i < age.size(); i++)
        {
            for (int j = i + 1; j < age.size() - 1; j++)
            {
                if (age.get(j).getAge() < age.get(i).getAge())
                {
                    Passenger temp = age.get(i);
                    age.set(i, age.get(j));
                    age.set(j, temp);
                }
            }
        }
    }

    public void carryOnSorter(ArrayList<Passenger>passengerList)
    {
        for (int i = 0; i < passengerList.size(); i++)
        {
            Passenger currentPassenger = passengerList.get(i);
            String carryOn = currentPassenger.getCarryonSize().toLowerCase();
            switch (carryOn) {
                case "small":
                    smallCarryOns.add(currentPassenger);
                    break;
                case "medium":
                    mediumCarryOns.add(currentPassenger);
                    break;
                case "large":
                    largeCarryOns.add(currentPassenger);;
                    break;
                default:
                    System.out.println("Invalid carry-on size");
            }
        }
    }

    public void seatsSorter(ArrayList<Passenger>passengerList)
    {
        for (int i = 0; i < passengerList.size(); i++)
        {
            Passenger currentPassenger = passengerList.get(i);
            String seatClass = currentPassenger.getSeatClass().toLowerCase();
            switch (seatClass) {
                case "f":
                    firstClassSeats.add(currentPassenger);
                    break;
                case "e":
                    economySeats.add(currentPassenger);
                    break;
                case "p":
                    economyPlusSeats.add(currentPassenger);
                    break;
                default:
                    System.out.println("Invalid seat class");
            }
        }
    }

}
