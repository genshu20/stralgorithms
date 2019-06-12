package lesson_4;

import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedList<T>implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public MyLinkedList() {
        first = null;
        last = null;
    }

    @Override
    public ListIterator<T> iterator() {
        return new ListIterT();
    }


    private class Iter implements Iterator<MyLinkedList.Node<T>>{ //итератор с лекции
        Node<T> current=new Node<T>(null,first);
        @Override
        public boolean hasNext() {
            return current.getNext()!=null;
        }
        @Override
        public Node<T> next() {
            current=current.getNext();
            return current;
        }
    }

    private class IterT implements Iterator<T>{                   //итератор по T
        Node<T> current=new Node<T>(null,first);
        int index=-1;
        @Override
        public boolean hasNext() {
            return current.getNext()!=null;
        }
        @Override
        public T next() {
            current=current.getNext();
            index++;
            return current.getValue();
        }
    }

    private class ListIterT extends IterT implements ListIterator<T>{ // ListIterator
        @Override
        public boolean hasPrevious() {
            return current.getPrevious()!=null;
        }

        @Override
        public T previous() {
            current=current.getPrevious();
            index--;
            return current.getValue();
        }

        @Override
        public int nextIndex() {
            return index+1;
        }

        @Override
        public int previousIndex() {
            return index-1;
        }

        @Override
        public void remove() {
            if(index==0){
                deleteFirst();
                current=first;
                size--;
            }
            else if(index==size-1){
                deleteLast();
                current=last;
                size--;
            }else{
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                current=current.getNext();
                size--;
            }
        }
        @Override
        public void set(T t) {
            current.setValue(t);
        }

        @Override
        public void add(T t) {
            insert(index+1,t);
        }
    }

    public void insertFirst(T t) {
        Node<T> newNode = new Node<>(t);
        newNode.setNext(first);
        if (isEmpty()) last = newNode;
        else first.setPrevious(newNode);
        first = newNode;
        size++;
    }

        public void insertLast(T t) {
            Node<T> newNode = new Node<>(t);
            newNode.setPrevious(last);
            if (isEmpty()) first = newNode;
            else last.setNext(newNode);
            last=newNode;
            size++;
    }

    public T deleteFirst() {
        if (isEmpty()) return null;
        Node<T> oldFirst = first;
        first = first.getNext();
        if(isEmpty())last=null;
        else first.setPrevious(null);
        size--;
        return oldFirst.getValue();

    }

    public T deleteLast() {
        if (isEmpty()) return null;
        Node<T> oldLast = last;
        last = last.getPrevious();
        if(last==null)first=null;   //зеркально к deleteFirst(), кроме этой строчки
        else last.setNext(null);
        size--;
        return oldLast.getValue();

    }

    public int indexOf(T t) {
        int ind = 0;
        Node<T> current = first;
        while (current != null) {
            if (current.getValue().equals(t)) return ind;
            current = current.getNext();
            ind++;
        }
        return -1;
    }

    public boolean contains(T t) {
        return indexOf(t) > -1;
    }
    public void insert(int index,T t){
        if(index<=0)insertFirst(t);
        else if(index>=size)insertLast(t);
        else {
            Node<T>current=first;
            int ind=0;
            while (ind<index-1){
                current=current.getNext();
                ind++;
            }
            Node newNode=new Node(t);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            newNode.getNext().setPrevious(newNode);
            newNode.setPrevious(current);
            size++;
       }
    }
    public boolean delete(T t){
        if(indexOf(t)<0)return false;    //через indexOf()
        if(indexOf(t)==0){
            deleteFirst();
            return true;
        }
        if(indexOf(t)==size-1){
            deleteLast();
            return true;
        }
         Node<T>current=first;
         int i=0;
         while (i<indexOf(t)-1){
             current=current.getNext();
             i++;
         }
         current.setNext(current.getNext().getNext());
         current.getNext().setPrevious(current);
         size--;
        return true;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public T getFirst() {
        if (isEmpty()) return null;
        return first.getValue();
    }
    public T getLast() {
        if (isEmpty()) return null;
        return last.getValue();
    }

    @Override
    public String toString() {
        Node<T> current = first;
        String s = "";
        while (current != null) {
            s += current.getValue() + " ";
            current = current.getNext();
        }
        return s;
    }

    static class Node<T> {    /*????? почему, если убрать static, будет ошибка
     Error:(22, 61) java: improperly formed type, type arguments given on a raw type*/
        private T value;
        private Node next;
        private Node previous;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
