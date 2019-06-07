package lesson_3;

public class MyStack<T> {
    private T[]list;
    private int size=0;
    private final int DEFAULT_CAPACITY=10;

    public MyStack(int capacity){
        if(capacity<=0)throw new IllegalArgumentException("bad capacity "+capacity);
        list=(T[])new Object[capacity];
    }
    public MyStack(){
        list=(T[])new Object[DEFAULT_CAPACITY];
    }
    public void push(T t){
        if(isFool()){
            resize(list.length+DEFAULT_CAPACITY);  //увеличивается при необходимости
        }
        list[size]=t;
        size++;
    }
    public T pop(){
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
        T[]tmp=(T[])new Object[newSize];
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
        for (int i = 0; i < size; i++) {
            s += list[i] + " ";
        }
        return s;
    }
}
