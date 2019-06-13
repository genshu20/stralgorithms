package lesson_5;

import java.util.*;

public class Knapsack {
    int maxW=20;
    int n;
    int[]weights;
    int[]costs;
    boolean[]swich;
    public Knapsack(int n){
        this.n=n;
    }
    void arrays(){
        weights=getArray(n);
        costs=getArray(n);

        System.out.println("weights: "+Arrays.toString(weights));
        System.out.println("costs  : "+Arrays.toString(costs));
    }
    int maxCost(int i,int weight){
        if(i<0)return 0;
        if(weights[i]>weight){
            return maxCost(i-1,weight);
        }
        else{
            return Math.max(maxCost(i-1,weight),maxCost(i-1,weight-weights[i])+costs[i]);
        }
    }

    int[] getArray(int n){
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=(int)(Math.random()*9)+1;
        }
        return arr;
    }
}
