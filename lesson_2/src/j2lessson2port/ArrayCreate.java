package j2lessson2port;

import java.util.Scanner;

class ArrayCreate {
    Scanner sc=new Scanner(System.in);

    int getInt (String s)throws NotIntegerExeption{
        int m;
        System.out.println(s);
        if(sc.hasNextInt())m=sc.nextInt();
        else throw new NotIntegerExeption(sc.next());
        return m;
    }
    String[][]arrCr(int n){
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
    int arraySum(String[][]str,int n)throws MySizeArrayExceptin,MyArrayDataException{
        if(str.length!=n)throw new MySizeArrayExceptin();
        for (int i = 0; i <n ; i++) {
            if(str[i].length!=n)throw new MySizeArrayExceptin();
        }
        int sum=0;
        int ii=0;
        int jj=0;
        String strstr=null;
        try {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                   ii=i;
                   jj=j;
                   strstr=str[i][j];
                  sum+=Integer.parseInt(str[i][j]);
                }
            }
        }catch (NumberFormatException e){
            throw new MyArrayDataException(ii,jj,strstr);
        }
        return sum;
    }
}
