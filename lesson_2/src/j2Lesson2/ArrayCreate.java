package j2Lesson2;

import java.util.Scanner;

public class ArrayCreate {
    public String[][]arrCr(){
        int n=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter dimension");
        if(sc.hasNextInt())n=sc.nextInt();
        else throw new NotIntegerExeption(sc.next());
        String[][]arrStr=new String[n][n];
        System.out.println("enter "+n*n+" numbers");
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.println("enter number");
                arrStr[i][j]=sc.next();
            }
        }
        return arrStr;
    }
}
