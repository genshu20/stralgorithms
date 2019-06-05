package lesson_3;

import java.util.Arrays;

public class MyQueue<T> {
    private T[]list;
    private int size=0;
    private final int DEFAULT_CAPACITY=10;
    private int begin=0;
    private int end=0;

    public MyQueue(int capacity){
        if(capacity<=0)throw new IllegalArgumentException("bad capacity "+capacity);
        list=(T[])new Object[capacity];
    }
    public MyQueue(){
        list=(T[])new Object[DEFAULT_CAPACITY];
    }
    public void insert(T t){
        if(isFool())resize(list.length+DEFAULT_CAPACITY);
        size++;
        list[end]=t;
        end=nextIndex(end);
    }
    public T remove(){
        T value=peek();
        size--;
        list[begin]=null;
        begin=nextIndex(begin);
        return value;
    }
    public T peek(){
        if(isEmpty())throw new StackOverflowError("stack empty ");
        return list[begin];
    }

    public int size() {
        return size;
    }
    public void resize(int newSize) {         //изменение размера очереди
        if(newSize<size)throw new StackOverflowError("queue overflow");
        T[] tmp = (T[]) new Object[newSize];
        for (int i = 0; i <size ; i++) {
            tmp[i]=list[(begin+i)%list.length];
        }
        list=tmp;
        begin=0;
        end=size;
    }

    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFool(){
        return size==list.length;
    }
    private int nextIndex(int index){
        return (index+1)%list.length;

    }
    @Override
    public String toString() {      //по порядку и без пустышек
        String s="";
        for (int i = 0; i <size; i++) {
        s+=list[(begin+i)%list.length]+" ";

        }
        return s;
    }

}
