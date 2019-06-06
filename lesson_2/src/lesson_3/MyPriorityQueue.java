package lesson_3;

public class MyPriorityQueue<T extends Comparable> {
    private T[]list;
    private int size=0;
    private final int DEFAULT_CAPACITY=10;

    public MyPriorityQueue(int capacity){
        if(capacity<=0)throw new IllegalArgumentException("bad capacity "+capacity);
        list=(T[])new Comparable[capacity];
    }
    public MyPriorityQueue(){
        list=(T[])new Comparable[DEFAULT_CAPACITY];
    }
    public void insert(T t){
        if(isFool()){
            resize(list.length+DEFAULT_CAPACITY);  //увеличивается при необходимости
        }
        list[size]=t;
        size++;
        int i=size-1;
        while (i>0&&list[i].compareTo(list[i-1])<0){
            swap(i,i-1);
            i--;
        }
    }
    public T remove(){
        T tmp=peek();
        size--;
        list[size]=null;
        return tmp;
    }
    public T peek(){
        if(isEmpty())throw new StackOverflowError("stack empty ");
        return list[size-1];
    }

    public int size() {
        return size;
    }
    public void resize(int newSize){   //изменение размера стека
        T[]tmp=(T[])new Comparable[newSize];
        System.arraycopy(list,0,tmp,0,size);  //заменил list.length на size
        list=tmp;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFool(){
        return size==list.length;
    }
    public String toString() {
        String s = "";
        for (int i = 0; i < list.length; i++) {
            s += list[i] + " ";
        }
        return s;
    }
    private void swap(int index1, int index2) {
        T tmp = list[index1];
        list[index1] = list[index2];
        list[index2] = tmp;
    }

}