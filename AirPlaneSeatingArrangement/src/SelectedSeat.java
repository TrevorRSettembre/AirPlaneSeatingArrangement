import java.util.ArrayList;

public class SelectedSeat {

            
        /*
         * Work on puting things in files
         */
        private String[] firstClassLetters = {"A","B","E","F"};
        private String[] econLetters = {"A","B","C","D","E","F"};

        private ArrayList<String> firstClassSeats = new ArrayList<String>();
        private ArrayList<String> econPlusSeats = new ArrayList<String>();
        private ArrayList<String> econSeats = new ArrayList<String>();

        private int firstClassLength = 4;
        private int econPlusLength = 9;
        private int econLength = 16;
        

    public SelectedSeat(){
        /**
        * Creates array of first class seats
        */
        for(int i=0;i<firstClassLetters.length;i++){
            for(int j=0; j<firstClassLength;j++){
               firstClassSeats.add(firstClassLetters[i].concat(Integer.toString(j + 1)));
            }
        }

        /**
        * creats array of econPlus seats
        */
        for(int i=0;i<econLetters.length;i++){
            for(int j=0; j<econPlusLength+2;j++){
               if((j+7) != 9){
                    if((j+7) != 13){
                       if((j+7) >= 16){
                        econPlusSeats.add(econLetters[i].concat(Integer.toString(j + 11)));
                       }else{
                        econPlusSeats.add(econLetters[i].concat(Integer.toString(j + 7)));
                       }
                    }
                }
            }
        }

        /**
        * creates array of econ seats
        */
        for(int i=0;i<econLetters.length;i++){
            for(int j=0;j<econLength+1;j++){
                if((j+22) != 33){
                    econSeats.add(econLetters[i].concat(Integer.toString(j + 22)));
                }
            }
        }
    }
   

    public void removeIndexFirstClass(int i){
        firstClassSeats.remove(i);
    }

    public void removeIndexEconPlus(int i){
        econPlusSeats.remove(i);
    }   

    public void removeIndexEcon(int i){
        econSeats.remove(i);
    }

    public ArrayList<String> getFirstClassSeats() {
        return firstClassSeats;
    }

    public int getEconPlusLength() {
        return econPlusLength;
    }

    public ArrayList<String> getEconSeats() {
        return econSeats;
    }

    
       
}


