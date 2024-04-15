import java.util.ArrayList;

public class LoadingGroups 
{
    
    public LoadingGroups(ArrayList<Passenger>passengerList)
    {
        for (int i = 0; i < passengerList.size(); i++)
        {
            Passenger currentPassenger = passengerList.get(i);
            int seatNum = Integer.parseInt(currentPassenger.getSeat().substring(1));
            String seatLetter = currentPassenger.getSeat().substring(0,1);
            
            //Group 1
            if ((seatNum >= 30) && (seatLetter.equals("A") || seatLetter.equals("F")))
            {
                currentPassenger.setBoardingGroup(1);
            }

            //Group 2
            if ((seatNum > 20 && seatNum <= 29) && (seatLetter.equals("A") || seatLetter.equals("F")))
            {
                currentPassenger.setBoardingGroup(2);
            }

            //Group 3
            if ((seatNum >= 7 && seatNum <= 20) && (seatLetter.equals("A") || seatLetter.equals("F")))
            {
                currentPassenger.setBoardingGroup(3);
            }

            //Group 4
            if ((seatNum >= 30) && (seatLetter.equals("B") || seatLetter.equals("E")))
            {
                currentPassenger.setBoardingGroup(4);
            }

            //Group 5
            if ((seatNum > 20 && seatNum <= 29) && (seatLetter.equals("B") || seatLetter.equals("E")))
            {
                currentPassenger.setBoardingGroup(5);
            }

            //Group 6
            if ((seatNum >= 7 && seatNum <= 20) && (seatLetter.equals("B") || seatLetter.equals("E")))
            {
                currentPassenger.setBoardingGroup(6);
            }

            //Group 7
            if ((seatNum >= 30) && (seatLetter.equals("C") || seatLetter.equals("D")))
            {
                currentPassenger.setBoardingGroup(7);
            }

            //Group 8
            if ((seatNum > 20 && seatNum <= 29) && (seatLetter.equals("C") || seatLetter.equals("D")))
            {
                currentPassenger.setBoardingGroup(8);
            }

            //Group 9
            if ((seatNum >= 7 && seatNum <= 20) && (seatLetter.equals("C") || seatLetter.equals("D")))
            {
                currentPassenger.setBoardingGroup(9);
            }

            //Group 10
            if (seatNum < 7)
            {
                currentPassenger.setBoardingGroup(10);
            }
        }

    }
}
