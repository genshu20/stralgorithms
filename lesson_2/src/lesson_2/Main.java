package lesson_2;

public class Main {
    public static void main(String[] args) {
        System.out.println("test");
        MyArrayList<Integer>malSs=new MyArrayList<>();
        malSs.add(100);
        malSs.add(3);
        malSs.add(2);
        malSs.add(35);
        malSs.add(44);
        malSs.add(1);
        malSs.add(0);
        malSs.add(370);
        malSs.add(70);
        malSs.add(4);
        malSs.add(8);
        malSs.add(7);
        System.out.println(malSs);
        MyArrayList malIs=new MyArrayList(malSs);
        MyArrayList malBs=new MyArrayList(malSs);
        malSs.selectionSort();
        System.out.println(malSs);
        System.out.println(malIs);
        malIs.insertionSort();
        System.out.println(malIs);
        System.out.println(malBs);
        malBs.boobleSort();
        System.out.println(malBs);

        System.out.println("big arrays");
        MyArrayList<Integer> bigSs = new MyArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bigSs.add(i, (int) (Math.random() * 1000));
        }
        MyArrayList bigIs = new MyArrayList(bigSs);
        MyArrayList bigBs = new MyArrayList(bigSs);
        long timeBigin;
        long timeEnd;

        timeBigin = System.nanoTime();
        bigBs.boobleSort();
        timeEnd = System.nanoTime();
        System.out.println("time booblesort: "+(timeEnd-timeBigin));

        timeBigin = System.nanoTime();
        bigSs.selectionSort();
        timeEnd = System.nanoTime();
        System.out.println("time selectionsort: "+(timeEnd-timeBigin));

        timeBigin = System.nanoTime();
        bigIs.insertionSort();
        timeEnd = System.nanoTime();
        System.out.println("time insertionsort: "+(timeEnd-timeBigin));


    }
}
