package lesson_4;

public class MyOneLinkedList<T> {
    private Node<T> first;
    private int size = 0;

    public MyOneLinkedList() {
        this.first = null;
    }

    public void insertFirst(T t) {
        Node<T> newNode = new Node<>(t);
        newNode.setNext(first);
        first = newNode;
        size++;
    }

    public T deleteFirst() {
        if (isEmpty()) return null;
        Node<T> oldFirst = first;
        first = first.getNext();
        size--;
        return oldFirst.getValue();
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
        else {
            if(index>size)index=size;
            Node<T>current=first;
            int ind=0;
            while (ind<index-1){
                current=current.getNext();
                ind++;
            }
            Node newNode=new Node(t);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            size++;
        }
    }
    public boolean delete(T t){
        if(indexOf(t)<0)return false;    //через indexOf()
        if(indexOf(t)==0){
            deleteFirst();
            return true;
        }
        if(indexOf(t)>0){
            Node<T>current=first;
            int i=0;
            while (i<indexOf(t)-1){
                current=current.getNext();
                i++;
            }
            current.setNext(current.getNext().getNext());
            size--;
        }return true;
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

    class Node<T> {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}