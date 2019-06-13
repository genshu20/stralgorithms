package lesson_5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Exponentiation exp=new Exponentiation();
        int x=exp.readInt("enter x");
        int y=exp.readInt("enter y");
        System.out.println("x^y= "+exp.involution(x,y));

        Knapsack sack=new Knapsack(exp.readInt("enter number of items"));
        sack.arrays();
        System.out.println(sack.maxCost(sack.n-1,sack.maxW));
    }
}
