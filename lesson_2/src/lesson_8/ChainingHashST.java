package lesson_8;

import java.util.*;

public class ChainingHashST<Key,Value> {
    private int capacity;
    private int size=0;
    private LinkedList<Node>[]st;

    public ChainingHashST(int capacity) {
        this.capacity = capacity;
        st=new LinkedList[capacity];
        for (int i = 0; i <st.length ; i++) {
            st[i]=new LinkedList<Node>();
        }
    }

    private class Node{
        private Key key;
        private Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean contains(Key key) {
        return get(key)!=null;
    }
    private int hash(Key key){
        return (key.hashCode()&0x7fffffff)%capacity;
    }
    public void put(Key key,Value value){
        if(key==null)throw new IllegalArgumentException("null key");
        int i=hash(key);
        for(Node node:st[i]){
            if(key.equals(node.key)){
                node.value=value;    //изменение элемента в цикле for each
                return;
            }
        }
        st[i].addLast(new Node(key,value));
        size++;
    }
    public Value get(Key key){
        if(key==null)throw new IllegalArgumentException("null key");
        int i=hash(key);
        for(Node node:st[i]){
            if(node.key.equals(key))return node.value;
        }
        return null;
    }
    public boolean delete(Key key){
        if(key==null)throw new IllegalArgumentException("null key");
        int i=hash(key);
        for(Node node:st[i]){
            if(node.key.equals(key)){
                st[i].remove(node);       //удаление элемента в цикле for each
                return true;
            }
        }return false;
    }

    @Override
    public String toString() {
        String s="";
        for (int i = 0; i <capacity ; i++) {
            for(Node node:st[i]){
                s+=node.key+" ";
            }
            s+="\n";
        }

        return "ChainingHashST{\n" +
                s+
                '}';
    }
}
