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

    /*
     * if we are going add a feature to allow passengers to buy specific
     * seats questions need answers
     * 
     * Do familys always sit next to eachother
     *  
     */
    //737
     
     private void test(){
        String[] firstClassLetters = {"A","B","F","E"};
        String[] firstClassNumbers = {"1","2","3","4"};
     }

    /**
     * Change index 1 to an int later
     * @return generates carryon as a string[] = {"size","weight"}
     */
    private String[] generateCarryon(){

        String[] carryon = new String[2];
        int i = randomNumberGen.RandomInt(0, 3);
        switch (i) {
            case 0:
                carryon[0] = "NA";
                carryon[1] = "NAweight";
                break;

            case 1:
                carryon[0] = "small";
                carryon[1] = "smallWeight";
                break;

            case 2:
                carryon[0] = "medium";
                carryon[1] = "mediumWeight";
                break;

            case 3:
                carryon[0] = "large";
                carryon[1] = "largeWeight";
                break;

            default:
                carryon[0] = "NA";
                carryon[1] = "NAweight";
                break;
        }

        return carryon;

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
            String[] names = new String[2];
            String[] carryon = new String[2];
            names = generateFirstLastNameS();
            carryon = generateCarryon();

            passengerStats.add(names[0]);
            passengerStats.add(names[1]);
            passengerStats.add(generateAge());
            passengerStats.add(generateGender());
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
