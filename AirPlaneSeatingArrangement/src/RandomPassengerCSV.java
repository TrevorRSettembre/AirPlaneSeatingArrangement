import java.util.ArrayList;

public class RandomPassengerCSV {



    private RandomNumberGen randomNumberGen = new RandomNumberGen();
    private SelectedSeat selectedSeat = new SelectedSeat();
    
    private FileManager passengerCSVWritew = new FileManager("AirPlaneSeatingArrangement\\src\\Names");

    private FileManager firstNameMenReader = new FileManager("AirPlaneSeatingArrangement\\src\\Names\\FirstNameMen.txt");
    private FileManager firstNameWomenReader = new FileManager("AirPlaneSeatingArrangement\\src\\Names\\FirstNameWoman.txt");
    private FileManager lastNameReader = new FileManager("AirPlaneSeatingArrangement\\src\\Names\\LastName.txt");

    private ArrayList<String> firstNamesMen = new ArrayList<String>(firstNameMenReader.readFirstLastNameFile());
    private ArrayList<String> firstNamesWomen = new ArrayList<String>(firstNameWomenReader.readFirstLastNameFile());
    private ArrayList<String> lastNames = new ArrayList<String>(lastNameReader.readFirstLastNameFile());
    
    /**
     * 
     * @return string array {"First Name","Last Name","Gender"}
     */
    private String[] generateFirstLastNamesAndGender(){
         
        String[] nameGender = new String[3];

        switch (randomNumberGen.RandomInt(0, 1)) {
            case 0:
                nameGender[0] = firstNamesMen.get(randomNumberGen.RandomInt(0, firstNamesMen.size()-1));
                nameGender[1] = lastNames.get(randomNumberGen.RandomInt(0, lastNames.size()-1));
                nameGender[2] = "male";
                
                break;

            case 1:
                nameGender[0] = firstNamesWomen.get(randomNumberGen.RandomInt(0, firstNamesWomen.size()-1));
                nameGender[1] = lastNames.get(randomNumberGen.RandomInt(0, lastNames.size()-1));
                nameGender[2] = "female";
                break;

            default:
            //add something eventully
                break;
        }

        return nameGender;
    }

    /**
     * 
     * @return age as an int from min = 1 to max = 100 
     */
    private String generateAge(){
        return Integer.toString(randomNumberGen.RandomInt(1, 100));
    }

    /**
     * fix weight to make it not by size
     * Change index 1 to an int later maybe add random weight
     * @return generates carryon as a string[] = {"size","weight"}
     */
    private String[] generateCarryon(){

        String[] carryon = new String[2];
        int i = randomNumberGen.RandomInt(0, 3);
        switch (i) {
            case 0:
                carryon[0] = "NA";
                carryon[1] = "0";
                break;

            case 1:
                carryon[0] = "small";
                carryon[1] = Integer.toString(randomNumberGen.RandomInt(1, 40));
                break;

            case 2:
                carryon[0] = "medium";
                carryon[1] = Integer.toString(randomNumberGen.RandomInt(1, 40));
                break;

            case 3:
                carryon[0] = "large";
                carryon[1] = Integer.toString(randomNumberGen.RandomInt(1, 40));
                break;

            default:
                carryon[0] = "NA";
                carryon[1] = "0";
                break;
        }

        return carryon;

    }

    /**
     * 
     * figure out how many passengers
     */
    private void generateFristClassGroups(){
    
        int planeMax = 202; 
        //bost min number
        int passengerCount = randomNumberGen.RandomInt(50, planeMax);

        ArrayList<Integer> passengerId = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> firstClass = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<ArrayList<Integer>>> passengerGroup = new ArrayList<ArrayList<ArrayList<Integer>>>();
     

       
        for(int i = 0; i < passengerCount;i++){
            passengerId.add(i+1);
        }

        for (int i = 0; i < randomNumberGen.RandomInt(1, 6); i++) {
            ArrayList<Integer> innerList = new ArrayList<Integer>();

            // max group count for first class is 4 due to seat length to make it easier
            for (int j = 0; j < randomNumberGen.RandomInt(1, 6); j++) {  
                innerList.add(passengerId.get(randomNumberGen.RandomInt(0, (passengerId.size()-1))));
                passengerId.remove(innerList.get(j));
            }
            firstClass.add(innerList);
        }

        //EconPlus-----------------------------------------------------------------------------------------

        ArrayList<ArrayList<Integer>> econPlus = new ArrayList<ArrayList<Integer>>();
       
        for (int i = 0; i < randomNumberGen.RandomInt(1, 6); i++) {
            ArrayList<Integer> innerList = new ArrayList<Integer>();

            // max group count 6
            for (int j = 0; j < randomNumberGen.RandomInt(1, 6); j++) {  
                innerList.add(passengerId.get(randomNumberGen.RandomInt(0, (passengerId.size()-1))));
                passengerId.remove(innerList.get(j));
            }
            econPlus.add(innerList);
        }

        //Econ---------------------------------------------------------------------------------------------

        ArrayList<ArrayList<Integer>> econ = new ArrayList<ArrayList<Integer>>();
       
        for (int i = 0; i < randomNumberGen.RandomInt(1, 6); i++) {
            ArrayList<Integer> innerList = new ArrayList<Integer>();

            // max group count 6
            for (int j = 0; j < randomNumberGen.RandomInt(1, 6); j++) {  
                innerList.add(passengerId.get(randomNumberGen.RandomInt(0, (passengerId.size()-1))));
                passengerId.remove(innerList.get(j));
            }
            econ.add(innerList);
        }  
        


    passengerGroup.add(firstClass);




    }

    public void assignSeets(){
        
    }

    /**
     * Creates a scalable arraylist containg random passenger inforaion
     * @param passengerCount how many passengers created
     */
    public void createPassengerCSV(int passengerCount){
        String fileName = "passengerInfo.csv";
        passengerCSVWritew.CreateFile(fileName);
        for(int i=0;i<passengerCount;i++){
            ArrayList<String> passengerStats = new ArrayList<String>();
            String[] namesGender = new String[3];
            String[] carryon = new String[2];
            namesGender = generateFirstLastNamesAndGender();
            carryon = generateCarryon();

            passengerStats.add(namesGender[0]);
            passengerStats.add(namesGender[1]);
            passengerStats.add(namesGender[2]);
            passengerStats.add(generateAge());
            passengerStats.add(carryon[0]);
            passengerStats.add(carryon[1]);
            //Specific seat?
            //bought multiple seats?

            /*
             * turns arraylist into stringbuilder which is 
             * a coma seperated string in this case
             */
            StringBuilder css = new StringBuilder();
            for(int j=0;j<passengerStats.size();j++){
                css.append(passengerStats.get(j));
                if(j<passengerStats.size() - 1){
                    css.append(",");
                }
            }
            passengerCSVWritew.fileWriter(fileName, css.toString());
            

       }
        
    }

}



// //work on adding the assignd seats and add adjecent seats.

// ArrayList<String> firstClassSeats = new ArrayList<String>();
// ArrayList<String> econPlusSeats = new ArrayList<String>();
// ArrayList<String> econSeats = new ArrayList<String>();


// String firstClassSeatNumber = selectedSeat.getFirstClassSeat(randomNumberGen.RandomInt(0, (selectedSeat.getFirstClassLength()-1)));

// char col = firstClassSeatNumber.charAt(0);
// char row = firstClassSeatNumber.charAt(1);

// System.out.println(col);
// System.out.println(row);

// switch (col) {
//     case 'A':
    
//     //for loop somewhere
//         //how big is the group
        

//         for(int i = 0;i<firstClass.get(0).size();i++){
            
//         }

//         break;
//     case 'B':
//         break;
//     case 'E':
//         break;
//     case 'F':
//         break;
        

//     default:
//         break;
// } 