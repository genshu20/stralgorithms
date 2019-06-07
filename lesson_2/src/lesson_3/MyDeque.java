package lesson_3;

import java.util.Arrays;

public class MyDeque<T> {
    private T[]list;
    private int size=0;
    private final int DEFAULT_CAPACITY=10;
    private int beginLeft=0;
    private int endRight=0;

    public MyDeque(int capacity){
        if(capacity<=0)throw new IllegalArgumentException("bad capacity "+capacity);
        list=(T[])new Object[capacity];
    }
    public MyDeque(){
        list=(T[])new Object[DEFAULT_CAPACITY];
    }
    public void insertRight(T t){
        if(isFool())resize(list.length+DEFAULT_CAPACITY);
        size++;
        list[endRight]=t;
        endRight=nextIndex(endRight);
    }
    public void insertLeft(T t){
        if(isFool())resize(list.length+DEFAULT_CAPACITY);
        size++;
        list[(beginLeft-1+list.length)%list.length]=t;
        beginLeft=beforeIndex(beginLeft);
    }
    public T removeLeft() {
        T value = peekLeft();
        size--;
        list[beginLeft] = null;
        beginLeft = nextIndex(beginLeft);
        return value;
    }
        public T removeRight(){
        T value=peekRight();
        size--;
        list[(endRight-1+list.length)%list.length]=null;
        endRight=beforeIndex(endRight);
        return value;
    }
    public T peekLeft(){
        if(isEmpty())throw new StackOverflowError("stack empty ");
        return list[beginLeft];
    }
    public T peekRight(){
        if(isEmpty())throw new StackOverflowError("stack empty ");
        return list[(endRight-1+list.length)%list.length];
    }

    public int size() {
        return size;
    }
    public void resize(int newSize) {              //изменение размера deque
        if(newSize<size)throw new StackOverflowError("queue overflow");
        T[] tmp = (T[]) new Object[newSize];
        for (int i = 0; i <size ; i++) {
            tmp[i]=list[(beginLeft+i)%list.length];
        }
        list=tmp;
        beginLeft=0;
        endRight=size;
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
    private int beforeIndex(int index){
        return (index-1+list.length)%list.length;
    }
    @Override
    public String toString() {
        String s="";
        for (int i = 0; i <list.length; i++) {
            s += list[i] + " ";
        }
        return s;
    }

}