import java.util.ArrayList;

public class SelectedSeat {

            
    
        private String[] firstClassLetters = {"A","B","E","F"};
        private String[] econLetters = {"A","B","C","D","E","F"};

        private ArrayList<String> firstClassSeats = new ArrayList<String>();
        private ArrayList<String> econPlusSeats = new ArrayList<String>();
        private ArrayList<String> econSeats = new ArrayList<String>();

        private ArrayList<String> row1 = new ArrayList<String>();
        private ArrayList<String> row2 = new ArrayList<String>();
        private ArrayList<String> row3 = new ArrayList<String>();
        private ArrayList<String> row4 = new ArrayList<String>();

        private int firstClassLength = 4;
        private int econPlusLength = 9;
        private int econLength = 16;
        

    public SelectedSeat(){
        /**
        * Creates array of first class seats
        */
        // for(int i=0;i<firstClassLetters.length;i++){
        //     for(int j=0; j<firstClassLength;j++){
        //        firstClassSeats.add(firstClassLetters[i].concat(Integer.toString(j + 1)));
        //     }
        // }

        row1.add("A1");
        row1.add("B1");
        row1.add("E1");
        row1.add("F1");

        row2.add("A2");
        row2.add("B2");
        row2.add("E2");
        row2.add("F2");

        row3.add("A3");
        row3.add("B3");
        row3.add("E3");
        row3.add("F3");

        row4.add("A4");
        row4.add("B4");
        row4.add("E4");
        row4.add("F4");
        

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

        // System.out.println(firstClassSeats);
        // System.out.println(econPlusSeats);
        // System.out.println(econSeats);


    }

    public String getRow1(int i) {
        return row1.get(i);
    }

    public void removeIndexRow1(int i){
        row1.remove(i);
    }

    public int getRow1Size(){
        return row1.size();
    }

    public String getRow2(int i) {
        return row2.get(i);
    }

    public void removeIndexRow2(int i){
        row2.remove(i);
    }

    public String getRow3(int i) {
        return row3.get(i);
    }

    public void removeIndexRow3(int i){
        row3.remove(i);
    }

    public String getRow4(int i) {
        return row4.get(i);
    }

    public void removeIndexRow4(int i){
        row4.remove(i);
    }
   
    // //add getters

    // public String getFirstClassSeat(int i){
    //     return firstClassSeats.get(i);
    // }

    // public void removeIndexFirstClass(int i){
    //     firstClassSeats.remove(i);
    // }

    // public String getEconPlusSeat(int i){
    //     return econPlusSeats.get(i);
    // }

    // public void removeIndexEconPlus(int i){
    //     econPlusSeats.remove(i);
    // }   

    // public String getEconSeats(int i){
    //     return econSeats.get(i);
    // }

    // public void removeIndexEcon(int i){
    //     econSeats.remove(i);
    // }

    // /**
    //  * @return Size of the array
    //  */
    // public int getFirstClassLength() {
    //     return firstClassSeats.size();
    // } 
       
}


