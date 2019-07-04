package lesson_8;

public class LinearProbingHashST<Key,Value> {
    private int capacity;
    private int size = 0;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST(int capacity) {
        this.capacity = capacity;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("null key");
        int i = hash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
            i = (i + 1) % capacity;
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("null key");
        int i = hash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key)) return values[i];
            i = (i + 1) % capacity;
        }
        return null;
    }

    @Override
    public String toString() {
        String s="";
        for (int i = 0; i <capacity ; i++) {
           s+=keys[i]+" ";
        }
        return "LinearProbingHashST{" +
                "keys=" + s +
                '}';
    }
}
