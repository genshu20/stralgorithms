package j2lessson2port;

import java.util.Scanner;

public class Main {

    private static ArrayCreate arcr=new ArrayCreate();
    private static String[][] str;

    public static void main(String[] args) {
        try {
            str = arcr.arrCr(arcr.getInt("enter size"));
        }catch (NotIntegerExeption e){
           e.printStackTrace();
           return;
        }
        int n;
        try {
            n = arcr.getInt("enter check size");
        }catch (NotIntegerExeption e){
            e.printStackTrace();
            return;
        }
        try {
            System.out.println("sum= " + arcr.arraySum(str, n));
        }catch (MyArrayDataException e){
            e.printStackTrace();
        }
        catch (MySizeArrayExceptin ex){
            ex.printStackTrace();
        }
    }
}
