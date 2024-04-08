import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private ArrayList<Passenger> passList;
    private double avgComfort;

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

    public ArrayList<Passenger> getPassList()
    {
        passList = selected.getOrigList();
        return passList;
    }

    public void seatBaggage(int row, String classStr, ArrayList<Passenger> passList)
    {
        if(classStr.equals("econPlus"))
        {
            int bigIndex = 0;
            Passenger biggestBag = econPlus[row][0];
            if(biggestBag.getCarryOnSizeNum() <= econPlus[row][1].getCarryOnSizeNum())
            {
                biggestBag = econPlus[row][1];
                bigIndex = 1;
            }
            if(biggestBag.getCarryOnSizeNum() <= econPlus[row][2].getCarryOnSizeNum())
            {
                biggestBag = econPlus[row][2];
                bigIndex = 2;
            }
            int index = passList.indexOf(biggestBag);
            int nextPass = index + 1;
            boolean fit = false;
            while(nextPass < passList.size() && !fit)
            {
                boolean found = search(passList.get(nextPass), econPlus);
                if(found)
                {
                    nextPass++;
                }
                else
                {
                    econPlus[row][bigIndex] = passList.get(nextPass);
                    fit = checkLuggageFit(econPlus[row][0], econPlus[row][1], econPlus[row][2]);
                    if(!fit)
                    {
                        nextPass++;
                    }
                    
                }
                
            }
        }
        else if(classStr.equals("econ"))
        {
            int bigIndex = 0;
            Passenger biggestBag = econ[row][0];
            if(biggestBag.getCarryOnSizeNum() <= econ[row][1].getCarryOnSizeNum())
            {
                biggestBag = econ[row][1];
            }
            if(biggestBag.getCarryOnSizeNum() <= econ[row][2].getCarryOnSizeNum())
            {
                biggestBag = econ[row][2];
            }
            int index = passList.indexOf(biggestBag);
            int nextPass = index + 1;
            boolean fit = false;
            while(nextPass < passList.size() && !fit)
            {
                boolean found = search(passList.get(nextPass), econ);
                if(found)
                {
                    nextPass++;
                }
                else
                {
                    econ[row][bigIndex] = passList.get(nextPass);
                    fit = checkLuggageFit(econ[row][0], econ[row][1], econ[row][2]);
                    if(!fit)
                    {
                        nextPass++;
                    }
                    
                }
                
            }
        }
    }
    //this method checks to see if the luggage fits
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

        pOne.setCarryOnSizeNum(oneSize);
        pTwo.setCarryOnSizeNum(twoSize);
        pThree.setCarryOnSizeNum(threeSize);

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
    //need to add baggage to this
    public void seatClass(PassengerSorter currSort)
    {
        int i = 0;
        ArrayList<Passenger> currList = currSort.getFirstClassList();
        while(i < currList.size())
        {   if(!search(currList.get(i), firstClass))
            {
                for(int j = 0; j < 8; j++)
                {
                    for(int k = 0; k < 2; k++)
                    {
                        if(firstClass[j][k] == null)
                        {
                            firstClass[j][k] = currList.get(i);
                            i++;
                        }
                    }
                }
            }
            else
            {
                i++;
            }
        }
        int l = 0;
        currList = currSort.getEconomyPlusSeatsList();
        while(l < currList.size())
        {
            if(!search(currList.get(i), econPlus))
            {
                for(int m = 0; m < 18; m++)
                {
                    for(int n = 0; n < 3; n++)
                    {
                        if(econPlus[m][n] == null)
                        {
                            econPlus[m][n] = currList.get(l);
                            l++;
                            if(n == 2)
                            {
                                if(selected.isSortBaggage())
                                {
                                    if (!checkLuggageFit(econPlus[m][0], econPlus[m][1], econPlus[m][2])) 
                                    {
                                        seatBaggage(m, "econPlus", currList);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else
            {
                i++;
            }
        }
        int o = 0;
        currList = currSort.getEconomySeatsList();
        while(l < currList.size())
        {
            if(!search(currList.get(i), econ))
            {
                for(int p = 0; p < 18; p++)
                {
                    for(int q = 0; q < 3; q++)
                    {
                        if(econ[p][q] == null)
                        {
                            econ[p][q] = currList.get(o);
                            o++;
                            if(q == 2)
                            {
                                if(selected.isSortBaggage())
                                {
                                    if (!checkLuggageFit(econ[p][0], econ[p][1], econ[p][2])) 
                                    {
                                        seatBaggage(p, "econ", currList);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else
            {
                i++;
            }
        }
    }
    //need to add baggage to this
    public void seatAge()
    {
        PassengerSorter currSort = selected.getAge();
        if(selected.isSortSeatClass())
        {
            seatClass(currSort);
        }
        else
        {
            int i = 0;
                ArrayList<Passenger> currList = currSort.getAgeList();
                while(i < currList.size())
                {
                    for(int j = 0; j < 8; j++)
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(firstClass[j][k] == null)
                            {
                                firstClass[j][k] = currList.get(i);
                                i++;
                            }
                        }
                    }
                    for(int m = 0; m < 18; m++)
                    {
                        for(int n = 0; n < 3; n++)
                        {
                            if(econPlus[m][n] == null)
                        {
                            econPlus[m][n] = currList.get(i);
                            i++;
                            if(n == 2)
                            {
                                if(selected.isSortBaggage())
                                {
                                    if (!checkLuggageFit(econPlus[m][0], econPlus[m][1], econPlus[m][2])) 
                                    {
                                        seatBaggage(m, "econPlus", currList);
                                    }
                                }
                            }
                        }
                        }
                    }
                    for(int p = 0; p < 18; p++)
                    {
                        for(int q = 0; q < 3; q++)
                        {
                            if(econ[p][q] == null)
                        {
                            econ[p][q] = currList.get(i);
                            i++;
                            if(q == 2)
                            {
                                if(selected.isSortBaggage())
                                {
                                    if (!checkLuggageFit(econ[p][0], econ[p][1], econ[p][2])) 
                                    {
                                        seatBaggage(p, "econ", currList);
                                    }
                                }
                            }
                        }
                        }
                    }
                }
        }
    }
    //need to add baggage
    public void seatGender()
    {
            PassengerSorter currSort1 = selected.getFemale();
            PassengerSorter currSort2 = selected.getMale();
            if(selected.isSortSeatClass())
            {
                seatClass(currSort1);
                seatClass(currSort2);
            }
            else
            {
                int i = 0;
                ArrayList<Passenger> currList = currSort1.getGenderList();
                while(i < currList.size())
                {
                    for(int j = 0; j < 8; j++)
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(firstClass[j][k] == null)
                            {
                                firstClass[j][k] = currList.get(i);
                                i++;
                            }
                        }
                    }
                    for(int m = 0; m < 18; m++)
                    {
                        for(int n = 0; n < 3; n++)
                        {
                            if(econPlus[m][n] == null)
                            {
                                econPlus[m][n] = currList.get(i);
                                i++;
                                if(n == 2)
                                {
                                    if(selected.isSortBaggage())
                                    {
                                        if (!checkLuggageFit(econPlus[m][0], econPlus[m][1], econPlus[m][2])) 
                                        {
                                            seatBaggage(m, "econPlus", currList);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for(int p = 0; p < 18; p++)
                    {
                        for(int q = 0; q < 3; q++)
                        {
                            if(econ[p][q] == null)
                        {
                            econ[p][q] = currList.get(i);
                            i++;
                            if(q == 2)
                            {
                                if(selected.isSortBaggage())
                                {
                                    if (!checkLuggageFit(econ[p][0], econ[p][1], econ[p][2])) 
                                    {
                                        seatBaggage(p, "econ", currList);
                                    }
                                }
                            }
                        }
                        }
                    }
                }

                i = 0;
                currList = currSort2.getGenderList();
                while(i < currList.size())
                {
                    for(int j = 0; j < 8; j++)
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(firstClass[j][k] == null)
                            {
                                firstClass[j][k] = currList.get(i);
                                i++;
                            }
                        }
                    }
                    for(int m = 0; m < 18; m++)
                    {
                        for(int n = 0; n < 3; n++)
                        {
                            if(econPlus[m][n] == null)
                            {
                                econPlus[m][n] = currList.get(i);
                                i++;
                            }
                        }
                    }
                    for(int p = 0; p < 18; p++)
                    {
                        for(int q = 0; q < 3; q++)
                        {
                            if(econ[p][q] == null)
                            {
                                econ[p][q] = currList.get(i);
                                i++;
                            }
                        }
                    }
                }

            }
    }
    //creates a random seating chart
    public void seatRandom()
    {
        int i = 0;
        ArrayList<Passenger> passengers = selected.getOrigList();
        while(i < passengers.size())
        {
            for(int j = 0; j < 8; j++)
            {
                for(int k = 0; k < 2; k++)
                {
                    if(firstClass[j][k] == null)
                    {
                        firstClass[j][k] = passengers.get(i);
                        i++;
                    }
                }
            }
            for(int l = 0; l < 18; l++)
            {
                for(int m = 0; m < 3; m++)
                {
                    if(econPlus[m][l] == null)
                    {
                        econPlus[l][m] = passengers.get(i);
                        i++;
                    }
                    
                }
            }
            for(int n = 0; n < 32; n++)
            {
                for(int o = 0; o < 3; o++)
                {
                    if(econ[n][o] == null)
                    {
                        econ[n][o] = passengers.get(i);
                         i++;
                    }
                    
                }
            }
        }
    }
    //starts the sorting process, need to add baggage
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
            seatForBaggage();
        }
        else
        {
            seatRandom();
        }
    }

    public void seatForBaggage()
    {
        PassengerSorter currSort = selected.getLuggage();
        ArrayList<Passenger> small = currSort.getSmallCarryOnsList();
        ArrayList<Passenger> medium = currSort.getMediumCarryOnsList();
        ArrayList<Passenger> large = currSort.getLargeCarryOnsList();
        ArrayList<Passenger> none = currSort.getNoCarryOnsList();

        Passenger[] fc = new Passenger[16];
        Passenger[] ep = new Passenger[54];
        Passenger[] e = new Passenger[96];

        int largeCount = 0;
        int medCount = 0;
        int smallCount = 0;
        int noneCount = 0;
        
        if(large.size() >= 16)
        {
            for(int i = 0;i < 16; i++)
            {
                fc[i] = large.get(i);
                largeCount = i;
            }
        }
        else if(large.size() + medium.size() >= 16)
        {
            int i = 0;
            while( i < large.size())
            {
                fc[i] = large.get(i);
                i++;
            }
            while(i < 16)
            {
                fc[i] = medium.get(medCount);
                i++;
                medCount++;
            }
        }
        else if(large.size() + medium.size() + small.size() >= 16)
        {
            int i = 0;
            while( i < large.size())
            {
                fc[i] = large.get(i);
                largeCount++;
                i++;
            }
            while(i - largeCount < medium.size())
            {
                fc[i] = medium.get(medCount);
                i++;
                medCount++;
            }
            while(i < 16)
            {
                fc[i] = small.get(smallCount);
                i++;
                smallCount++;
            }
        }
        else if(large.size() + medium.size() + small.size() + small.size() >= 16)
        {
            int i = 0;
            while( i < large.size())
            {
                fc[i] = large.get(i);
                i++;
                largeCount++;
            }
            while(i - largeCount < medium.size())
            {
                fc[i] = medium.get(medCount);
                i++;
                medCount++;
            }
            while(i - largeCount - medCount < small.size())
            {
                fc[i] = small.get(smallCount);
                i++;
                smallCount++;
            }
            while(i < 16)
            {
                fc[i] = none.get(noneCount);
                i++;
                noneCount++;
            }
        }
        if(large.size() > largeCount)
        {
            int i = 0;
            while(i < 54)
            {
                if(large.size() - largeCount >= 2 && none.size() - noneCount >= 1)
                {
                    ep[i] = large.get(largeCount);
                    largeCount++;
                    i++;
                    ep[i] = large.get(largeCount);
                    largeCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    i++;
                    noneCount++;
                }
                else if(large.size() - largeCount >= 1 && small.size() - smallCount >= 2)
                {
                    ep[i] = large.get(largeCount);
                    largeCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(medium.size() - medCount >= 2 && small.size() - smallCount >= 1)
                {
                    ep[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    ep[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(medium.size() - medCount >= 2 && none.size() - noneCount >= 1)
                {
                    ep[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    ep[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(medium.size() - medCount >= 1 && small.size() - smallCount >= 2)
                {
                    ep[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(medium.size() - medCount >= 1 && none.size() - noneCount >= 2)
                {
                    ep[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 3)
                {
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 2 && none.size() - noneCount >= 1)
                {
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 1 && none.size() - noneCount >= 2)
                {
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(none.size() - noneCount >= 3)
                {
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
            }
        }
        else if(medium.size() > medCount)
        {
            int i = 0;
            while(i < 54)
            {
                if(medium.size() - medCount >= 2 && small.size() - smallCount >= 1)
                {
                    ep[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    ep[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(medium.size() - medCount >= 2 && none.size() - noneCount >= 1)
                {
                    ep[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    ep[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(medium.size() - medCount >= 1 && small.size() - smallCount >= 2)
                {
                    ep[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(medium.size() - medCount >= 1 && none.size() - noneCount >= 2)
                {
                    ep[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 3)
                {
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 2 && none.size() - noneCount >= 1)
                {
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 1 && none.size() - noneCount >= 2)
                {
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(none.size() - noneCount >= 3)
                {
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
            }
        }
        else if(small.size() > smallCount)
        {
            int i = 0;
            while(i < 54)
            {
                if(small.size() - smallCount >= 3)
                {
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 2 && none.size() - noneCount >= 1)
                {
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 1 && none.size() - noneCount >= 2)
                {
                    ep[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(none.size() - noneCount >= 3)
                {
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
            }
        }
        else if(none.size() > noneCount)
        {
            int i = 0;
            while(i < 54)
            {
                
                if(none.size() - noneCount >= 3)
                {
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    ep[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
            }
        }

        if(large.size() > largeCount)
        {
            int i = 0;
            while(i < 96)
            {
                if(large.size() - largeCount >= 2 && none.size() - noneCount >= 1)
                {
                    e[i] = large.get(largeCount);
                    largeCount++;
                    i++;
                    e[i] = large.get(largeCount);
                    largeCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    i++;
                    noneCount++;
                }
                else if(large.size() - largeCount >= 1 && small.size() - smallCount >= 2)
                {
                    e[i] = large.get(largeCount);
                    largeCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(medium.size() - medCount >= 2 && small.size() - smallCount >= 1)
                {
                    e[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    e[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(medium.size() - medCount >= 2 && none.size() - noneCount >= 1)
                {
                    e[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    e[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(medium.size() - medCount >= 1 && small.size() - smallCount >= 2)
                {
                    e[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(medium.size() - medCount >= 1 && none.size() - noneCount >= 2)
                {
                    e[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 3)
                {
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 2 && none.size() - noneCount >= 1)
                {
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 1 && none.size() - noneCount >= 2)
                {
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(none.size() - noneCount >= 3)
                {
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
            }
        }
        else if(medium.size() > medCount)
        {
            int i = 0;
            while(i < 96)
            {
               
                if(medium.size() - medCount >= 2 && small.size() - smallCount >= 1)
                {
                    e[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    e[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(medium.size() - medCount >= 2 && none.size() - noneCount >= 1)
                {
                    e[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    e[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(medium.size() - medCount >= 1 && small.size() - smallCount >= 2)
                {
                    e[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(medium.size() - medCount >= 1 && none.size() - noneCount >= 2)
                {
                    e[i] = medium.get(medCount);
                    medCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 3)
                {
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 2 && none.size() - noneCount >= 1)
                {
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 1 && none.size() - noneCount >= 2)
                {
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(none.size() - noneCount >= 3)
                {
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
            }
        }
        else if(small.size() > smallCount)
        {
            int i = 0;
            while(i < 96)
            {
                
                if(small.size() - smallCount >= 3)
                {
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 2 && none.size() - noneCount >= 1)
                {
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(small.size() - smallCount >= 1 && none.size() - noneCount >= 2)
                {
                    e[i] = small.get(smallCount);
                    smallCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
                else if(none.size() - noneCount >= 3)
                {
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
            }
        }
        else if(none.size() > noneCount)
        {
            int i = 0;
            while(i < 96)
            {
                if(none.size() - noneCount >= 3)
                {
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                    e[i] = none.get(noneCount);
                    noneCount++;
                    i++;
                }
            }
        }

    }

    //takes the arrays for the seat classes and put them into the main seating chart array
    public void fillSeatingChart()
    {
        for(int j = 0; j < 8; j++)
        {
            for(int k = 0; k < 2; k++)
            {
                    planeSeatingChart[j][k] = firstClass[j][k];
            }
        }
        for(int l = 0; l < 18; l++)
        {
            for(int m = 0; m < 3; m++)
            {
                planeSeatingChart[l][m] = econPlus[l][m];
            }
        }
        for(int n = 0; n < 32; n++)
        {
            for(int o = 0; o < 3; o++)
            {
                planeSeatingChart[n][o] = econ[n][o];
            }
        }
    }
    //will first fill all of the picked seats
    public void fillPickedSeats()
    {

    }

    public Passenger[][] getPlaneSeatingChart() 
    {
        return planeSeatingChart;
    }

    public boolean search(Passenger pass, Passenger[][] arr)
    {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) 
        {
        for (int j = 0; j < arr[i].length; j++)
            {
                if (arr[i][j] == pass) 
                {
                    found = true;
                }
            }
        }
        return found;
    }
}