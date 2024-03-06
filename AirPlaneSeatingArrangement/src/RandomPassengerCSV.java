import java.util.ArrayList;
import java.util.Collections;

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

    int planeMax;
    int passengerCount;


    /**
     * 
     * @param planeMax
     * @param passengerCount make it random
     */
    public RandomPassengerCSV(int planeMax, int passengerCount){

        this.planeMax = planeMax;
        //min number of passengers?
        //for now max 56
        this.passengerCount = passengerCount;
    }

    
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

    
    private ArrayList<ArrayList<ArrayList<String>>> generateGroups(){
       

        ArrayList<Integer> passengerId = new ArrayList<Integer>();
        ArrayList<ArrayList<String>> firstClass = new ArrayList<ArrayList<String>>();
        //List(first(groups(ids)) , second(groups), thrid(groups))
        ArrayList<ArrayList<ArrayList<String>>> passengerGroup = new ArrayList<ArrayList<ArrayList<String>>>();
     

       
        for(int i = 0; i < passengerCount;i++){
            passengerId.add(i+1);
        }
        //Also max of 4 to make it easy
        int row = 1;
        for (int i = 0; i < randomNumberGen.RandomInt(1, 4); i++) {
            ArrayList<String> innerList = new ArrayList<String>();

            // max group count for first class is 4 due to seat length to make it easier
            int maxPassengers = Math.min(randomNumberGen.RandomInt(1, 4), passengerId.size());
            for(int j = 0; j < maxPassengers; j++) {  
             //   innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(0, (passengerId.size()-1)))).concat(selectedSeat.getRow1(0)));
             //make better just need beta for sprint
               switch (row) {
                case 1:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(0, (passengerId.size()-1)))).concat(selectedSeat.getRow1(0)));
                    selectedSeat.removeIndexRow1(0);
                    break;
                case 2:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(0, (passengerId.size()-1)))).concat(selectedSeat.getRow2(0)));
                    selectedSeat.removeIndexRow2(0);
                    break;
                case 3:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(0, (passengerId.size()-1)))).concat(selectedSeat.getRow3(0)));
                    selectedSeat.removeIndexRow3(0);
                    break;
                case 4:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(0, (passengerId.size()-1)))).concat(selectedSeat.getRow4(0)));
                    selectedSeat.removeIndexRow4(0);
                    break;
                
               
                default:
                    break;
               }
                // selectedSeat.removeIndexRow1(0);
                //System.out.println(innerList.get(j));
                String parsedId = innerList.get(j).substring(0,(innerList.get(j).length()-2));
                // System.out.println(parsedId);
                passengerId.remove(Integer.valueOf(parsedId));

            }
            //Collections.sort(innerList);
            firstClass.add(innerList);
            row++;
        }
        System.out.println(firstClass);
        // System.out.println(passengerId);

        passengerGroup.add(firstClass);
        // passengerGroup.add(econPlus);
        // passengerGroup.add(econ);


        //passengerGroup.get(firstclass).get(firstClass group one).get(id)

        
       
       return passengerGroup;



    }

   
    /**
     * Creates a scalable arraylist containg random passenger inforaion
     * @param passengerCount how many passengers created
     */
    public void createPassengerCSV(){
        String fileName = "passengerInfo.csv";
        passengerCSVWritew.CreateFile(fileName);
        ArrayList<ArrayList<ArrayList<String>>> groups = new ArrayList<ArrayList<ArrayList<String>>>();
        groups = generateGroups();

        for(int id=0;id<passengerCount;id++){
            ArrayList<String> passengerStats = new ArrayList<String>();
            String[] namesGender = new String[3];
            String[] carryon = new String[2];
            namesGender = generateFirstLastNamesAndGender();
            carryon = generateCarryon();

            passengerStats.add(String.valueOf(id));
            passengerStats.add(namesGender[0]);
            passengerStats.add(namesGender[1]);
            passengerStats.add(namesGender[2]);
            passengerStats.add(generateAge());
            passengerStats.add(carryon[0]);
            passengerStats.add(carryon[1]);
            /**
             * 0 = first
             * 1 = econplus
             * 2 = econ
             * 
             */
            //passengerGroup.get(firstclass).get(firstClass group one).get(id)
            
            //Length of First class 1-4
            for(int i = 0; i < groups.get(0).size(); i++){
                //first class group index 
                for(int j = 0; j < groups.get(0).get(i).size();j++){
                    if(id == Integer.parseInt(groups.get(0).get(i).get(j).substring(0, groups.get(0).get(i).get(j).length() - 2))){
                        passengerStats.add(groups.get(0).get(i).get(j).substring(Math.max(groups.get(0).get(i).get(j).length() - 2, 0)));
                    }
                }


            }

           
           
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