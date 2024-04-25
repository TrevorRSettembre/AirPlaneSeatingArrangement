import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class PassengerSorterSelector 
{
    private PassengerSorter female;
    private PassengerSorter male;
    private PassengerSorter age;
    private PassengerSorter seatClass;
    private PassengerSorter luggage;

    private ArrayList<Passenger> passengerList;
    private boolean sortGender;
    private boolean sortSeatClass;
    private boolean sortAge;
    private boolean sortBaggage;
    private ArrayList<Passenger> origList;

    public PassengerSorterSelector (ArrayList<Passenger>passengerList)
    {
        this.passengerList = passengerList;
    }

    public void sortSelect()
    {
        origList = passengerList;
        sortAge = false;
        sortBaggage = false;
        sortGender = false;
        sortSeatClass = false;  
      
        ArrayList<String[]> answers = fileReader();
        int genderInput = Integer.parseInt(answers.get(0)[0]);
        int ageInput = Integer.parseInt(answers.get(0)[1]);
        int classInput = Integer.parseInt(answers.get(0)[2]);
        int luggageInput = Integer.parseInt(answers.get(0)[3]);
        //int passengerSorter = Integer.parseInt(answers.get(0)[4]);
        
        //System.out.println(genderInput);
        //System.out.println(ageInput);
        //System.out.println(classInput);
        //System.out.println(luggageInput);

        //Sorting by gender
        if (genderInput == 1) {

            female = new PassengerSorter();
            female.femaleSorter(passengerList);
            male = new PassengerSorter();
            male.maleSorter(passengerList);
            sortGender = true;
        }

        //Sorting by age
        if (ageInput == 1){
          sortAge = true;
            if (genderInput == 1) {
                female.ageSorter(female.getGenderList());
                male.ageSorter(male.getGenderList());

            }
            else {
                age = new PassengerSorter();
                age.ageSorter(passengerList);
            }
        }

        //Sorting by class
        if (classInput == 1) {
          sortSeatClass = true;
            if (genderInput == 1) {

                //If sorting by gender and class of seat
                if (ageInput == 0) {
                    female.firstClassSeatsSorter(female.getGenderList());
                    female.economySeatsSorter(female.getGenderList());
                    female.economyPlusSeatsSorter(female.getGenderList());
                    male.firstClassSeatsSorter(male.getGenderList());
                    male.economySeatsSorter(male.getGenderList());
                    male.economyPlusSeatsSorter(male.getGenderList());
                }
                //If sorting by gender, age, and class of seat
                else {
                    female.firstClassSeatsSorter(female.getAgeList());
                    female.economySeatsSorter(female.getAgeList());
                    female.economyPlusSeatsSorter(female.getAgeList());
                    male.firstClassSeatsSorter(male.getAgeList());
                    male.economySeatsSorter(male.getAgeList());
                    male.economyPlusSeatsSorter(male.getAgeList());
                }
            }
            //If sorting by age and class of seat
            else if (genderInput == 0 && ageInput == 1) {
                age.firstClassSeatsSorter(age.getAgeList());
                age.economySeatsSorter(age.getAgeList());
                age.economyPlusSeatsSorter(age.getAgeList());
                }
            //If sorting by class of seat
            else {
                seatClass = new PassengerSorter();
                seatClass.firstClassSeatsSorter(passengerList);
                seatClass.economySeatsSorter(passengerList);
                seatClass.economyPlusSeatsSorter(passengerList);
            }
        } 

        //Sorting by luggage
        if (luggageInput == 1) {
          sortBaggage = true;
            if (genderInput == 1) {

                //If sorting by gender, age, class of seat, and luggage 
                //or if sorting by gender, class of seat, and luggage
                if (classInput == 1) 
                {
                    female.smallCarryOnSorter(female.getFirstClassList());
                    female.smallCarryOnSorter(female.getEconomySeatsList());
                    female.smallCarryOnSorter(female.getEconomyPlusSeatsList());
                    female.mediumCarryOnSorter(female.getFirstClassList());
                    female.mediumCarryOnSorter(female.getEconomySeatsList());
                    female.mediumCarryOnSorter(female.getEconomyPlusSeatsList());
                    female.largeCarryOnSorter(female.getFirstClassList());
                    female.largeCarryOnSorter(female.getEconomySeatsList());
                    female.largeCarryOnSorter(female.getEconomyPlusSeatsList());
                    female.noCarryOnSorter(female.getFirstClassList());
                    female.noCarryOnSorter(female.getEconomySeatsList());
                    female.noCarryOnSorter(female.getEconomyPlusSeatsList());
                    male.smallCarryOnSorter(male.getFirstClassList());
                    male.smallCarryOnSorter(male.getEconomySeatsList());
                    male.smallCarryOnSorter(male.getEconomyPlusSeatsList());
                    male.mediumCarryOnSorter(male.getFirstClassList());
                    male.mediumCarryOnSorter(male.getEconomySeatsList());
                    male.mediumCarryOnSorter(male.getEconomyPlusSeatsList());
                    male.largeCarryOnSorter(male.getFirstClassList());
                    male.largeCarryOnSorter(male.getEconomySeatsList());
                    male.largeCarryOnSorter(male.getEconomyPlusSeatsList());
                    male.noCarryOnSorter(male.getFirstClassList());
                    male.noCarryOnSorter(male.getEconomySeatsList());
                    male.noCarryOnSorter(male.getEconomyPlusSeatsList());
                }
                //If sorting by gender, age, and luggage
                //or if sorting by gender and luggage
                else 
                {
                    female.smallCarryOnSorter(female.getAgeList());
                    female.mediumCarryOnSorter(female.getAgeList());
                    female.largeCarryOnSorter(female.getAgeList());
                    female.noCarryOnSorter(female.getAgeList());
                    male.smallCarryOnSorter(male.getAgeList());
                    male.mediumCarryOnSorter(male.getAgeList());
                    male.largeCarryOnSorter(male.getAgeList());
                    male.noCarryOnSorter(male.getAgeList());
                }
            }
            else if (ageInput == 1 && genderInput == 0) {
                //If sorting by age, class of seats, and luggage
                if (classInput == 1) {
                    age.smallCarryOnSorter(age.getFirstClassList());
                    age.smallCarryOnSorter(age.getEconomySeatsList());
                    age.smallCarryOnSorter(age.getEconomyPlusSeatsList());
                    age.mediumCarryOnSorter(age.getFirstClassList());
                    age.mediumCarryOnSorter(age.getEconomySeatsList());
                    age.mediumCarryOnSorter(age.getEconomyPlusSeatsList());
                    age.largeCarryOnSorter(age.getFirstClassList());
                    age.largeCarryOnSorter(age.getEconomySeatsList());
                    age.largeCarryOnSorter(age.getEconomyPlusSeatsList());
                    age.noCarryOnSorter(age.getFirstClassList());
                    age.noCarryOnSorter(age.getEconomySeatsList());
                    age.noCarryOnSorter(age.getEconomyPlusSeatsList());
                }
                //If sorting by age and lugagge
                else {
                    age.smallCarryOnSorter(age.getAgeList());
                    age.mediumCarryOnSorter(age.getAgeList());
                    age.largeCarryOnSorter(age.getAgeList());
                    age.noCarryOnSorter(age.getAgeList());
                }
            }
            //If sorting by class of seat and luggage 
            else if (ageInput == 0 && genderInput == 0 && classInput == 1) {
                seatClass.smallCarryOnSorter(seatClass.getFirstClassList());
                seatClass.smallCarryOnSorter(seatClass.getEconomySeatsList());
                seatClass.smallCarryOnSorter(seatClass.getEconomyPlusSeatsList());
                seatClass.mediumCarryOnSorter(seatClass.getFirstClassList());
                seatClass.mediumCarryOnSorter(seatClass.getEconomySeatsList());
                seatClass.mediumCarryOnSorter(seatClass.getEconomyPlusSeatsList());
                seatClass.largeCarryOnSorter(seatClass.getFirstClassList());
                seatClass.largeCarryOnSorter(seatClass.getEconomySeatsList());
                seatClass.largeCarryOnSorter(seatClass.getEconomyPlusSeatsList());
                seatClass.noCarryOnSorter(seatClass.getFirstClassList());
                seatClass.noCarryOnSorter(seatClass.getEconomySeatsList());
                seatClass.noCarryOnSorter(seatClass.getEconomyPlusSeatsList());
            }
            //If sorting by luggage only
            else {
                luggage = new PassengerSorter();
                luggage.smallCarryOnSorter(passengerList);
                luggage.mediumCarryOnSorter(passengerList);
                luggage.largeCarryOnSorter(passengerList);
                luggage.noCarryOnSorter(passengerList);
            }

        }
        
    }

    public ArrayList<String[]> fileReader()
    {
        String fileName = "answerInfo.csv";
        String delimiter = ",";

        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            ArrayList<String[]> sortingAnswerList = new ArrayList<String[]>();
            while((line = bufferedReader.readLine()) != null){
                sortingAnswerList.add(line.split(delimiter));
            }
            return sortingAnswerList;
            
        } catch (Exception e) {
            System.out.println("There is an error with answerInfo.csv");
            return null;
        }
    }
    public PassengerSorter getFemale() {
        return female;
    }

    public PassengerSorter getMale() {
        return male;
    }

    public PassengerSorter getAge() {
        return age;
    }

    public PassengerSorter getSeatClass() {
        return seatClass;
    }

    public PassengerSorter getLuggage() {
        return luggage;
    }

    public boolean isSortGender() {
        return sortGender;
    }

    public boolean isSortSeatClass() {
        return sortSeatClass;
    }

    public boolean isSortAge() {
        return sortAge;
    }

    public boolean isSortBaggage() {
        return sortBaggage;
    }

    public ArrayList<Passenger> getOrigList()
    {
        return origList;

    }

}
