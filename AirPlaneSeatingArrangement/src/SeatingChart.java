import java.util.ArrayList;

public class SeatingChart {
    private Passenger planeSeatingChart[][] = new Passenger[][] {
        new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2],
        new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3], 
        new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3]

    };
    private Passenger firstClass[][] = new Passenger[8][2];
    private Passenger econPlus[][] = new Passenger[18][3];
    private Passenger econ[][] = new Passenger[32][3];
    private PassengerSorterSelector selected;


    public ArrayList<ArrayList<Passenger>> seatBaggage(ArrayList<ArrayList<Passenger>> classList, ArrayList<Passenger> passArray)
    {
        if(selected.isSortBaggage()) {
            
            for(int i = 0; i < classList.size(); i++)
            {
                ArrayList<Passenger> currRow = classList.get(i);
                Passenger p1 = currRow.get(0);
                Passenger p2 = currRow.get(1);
                Passenger p3 = currRow.get(2);
                boolean fit = checkLuggageFit(p1, p2, p3);
                int j = 0;
                while(!fit)
                {
                    p3 = passArray.get(j);
                    fit = checkLuggageFit(p1, p2, p3);
                    j++;
                }

                currRow.remove(2);
                currRow.add(p3);
                classList.remove(i);
                classList.add(i, currRow);
            }
        }

        return classList;
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

    public void seatClass(PassengerSorter currSort)
    {
        int j = 0;
        ArrayList<Passenger> currList = currSort.getFirstClassList();
        for(int i = 0; i < currList.size(); i++)
        {

        }



    }

    public void seatAge()
    {
        PassengerSorter currSort = selected.getAge();
        if(selected.isSortSeatClass())
                {
                seatClass(currSort);
                }
    }

    public void seatGender()
    {

            PassengerSorter currSort1 = selected.getFemale();
            PassengerSorter currSort2 = selected.getMale();
            if(selected.isSortAge())
            {
                if(selected.isSortSeatClass())
                {
                    seatClass(currSort1);
                    seatClass(currSort2);
                }
            }

    }

    public void seatRandom()
    {
        
    }

    public void startSort() 
    {
        if(selected.isSortGender())
        {
            seatGender();
        }
        else if(selected.isSortAge())
        {
            seatAge();
        }
        else if(selected.isSortSeatClass())
        {
            PassengerSorter currSort = selected.getSeatClass();
            seatClass(currSort);
        }
        else if(selected.isSortBaggage())
        {
            //add seat baggage
        }
        else
        {
            seatRandom();
        }
    }
}
