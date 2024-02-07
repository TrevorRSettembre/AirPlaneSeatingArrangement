import java.util.ArrayList;

public class RandomPassengerCSV {



    private RandomNumberGen randomNumberGen = new RandomNumberGen();
    private FileManager passengerCSVWritew = new FileManager("AirPlaneSeatingArrangement\\src\\Names");
    private FileManager firstNameReader = new FileManager("AirPlaneSeatingArrangement\\src\\Names\\FirstName.txt");
    private FileManager lastNameReader = new FileManager("AirPlaneSeatingArrangement\\src\\Names\\LastName.txt");

    private ArrayList<String> firstNames = new ArrayList<String>(firstNameReader.readFirstLastNameFile());
    private ArrayList<String> lastNames = new ArrayList<String>(lastNameReader.readFirstLastNameFile());
    
    /**
     * 
     * @return string array {"First Name","Last Name"}
     */
    private String[] generateFirstLastNameS(){
         
        lastNames.size();
        String[] name = new String[2];
        name[0] = firstNames.get(randomNumberGen.RandomInt(0, firstNames.size()-1));
        name[1] = lastNames.get(randomNumberGen.RandomInt(0, lastNames.size()-1));
        return name;

    }

    /**
     * 
     * @return age as an int from min = 1 to max = 100 
     */
    private String generateAge(){
        return Integer.toString(randomNumberGen.RandomInt(1, 100));
    }

    /**
     * 
     * @return gender as a string
     */
    private String generateGender(){
        int gender = randomNumberGen.RandomInt(0, 1);

        if(gender == 0){
            return "female";
        }else{
            return "male";
        }
    }

    /**
     * Creates a scalable arraylist containg random passenger inforaion
     * @param passengerCount
     */
    public void createPassengerCSV(int passengerCount){
        String fileName = "passengerInfo.csv";
        passengerCSVWritew.CreateFile(fileName);
        for(int i=0;i<passengerCount;i++){
            ArrayList<String> passengerStats = new ArrayList<String>();
            String[] names = new String[2];
            names = generateFirstLastNameS();
            passengerStats.add(names[0]);
            passengerStats.add(names[1]);
            passengerStats.add(generateAge());
            passengerStats.add(generateGender());
            //Specific seat?
            //bought multiple seats?
            //Carry on size?
            //carry on weight?

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
            passengerCSVWritew.fileWriterRandom(fileName, css.toString());
            

       }
        
    }

}
