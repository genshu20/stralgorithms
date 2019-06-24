package lesson_8;

import java.util.LinkedList;

public class ChainingHash<Key,Value> {
    private int capacity;
    private int size=0;
    private LinkedList<Node>[]st;

    private class Node{
        private Key key;
        private Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}
