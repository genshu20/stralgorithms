package lesson_4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>();
        mll.insertFirst("Katia");
        mll.insertFirst("Petia");
        mll.insertFirst("Sania");
        mll.insert(0, "Maria");
        System.out.println(mll);

        ListIterator<String> literator = mll.iterator();
        while (literator.hasNext())
            System.out.println(literator.next() + " " + literator.previousIndex() + " " + literator.nextIndex());
        System.out.println();
        while (literator.hasPrevious())
            System.out.println(literator.previous() + " " + literator.previousIndex() + " " + literator.nextIndex());
        System.out.println();
        literator.remove();
        System.out.println(mll);
        while (literator.hasNext())
            System.out.println(literator.next() + " " + literator.previousIndex() + " " + literator.nextIndex());
        System.out.println();
        while (literator.hasPrevious())
            System.out.println(literator.previous() + " " + literator.previousIndex() + " " + literator.nextIndex());
        System.out.println();
        literator.set("Vasia");
        System.out.println(mll);
        literator.add("Vania");
        System.out.println(mll);
    }
}
