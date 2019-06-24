package lesson_8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ChainingHashST<Integer,String>chhs=new ChainingHashST<>(3);
        chhs.put(1,"one");
        chhs.put(2,"two");
        chhs.put(3,"three");
        chhs.put(4,"four");
        chhs.put(5,"five");
        chhs.put(6,"five6");
        chhs.put(7,"five7");
        chhs.put(8,"five8");
        chhs.put(9,"five8");
        chhs.put(10,"five8");
        chhs.put(11,"five8");
        chhs.put(12,"five8");
        System.out.println(chhs);
        System.out.println(chhs.delete(12));// почему это работает
        System.out.println(chhs.delete(4));
        System.out.println(chhs.delete(2));
        System.out.println(chhs);
        List <Integer> list=new LinkedList<>();
        for (int i = 0; i <10; i++) {
            list.add(i);
        }
        System.out.println(list);
        for(Integer i:list){
            if(i==5)list.remove(i);   //а это нет
        }
        System.out.println(list);
    }
}
