package manual;

import java.util.Arrays;

public class Main {
    public static void main ( String [] args ) {
//        MyArr arr = new MyArr ( 10 );
//        arr . insert ( 5 );
//        arr . insert ( 1 );
//        arr . insert ( 2 );
//        arr . insert ( 5 );
//        arr . insert ( 4 );
//        arr . insert ( 5 );
//        arr . insert ( 6 );
//        arr . insert ( 5 );
//        arr . insert ( 8 );
//        arr . insert ( 9 );
//        System . out . println ( "Выводим массив" );
//        arr . display ();
//        arr . delete ( 1 );
//        System . out . println ( "Выводим новый массив" );
//        arr . display ();
//        System.out.println(Arrays.toString(arr.arr));
        int[]arr=new int[20];
        for (int i = 0; i <20 ; i++) {
            arr[i]=(int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(arr));
        Sorts sorts=new Sorts();
        //sorts.bubble(arr);
        //sorts.insert(arr);
        sorts.select(arr);
        System.out.println(Arrays.toString(arr));
    }
}