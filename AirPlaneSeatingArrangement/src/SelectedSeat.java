import java.util.ArrayList;

public class SelectedSeat {

            
    
        // private String[] firstClassLetters = {"A","B","E","F"};
        // private String[] econLetters = {"A","B","C","D","E","F"};

        // private ArrayList<String> firstClassSeats = new ArrayList<String>();
        // private ArrayList<String> econPlusSeats = new ArrayList<String>();
        // private ArrayList<String> econSeats = new ArrayList<String>();

        private ArrayList<String> frow1 = new ArrayList<String>();
        private ArrayList<String> frow2 = new ArrayList<String>();
        private ArrayList<String> frow3 = new ArrayList<String>();
        private ArrayList<String> frow4 = new ArrayList<String>();

        private ArrayList<String> eprow7 = new ArrayList<String>();
        private ArrayList<String> eprow8 = new ArrayList<String>();
        private ArrayList<String> eprow10 = new ArrayList<String>();
        private ArrayList<String> eprow11 = new ArrayList<String>();
        private ArrayList<String> eprow12 = new ArrayList<String>();
        private ArrayList<String> eprow14 = new ArrayList<String>();
        private ArrayList<String> eprow15 = new ArrayList<String>();
        private ArrayList<String> eprow20 = new ArrayList<String>();
        private ArrayList<String> eprow21 = new ArrayList<String>();

        private ArrayList<String> erow22 = new ArrayList<String>();
        private ArrayList<String> erow23 = new ArrayList<String>();
        private ArrayList<String> erow24 = new ArrayList<String>();
        private ArrayList<String> erow25 = new ArrayList<String>();
        private ArrayList<String> erow26 = new ArrayList<String>();
        private ArrayList<String> erow27 = new ArrayList<String>();
        private ArrayList<String> erow28 = new ArrayList<String>();
        private ArrayList<String> erow29 = new ArrayList<String>();
        private ArrayList<String> erow30 = new ArrayList<String>();
        private ArrayList<String> erow31 = new ArrayList<String>();
        private ArrayList<String> erow32 = new ArrayList<String>();
        private ArrayList<String> erow34 = new ArrayList<String>();
        private ArrayList<String> erow35 = new ArrayList<String>();
        private ArrayList<String> erow36 = new ArrayList<String>();
        private ArrayList<String> erow37 = new ArrayList<String>();
        private ArrayList<String> erow38 = new ArrayList<String>();
    
        private int firstClassLength = 4;
        private int econPlusLength = 9;
        private int econLength = 16;
        
        private ArrayList<ArrayList<String>> firstClass = new ArrayList<ArrayList<String>>();
        private ArrayList<ArrayList<String>> secondClass = new ArrayList<ArrayList<String>>();
        private ArrayList<ArrayList<String>> thirdClass = new ArrayList<ArrayList<String>>();


    public SelectedSeat(){
        //First class
        frow1.add("A1");
        frow1.add("B1");
        frow1.add("E1");
        frow1.add("F1");

        frow2.add("A2");
        frow2.add("B2");
        frow2.add("E2");
        frow2.add("F2");

        frow3.add("A3");
        frow3.add("B3");
        frow3.add("E3");
        frow3.add("F3");

        frow4.add("A4");
        frow4.add("B4");
        frow4.add("E4");
        frow4.add("F4");

        firstClass.add(frow1);
        firstClass.add(frow2);
        firstClass.add(frow3);
        firstClass.add(frow4);

        //Econ plus
        eprow7.add("A7");
        eprow7.add("B7");
        eprow7.add("C7");
        eprow7.add("D7");
        eprow7.add("E7");
        eprow7.add("F7");

        eprow8.add("A8");
        eprow8.add("B8");
        eprow8.add("C8");
        eprow8.add("D8");
        eprow8.add("E8");
        eprow8.add("F8");
        
        eprow10.add("A0");
        eprow10.add("B10");
        eprow10.add("C10");
        eprow10.add("D10");
        eprow10.add("E10");
        eprow10.add("F10");

        eprow11.add("A11");
        eprow11.add("B11");
        eprow11.add("C11");
        eprow11.add("D11");
        eprow11.add("E11");
        eprow11.add("F11");

        eprow12.add("A12");
        eprow12.add("B12");
        eprow12.add("C12");
        eprow12.add("D12");
        eprow12.add("E12");
        eprow12.add("F12");

        eprow14.add("A14");
        eprow14.add("B14");
        eprow14.add("C14");
        eprow14.add("D14");
        eprow14.add("E14");
        eprow14.add("F14");

        eprow15.add("A15");
        eprow15.add("B15");
        eprow15.add("C15");
        eprow15.add("D15");
        eprow15.add("E15");
        eprow15.add("F15");

        eprow20.add("A20");
        eprow20.add("B20");
        eprow20.add("C20");
        eprow20.add("D20");
        eprow20.add("E20");
        eprow20.add("F20");

        eprow21.add("A21");
        eprow21.add("B21");
        eprow21.add("C21");
        eprow21.add("D21");
        eprow21.add("E21");
        eprow21.add("F21");

        secondClass.add(eprow7);
        secondClass.add(eprow8);
        secondClass.add(eprow10);
        secondClass.add(eprow11);
        secondClass.add(eprow12);
        secondClass.add(eprow14);
        secondClass.add(eprow15);
        secondClass.add(eprow20);
        secondClass.add(eprow21);

        //Econ rows
        erow22.add("A22");
        erow22.add("B22");
        erow22.add("C22");
        erow22.add("D22");
        erow22.add("E22");
        erow22.add("F22");

        erow23.add("A23");
        erow23.add("B23");
        erow23.add("C23");
        erow23.add("D23");
        erow23.add("E23");
        erow23.add("F23");

        erow24.add("A24");
        erow24.add("B24");
        erow24.add("C24");
        erow24.add("D24");
        erow24.add("E24");
        erow24.add("F24");

        erow25.add("A25");
        erow25.add("B25");
        erow25.add("C25");
        erow25.add("D25");
        erow25.add("E25");
        erow25.add("F25");

        erow26.add("A26");
        erow26.add("B26");
        erow26.add("C26");
        erow26.add("D26");
        erow26.add("E26");
        erow26.add("F26");

        erow27.add("A27");
        erow27.add("B27");
        erow27.add("C27");
        erow27.add("D27");
        erow27.add("E27");
        erow27.add("F27");

        erow28.add("A28");
        erow28.add("B28");
        erow28.add("C28");
        erow28.add("D28");
        erow28.add("E28");
        erow28.add("F28");

        erow29.add("A29");
        erow29.add("B29");
        erow29.add("C29");
        erow29.add("D29");
        erow29.add("E29");
        erow29.add("F29");

        erow30.add("A30");
        erow30.add("B30");
        erow30.add("C30");
        erow30.add("D30");
        erow30.add("E30");
        erow30.add("F30");

        erow31.add("A31");
        erow31.add("B31");
        erow31.add("C31");
        erow31.add("D31");
        erow31.add("E31");
        erow31.add("F31");

        erow32.add("A32");
        erow32.add("B32");
        erow32.add("C32");
        erow32.add("D32");
        erow32.add("E32");
        erow32.add("F32");

        erow34.add("A34");
        erow34.add("B34");
        erow34.add("C34");
        erow34.add("D34");
        erow34.add("E34");
        erow34.add("F34");

        erow35.add("A35");
        erow35.add("B35");
        erow35.add("C35");
        erow35.add("D35");
        erow35.add("E35");
        erow35.add("F35");

        erow36.add("A36");
        erow36.add("B36");
        erow36.add("C36");
        erow36.add("D36");
        erow36.add("E36");
        erow36.add("F36");

        erow37.add("A37");
        erow37.add("B37");
        erow37.add("C37");
        erow37.add("D37");
        erow37.add("E37");
        erow37.add("F37");

        erow38.add("A38");
        erow38.add("B38");
        erow38.add("C38");
        erow38.add("D38");
        erow38.add("E38");
        erow38.add("F38");

        thirdClass.add(erow22);
        thirdClass.add(erow23);
        thirdClass.add(erow24);
        thirdClass.add(erow25);
        thirdClass.add(erow26);
        thirdClass.add(erow27);
        thirdClass.add(erow28);
        thirdClass.add(erow29);
        thirdClass.add(erow30);
        thirdClass.add(erow31);
        thirdClass.add(erow32);
        thirdClass.add(erow34);
        thirdClass.add(erow35);
        thirdClass.add(erow36);
        thirdClass.add(erow37);
        thirdClass.add(erow38);
        

        

        // /**
        // * creats array of econPlus seats
        // */
        // for(int i=0;i<econLetters.length;i++){
        //     for(int j=0; j<econPlusLength+2;j++){
        //        if((j+7) != 9){
        //             if((j+7) != 13){
        //                if((j+7) >= 16){
        //                 econPlusSeats.add(econLetters[i].concat(Integer.toString(j + 11)));
        //                }else{
        //                 econPlusSeats.add(econLetters[i].concat(Integer.toString(j + 7)));
        //                }
        //             }
        //         }
        //     }
        // }

        // /**
        // * creates array of econ seats
        // */
        // for(int i=0;i<econLetters.length;i++){
        //     for(int j=0;j<econLength+1;j++){
        //         if((j+22) != 33){
        //             econSeats.add(econLetters[i].concat(Integer.toString(j + 22)));
        //         }
        //     }
        // }



    }


    
    public boolean isInFirst(String check){      
        for(ArrayList<String> row : firstClass){
            if(row.contains(check)){
                return true;
            }
        }
        return false;
    }

    public boolean isInSecond(String check){      
        for(ArrayList<String> row : secondClass){
            if(row.contains(check)){
                return true;
            }
        }
        return false;
    }

    // public boolean isInThrid(String check){      
    //     for(ArrayList<String> row : firstClass){
    //         if(row.contains(check)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }






    /**
     * 1, 2, 3, 4
     * @param row
     * @param i
     * @return
     */
    public String getFirstClassRow(int row, int i){

        String output = "";
        switch (row) {
            case 1:
                output = frow1.get(i);
                break;
            case 2:
                output = frow2.get(i);
                break;
            case 3:
                output = frow3.get(i);
                break;
            case 4:
                output = frow4.get(i);
                break;
            default:
                break;
        }
        return output;
    }

    public void removeFirstClassRow(int row, int i){

        switch (row) {
            case 1:
                frow1.remove(i);
                break;
            case 2:
                frow2.remove(i);
                break;
            case 3:
                frow3.remove(i);
                break;
            case 4:
                frow4.remove(i);
                break;
            default:
                break;
        }
    }

    /**
     * 7,8,10,11,12,14,20,21
     * @param row
     * @param i
     * @return
     */
    public String getEconPlusClassRow(int row, int i){

        String output = "";
        switch (row) {
            case 7:
                output = eprow7.get(i);
                break;
            case 8:
                output = eprow8.get(i);
                break;
            case 10:
                output = eprow10.get(i);
                break;
            case 11:
                output = eprow11.get(i);
                break;
            case 12:
                output = eprow12.get(i);
                break;
            case 14:
                output = eprow14.get(i);
                break;
            case 15:
                output = eprow15.get(i);
                break;
            case 20:
                output = eprow20.get(i);
                break;
            case 21:
                output = eprow21.get(i);
                break;
            default:
                break;
        }
        return output;
    }

    /**
     * 7,8,10,11,12,14,15,20,21
     * @param row
     * @param i
     */
    public void removeEconPLusClassRow(int row, int i){

        switch (row) {
            case 7:
                eprow7.remove(i);
                break;
            case 8:
                eprow8.remove(i);
                break;
            case 10:
                eprow10.remove(i);
                break;
            case 11:
                eprow11.remove(i);
                break;
            case 12:
                eprow12.remove(i);
                break;
            case 14:
                eprow14.remove(i);
                break;
            case 15:
                eprow15.remove(i);
                break;
            case 20:
                eprow20.remove(i);
                break;
            case 21:
                eprow21.remove(i);
                break;
            default:
                break;
        }
    }

    /**
     * 22,23,24,25,26,27,28,29,30,31,32,34,35,36,37,38
     * @param row
     * @param i
     * @return
     */
    public String getEconClassRow(int row, int i){

        String output = "";
        switch (row) {
            case 22:
                output = erow22.get(i);
                break;
            case 23:
                output = erow23.get(i);
                break;
            case 24:
                output = erow24.get(i);
                break;
            case 25:
                output = erow25.get(i);
                break;
            case 26:
                output = erow26.get(i);
                break;
            case 27:
                output = erow27.get(i);
                break;
            case 28:
                output = erow28.get(i);
                break;
            case 29:
                output = erow29.get(i);
                break;
            case 30:
                output = erow30.get(i);
                break;
            case 31:
                output = erow31.get(i);
                break;
            case 32:
                output = erow32.get(i);
                break;
            case 34:
                output = erow34.get(i);
                break;
            case 35:
                output = erow35.get(i);
                break;
            case 36:
                output = erow36.get(i);
                break;
            case 37:
                output = erow37.get(i);
                break;
            case 38:
                output = erow38.get(i);
                break;
            default:
                break;
        }
        return output;
    }   
    
    /**
     *  22,23,24,25,26,27,28,29,30,31,32,34,35,36,37,38
     * @param row
     * @param i
     */
    public void removeEconClassRow(int row, int i){

        switch (row) {
            case 22:
                erow22.remove(i);
                break;
            case 23:
                erow23.remove(i);
                break;
            case 24:
                erow24.remove(i);
                break;
            case 25:
                erow25.remove(i);
                break;
            case 26:
                erow26.remove(i);
                break;
            case 27:
                erow27.remove(i);
                break;
            case 28:
                erow28.remove(i);
                break;
            case 29:
                erow29.remove(i);
                break;
            case 30:
                erow30.remove(i);
                break;
            case 31:
                erow31.remove(i);
                break;
            case 32:
                erow32.remove(i);
                break;
            case 34:
                erow34.remove(i);
                break;
            case 35:
                erow35.remove(i);
                break;
            case 36:
                erow36.remove(i);
                break;
            case 37:
                erow37.remove(i);
                break;
            case 38:
                erow38.remove(i);
                break;
            default:
                break;
        }
    }
}


