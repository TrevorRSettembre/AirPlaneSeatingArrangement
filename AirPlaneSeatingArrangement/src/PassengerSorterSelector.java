import java.util.ArrayList;
import java.util.Scanner;

public class PassengerSorterSelector 
{
    private PassengerSorter female;
    private PassengerSorter male;
    private PassengerSorter age;
    private PassengerSorter seatClass;
    private PassengerSorter luggage;
    private boolean sortGender;
    private boolean sortSeatClass;
    private boolean sortAge;
    private boolean sortBaggage;
    private ArrayList<Passenger> origList;

    public PassengerSorterSelector (ArrayList<Passenger>passengerList)
    {
        origList = passengerList;
        sortAge = false;
        sortBaggage = false;
        sortGender = false;
        sortSeatClass = false;
        Scanner in = new Scanner(System.in);
        String genderInput = "", ageInput = "", classInput = "", luggageInput = "";
        PassengerSorter passengerSorter = new PassengerSorter();
        boolean valid = false;
        //Asks about sorting by gender
        while  (!valid) {
            System.out.println("Would you like to sort by gender? (y/n)");
            genderInput = in.nextLine().toLowerCase();
			valid = checkAnswerInput(genderInput);
        }
        if (genderInput.equalsIgnoreCase("y")) {
            female = new PassengerSorter();
            female.femaleSorter(passengerList);
            male = new PassengerSorter();
            male.maleSorter(passengerList);
            sortGender = true;
        }
        //Asks about sorting by age
        valid = false;
        while  (!valid) {
            System.out.println("Would you like to sort by age? (y/n)");
            ageInput = in.nextLine().toLowerCase();
			valid = checkAnswerInput(ageInput);
        }
        if (ageInput.equalsIgnoreCase("y")){
            sortAge = true;
            if (genderInput.equalsIgnoreCase("y")) {
                passengerSorter.ageSorter(female.getGenderList());
                passengerSorter.ageSorter(male.getGenderList());
            }
            else {
                age = new PassengerSorter();
                age.ageSorter(passengerList);
            }
        }
        //Asks about sorting by class
        valid = false;
        while  (!valid) {
            System.out.println("Would you like to sort by class of seats? (y/n)");
            classInput = in.nextLine().toLowerCase();
			valid = checkAnswerInput(ageInput);
        }
        if (classInput.equalsIgnoreCase("y")) {
            sortSeatClass = true;
            if (genderInput.equalsIgnoreCase("y")) {
                //If sorting by gender and class of seat
                if (ageInput.equalsIgnoreCase("n")) {
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
            else if (genderInput.equalsIgnoreCase("n") && ageInput.equalsIgnoreCase("y")) {
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
        //Asks about sorting by luggage
        valid = false;
        while  (!valid) {
            System.out.println("Would you like to sort luggage age? (y/n)");
            luggageInput = in.nextLine().toLowerCase();
			valid = checkAnswerInput(ageInput);
        }
        if (luggageInput.equalsIgnoreCase("y")) {
            sortBaggage = true;
            if (genderInput.equalsIgnoreCase("y")) {
                //If sorting by gender, age, class of seat, and luggage 
                //or if sorting by gender, class of seat, and luggage
                if (classInput.equalsIgnoreCase("y")) 
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
            else if (ageInput.equalsIgnoreCase("y") && genderInput.equalsIgnoreCase("n")) {
                //If sorting by age, class of seats, and luggage
                if (classInput.equalsIgnoreCase("y")) {
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
            else if (ageInput.equalsIgnoreCase("n") && genderInput.equalsIgnoreCase("n") && classInput.equalsIgnoreCase("y")) {
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

    public boolean checkAnswerInput(String input)
	{
		if (input.equalsIgnoreCase("y"))
			return true;
		else if (input.equalsIgnoreCase("n"))
			return true;
		else {
			System.out.println("INVALID INPUT. Try again. ");
			return false;
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
