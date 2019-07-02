package j2Lesson5;

import java.util.Arrays;

public class Main2 {                               //проверка на малых числах
    static float[]arr;
    static float[] runArray(float[] fl,int m){
        for (int i = 0; i <fl.length ; i++) {
            fl[i]=(float)(fl[i]*Math.sin(0.2f+(i+fl.length*m)/5)*Math.cos(0.2f+(i+fl.length*m)/5)*Math.cos(0.4f+(i+fl.length*m)/2));
        }return fl;
    }
    static float[] runArrayTwoThread(float[] fl){
        float[]arr_1=new float[arr.length/2];
        float[]arr_2=new float[arr.length/2];
        System.arraycopy(fl,0,arr_1,0,arr_1.length);
        System.arraycopy(fl,arr.length/2,arr_2,0,arr_2.length);
        Thread t1= new Thread(()->runArray(arr_1,0));
        Thread t2= new Thread(()->runArray(arr_2,1));
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){e.printStackTrace();}
        System.arraycopy(arr_1,0,fl,0,arr_1.length);
        System.arraycopy(arr_2,0,fl,arr.length/2,arr_2.length);
        return fl;
    }
    static float[] runArrayMultyThread(float[] fl,int n){
        float[][]arrArr=new float[n][fl.length/n];
        for (int i = 0; i <n ; i++) {
            System.arraycopy(fl,i*(fl.length/n),arrArr[i],0,fl.length/n);
        }
        Thread[]threads=new Thread[n];
        for (int i = 0; i <n ; i++) {
            int finalI = i;
            threads[i]=new Thread(()->runArray(arrArr[finalI],finalI));
        }
        for (int i = 0; i <n ; i++) {
            threads[i].start();
        }
        for (int i = 0; i <n ; i++) {
            try{
                threads[i].join();
            }catch (InterruptedException e){e.printStackTrace();}
        }
        for (int i = 0; i <n ; i++) {
            System.arraycopy(arrArr[i],0,fl,i*(fl.length/n),fl.length/n);
        }return fl;
    }

    public static void main(String[] args) {
        arr=new float[20];
        int n=5;//20%n==0
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }
        float[]arrCopy=(float[])arr.clone();
        float[]arrCopyElse=(float[])arr.clone();
        long a=System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        runArray(arr,0);
        System.out.println(Arrays.toString(arr));
        long b=System.currentTimeMillis();
        System.out.println(Arrays.toString(arrCopy));
        runArrayTwoThread(arrCopy);
        System.out.println(Arrays.toString(arrCopy));
        long c=System.currentTimeMillis();
        System.out.println(Arrays.toString(arrCopyElse));
        runArrayMultyThread(arrCopyElse,n);
        System.out.println(Arrays.toString(arrCopyElse));
        long d=System.currentTimeMillis();
        System.out.println("in one thread: "+(b-a)+" in two thread: "+(c-b)+" in "+n+" thread: "+(d-c));
    }
}