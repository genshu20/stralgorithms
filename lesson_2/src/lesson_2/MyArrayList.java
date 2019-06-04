package lesson_2;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T extends Comparable> {
    private T[] list;
    private int size = 0;
    private int capacity;
    private static final int DEF_CAP = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity<=0");
        else {
            list = (T[]) new Comparable[capacity];
            this.capacity = capacity;
        }
    }

    public MyArrayList() {
        list = (T[]) new Comparable[DEF_CAP];
        capacity = DEF_CAP;
    }

    public MyArrayList(MyArrayList x) {    // конструктор для копирования
        list = (T[]) x.list.clone();
        size = x.size;
        capacity = x.capacity;
    }

    private void increase() {              // метод для увеличения capacity
        T[] list1 = (T[]) new Comparable[capacity + DEF_CAP];
        System.arraycopy(list, 0, list1, 0, capacity);
        list = list1;
        capacity += DEF_CAP;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += list[i] + " ";
        }
        return s;
    }

    public void add(T t) {
        list[size] = t;
        size++;
        if (size == capacity) increase();
    }

    public void add(int index, T t) {
        if (index > size) index = size;
        if (index < 0) index = 0;
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = t;
        size++;
        if (size == capacity) increase();
    }

    public boolean delete(T t) {
        int i = 0;
        while (i < size && !list[i].equals(t)) {
            i++;
        }
        if (i == size) return false;
        else {
            for (int j = i; j < size - 1; j++) {
                list[j] = list[j + 1];
            }
            list[size - 1] = null;
            size--;
            return true;
        }
    }

    public T get(int index) {
        return list[index];
    }

    public void set(int index, T t) {
        list[index] = t;
    }

    public int size() {
        return size;
    }

    public boolean find(T t) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(t)) return true;
        }
        return false;
    }

    private boolean less(T t1, T t2) {
        return t1.compareTo(t2) < 0;
    }

    private void swap(int index1, int index2) {
        T tmp = list[index1];
        list[index1] = list[index2];
        list[index2] = tmp;
    }

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[iMin])) iMin = j;
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        T key;
        for (int i = 0; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void boobleSort() {
        boolean b = false;
        while (!b) {
            b = true;
            for (int i = size - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (less(list[j + 1], list[j])) {
                        b = false;
                        swap(j, j + 1);
                    }
                }
            }
        }
    }
}