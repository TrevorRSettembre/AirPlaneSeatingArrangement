import java.util.ArrayList;

public class RandomPassengerCSV {

    private RandomNumberGen randomNumberGen = new RandomNumberGen();
    private SelectedSeat selectedSeat = new SelectedSeat();
    private SelectedSeat findSeatLocation = new SelectedSeat();
    private FileManager passengerCSVWritew = new FileManager("AirPlaneSeatingArrangement\\src\\Names");

    private FileManager firstNameMenReader = new FileManager("AirPlaneSeatingArrangement\\src\\Names\\FirstNameMen.txt");
    private FileManager firstNameWomenReader = new FileManager("AirPlaneSeatingArrangement\\src\\Names\\FirstNameWoman.txt");
    private FileManager lastNameReader = new FileManager("AirPlaneSeatingArrangement\\src\\Names\\LastName.txt");

    private ArrayList<String> firstNamesMen = new ArrayList<String>(firstNameMenReader.readFirstLastNameFile());
    private ArrayList<String> firstNamesWomen = new ArrayList<String>(firstNameWomenReader.readFirstLastNameFile());
    private ArrayList<String> lastNames = new ArrayList<String>(lastNameReader.readFirstLastNameFile());

    private int passengerCount;
    
    private int firstClassCount = 16;
    private int secondClassCount = 54;
    private int thirdClassCount = 96;

    private int min = 1;
    private int max = 3;
    private int fcs = 0;
    private int epcs = 0;
    private int ecs  = 0;
    private int r = 0;
    private boolean hasRunFCS = false;
    private boolean hasRunEPCS = false;
    private boolean hasRunECS = false;
    /**
     * 
     * @param planeMax
     * @param passengerCount make it random
     */
    public RandomPassengerCSV(int passengerCount){

       
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
                carryon[0] = "NULL";
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
                break;
        }

        return carryon;

    }

    
    private ArrayList<ArrayList<ArrayList<String>>> generateGroups(){
       

        ArrayList<Integer> passengerId = new ArrayList<Integer>();
        ArrayList<ArrayList<String>> firstClass = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> econPlusClass = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> econClass = new ArrayList<ArrayList<String>>();
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
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(0, (passengerId.size()-1)))).concat(selectedSeat.getFirstClassRow(1,0)));
                    selectedSeat.removeFirstClassRow(1, 0);
                    break;
                case 2:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(0, (passengerId.size()-1)))).concat(selectedSeat.getFirstClassRow(2,0)));
                    selectedSeat.removeFirstClassRow(2, 0);
                    break;
                case 3:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(0, (passengerId.size()-1)))).concat(selectedSeat.getFirstClassRow(3,0)));
                    selectedSeat.removeFirstClassRow(3, 0);
                    break;
                case 4:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(0, (passengerId.size()-1)))).concat(selectedSeat.getFirstClassRow(4,0)));
                    selectedSeat.removeFirstClassRow(4, 0);
                    break;
                
               
                default:
                    break;
               }
                String parsedId = innerList.get(j).substring(0,(innerList.get(j).length()-2));
                passengerId.remove(Integer.valueOf(parsedId));
            }
            firstClass.add(innerList);
            row++;
        }
     

        passengerGroup.add(firstClass);       

        //Econ plus---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        int row2 = 1;
        for (int i = 0; i < randomNumberGen.RandomInt(1, 9); i++) {
            ArrayList<String> innerList = new ArrayList<String>();
            // max group count for first class is 6 due to seat length to make it easier
            int maxPassengers = Math.min(randomNumberGen.RandomInt(1, 6), passengerId.size());
            for(int j = 0; j < maxPassengers; j++) {  
             //   innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(0, (passengerId.size()-1)))).concat(selectedSeat.getRow1(0)));
             //make better just need beta for sprint
             //pretty much done but error when passenger id is single digith and seat is double
             //hard coded error correction
             int error = 10;
               switch (row2) {
                case 1:
                    
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconPlusClassRow(7,0)));
                    selectedSeat.removeEconPLusClassRow(7, 0);
                    break;
                case 2:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconPlusClassRow(8,0)));
                    selectedSeat.removeEconPLusClassRow(8, 0);
                    break;
                case 3:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconPlusClassRow(10,0)));
                    selectedSeat.removeEconPLusClassRow(10, 0);
                    break;
                case 4:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconPlusClassRow(11,0)));
                    selectedSeat.removeEconPLusClassRow(11, 0);
                    break;
                case 5:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconPlusClassRow(12,0)));
                    selectedSeat.removeEconPLusClassRow(12, 0);
                    break;
                case 6:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconPlusClassRow(14,0)));
                    selectedSeat.removeEconPLusClassRow(14, 0);
                    break;
                case 7:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconPlusClassRow(15,0)));
                    selectedSeat.removeEconPLusClassRow(15, 0);
                    break;
                case 8:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconPlusClassRow(20,0)));
                    selectedSeat.removeEconPLusClassRow(20, 0);
                    break;
                case 9:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getFirstClassRow(21,0)));
                    selectedSeat.removeEconPLusClassRow(21, 0);
                    break;
  
                default:
                    break;
               }
               

              
               String parsedId = "";
               if(innerList.get(j).length() >= 5){
                //156B12
                //12B7
                parsedId = innerList.get(j).substring(0,(innerList.get(j).length()-3));
               }else{
                parsedId = innerList.get(j).substring(0,(innerList.get(j).length()-2));
               }
              
                passengerId.remove(Integer.valueOf(parsedId));
            }
            econPlusClass.add(innerList);
            row2++;
        }
     

        passengerGroup.add(econPlusClass);   
        
        //Econ plus---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        int row3 = 1;
        for (int i = 0; i < randomNumberGen.RandomInt(1, 16); i++) {
            ArrayList<String> innerList = new ArrayList<String>();
            // max group count for first class is 6 due to seat length to make it easier
            int maxPassengers = Math.min(randomNumberGen.RandomInt(1, 6), passengerId.size());
            for(int j = 0; j < maxPassengers; j++) {  
             //   innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(0, (passengerId.size()-1)))).concat(selectedSeat.getRow1(0)));
             //make better just need beta for sprint
             //pretty much done but error when passenger id is single digith and seat is double
             //hard coded error correction
             int error = 10;
               switch (row3) {
                case 1:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(22,0)));
                    selectedSeat.removeEconClassRow(22, 0);
                    break;
                case 2:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(23,0)));
                    selectedSeat.removeEconClassRow(23, 0);
                    break;
                case 3:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(24,0)));
                    selectedSeat.removeEconClassRow(24, 0);
                    break;
                case 4:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(25,0)));
                    selectedSeat.removeEconClassRow(25, 0);
                    break;
                case 5:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(26,0)));
                    selectedSeat.removeEconClassRow(26, 0);
                    break;
                case 6:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(27,0)));
                    selectedSeat.removeEconClassRow(27, 0);
                    break;
                case 7:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(28,0)));
                    selectedSeat.removeEconClassRow(28, 0);
                    break;
                case 8:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(29,0)));
                    selectedSeat.removeEconClassRow(29, 0);
                    break;
                case 9:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(30,0)));
                    selectedSeat.removeEconClassRow(30, 0);
                    break;
                case 10:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(31,0)));
                    selectedSeat.removeEconClassRow(31, 0);
                    break;
                case 11:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(32,0)));
                    selectedSeat.removeEconClassRow(32, 0);
                    break;
                case 12:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(34,0)));
                    selectedSeat.removeEconClassRow(34, 0);
                    break;
                case 13:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(35,0)));
                    selectedSeat.removeEconClassRow(35, 0);
                    break;
                case 14:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(36,0)));
                    selectedSeat.removeEconClassRow(36, 0);
                    break;
                case 15:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(37,0)));
                    selectedSeat.removeEconClassRow(37, 0);
                    break;
                case 16:
                    innerList.add(String.valueOf(passengerId.get(randomNumberGen.RandomInt(error, (passengerId.size()-1)))).concat(selectedSeat.getEconClassRow(38,0)));
                    selectedSeat.removeEconClassRow(38, 0);
                    break;
                default:
                    break;
               }
               

           
               String parsedId = "";
               if(innerList.get(j).length() >= 5){
                parsedId = innerList.get(j).substring(0,(innerList.get(j).length()-3));
               }else{
                parsedId = innerList.get(j).substring(0,(innerList.get(j).length()-2));
               }
              
                passengerId.remove(Integer.valueOf(parsedId));
            }
            econClass.add(innerList);
            row3++;
        }
     

        passengerGroup.add(econClass);   
       
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
            /**
             * 0 = first
             * 1 = econplus
             * 2 = econ
             * 
             */
            //passengerGroup.get(firstclass).get(firstClass group one).get(id)
            //Length of econ plus class 7,8,10,11,12,14,15,20,21
            for(int i = 0; i < groups.get(1).size(); i++){
                //first class group index 
                for(int j = 0; j < groups.get(1).get(i).size();j++){
                    if(groups.get(1).get(i).get(j).length() >= 5){
                        if(id == Integer.parseInt(groups.get(1).get(i).get(j).substring(0, groups.get(1).get(i).get(j).length() - 3))){
                            passengerStats.add(groups.get(1).get(i).get(j).substring(Math.max(groups.get(1).get(i).get(j).length() - 3, 0)));
                        }
                    }else{
                        if(id == Integer.parseInt(groups.get(1).get(i).get(j).substring(0, groups.get(1).get(i).get(j).length() - 2))){
                            passengerStats.add(groups.get(1).get(i).get(j).substring(Math.max(groups.get(1).get(i).get(j).length() - 2, 0)));
                        }
                    }
                    
                }


            }

             /**
             * 0 = first
             * 1 = econplus
             * 2 = econ
             * 
             */
            //passengerGroup.get(firstclass).get(firstClass group one).get(id)
            //Length of econ plus class 7,8,10,11,12,14,15,20,21
            for(int i = 0; i < groups.get(2).size(); i++){
                //first class group index 
                for(int j = 0; j < groups.get(2).get(i).size();j++){
                    if(groups.get(2).get(i).get(j).length() >= 5){
                        if(id == Integer.parseInt(groups.get(2).get(i).get(j).substring(0, groups.get(2).get(i).get(j).length() - 3))){
                            passengerStats.add(groups.get(2).get(i).get(j).substring(Math.max(groups.get(2).get(i).get(j).length() - 3, 0)));
                        }
                    }else{
                        if(id == Integer.parseInt(groups.get(2).get(i).get(j).substring(0, groups.get(2).get(i).get(j).length() - 2))){
                            passengerStats.add(groups.get(2).get(i).get(j).substring(Math.max(groups.get(2).get(i).get(j).length() - 2, 0)));
                        }
                    }
                    
                }


            }

            int firstClassGroupCount = 0;
            for(int i=0;i < groups.get(0).size();i++){
                firstClassGroupCount += groups.get(0).get(i).size();
            }

            if(!hasRunFCS){
                fcs = firstClassCount - firstClassGroupCount;
                hasRunFCS = true;
            }

            int econPlusClassGroupCount = 0;
            for(int i=0;i < groups.get(1).size();i++){
                econPlusClassGroupCount += groups.get(1).get(i).size();
            }

            if(!hasRunEPCS){
                epcs = secondClassCount - econPlusClassGroupCount;
                hasRunEPCS = true;
            }

            int econClassGroupCount = 0;
            for(int i=0;i < groups.get(2).size();i++){
                econClassGroupCount += groups.get(2).get(i).size();
            }

            if(!hasRunECS){
                ecs = thirdClassCount - econClassGroupCount;
                hasRunECS = true;
            }
           
           
           
            /**
             * 16 in first
             * 54 in secound
             * 96 in third
             */
            if(passengerStats.size() == 7){
                String seatNumber = passengerStats.get(6);
                if(Character.isDigit(seatNumber.charAt(0))){
                    seatNumber = seatNumber.substring(1);
                    passengerStats.set(6, seatNumber);
                }
                if(findSeatLocation.isInFirst(seatNumber)){
                    passengerStats.add("F");
                }else if(findSeatLocation.isInSecond(seatNumber)){
                    passengerStats.add("P");
                }else{
                    passengerStats.add("E");
                }              
            }else{ 
                if(fcs > 0){
                    passengerStats.add("F");
                    fcs--;
                }else if(fcs == 0 && epcs > 0){
                    passengerStats.add("P");
                    epcs--;
                }else{
                    passengerStats.add("E");
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
            
            // read each line and add it as the final thing might be easy since i can read if they have a seat
            passengerCSVWritew.fileWriter(fileName, css.toString());
            

       }
        
    }

}


