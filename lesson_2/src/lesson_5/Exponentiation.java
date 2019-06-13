package lesson_5;

import java.util.*;

public class Exponentiation {


    public int involution(int x, int y) {
        if (y == 1) return x;
        return (x * involution(x, y - 1));
    }

    public int readInt(String welcome) {
        Scanner sc = new Scanner(System.in);
        System.out.println(welcome);
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            if (a > 0) return a;
            else return readInt(welcome);
        } else {
            sc.next();
            System.out.println("wrong enter");
            return readInt(welcome);
        }
    }
}
