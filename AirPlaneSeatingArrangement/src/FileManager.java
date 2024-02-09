import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileManager {


    private String filePath;

    public FileManager(String filePath){
        this.filePath = filePath;
    }
    
    

    /**
     * doesent create the file in the right location fix later
     * work on dealing with a file that already exists
     * @param fileName name of file and type
     */
    public void CreateFile(String fileName){
        try {
            //not sure if good to use check layer
            @SuppressWarnings("unused")
            File passengerCSV = new File(filePath, fileName);
           
            } catch (Exception e) {
           System.out.println("File create error");
        }
       
    }

    /**
     * TODO work on deleting file automaticlly need
     * to manually delete file before running or it appends
     * @param fileName name of csv
     * @param passengerStats comma seperated string of passenger details
     */
    public void fileWriter(String fileName, String passengerStats){
        try {
            FileWriter fileWriter = new FileWriter(fileName,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            

            bufferedWriter.write(passengerStats);
            bufferedWriter.newLine();
            bufferedWriter.close();

            } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    /**
     * 
     * @return arralylist of name files
     */
    public ArrayList<String> readFirstLastNameFile(){
        try {
            ArrayList<String> nameList = new ArrayList<String>();
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            while((line = bufferedReader.readLine()) != null){
                nameList.add(line);
            }
            bufferedReader.close();
            return nameList;
        } catch (Exception e) {
            System.out.println("File read error");
            return null;
        }
        
    }
}   
   