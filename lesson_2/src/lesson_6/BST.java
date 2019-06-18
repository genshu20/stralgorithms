package lesson_6;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>,Value> {
    Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private  int size;
        private int depth;

        public Node(Key key, Value value, int c_depth) {
            this.key = key;
            this.value = value;
            size=1;
            this.depth=c_depth;
        }
    }
    public int size(){
       return size(root);
    }
    private int size(Node node){
        if(node==null)return 0;
        return node.size;
    }
    public boolean isEmpty(){
        return root==null;
    }
    private boolean isKeyNotNull(Key key){
        if(key==null){
            throw new IllegalArgumentException("don't null");
        }
        return true;
    }
    public boolean contains(Key key){
        isKeyNotNull(key);
        return get(key)!=null;
    }
    public Value get(Key key){
       return get(root,key);
    }
    private Value get(Node node,Key key){
        isKeyNotNull(key);
        if(node==null)return null;
        int cmp=key.compareTo(node.key);
        if(cmp==0)return node.value;
        else if(cmp<0)return get(node.left,key);
        else return get(node.right,key);
    }

    public void put(Key key,Value value){
        isKeyNotNull(key);
        if(value==null){
            delete(key);
            return;
        }
        root=put(root,key,value,1);
    }
    private Node put(Node node,Key key,Value value, int depth){
        if(node==null)return new Node(key,value,depth);
        int cmp=key.compareTo(node.key);
        if(cmp==0)node.value=value;
        else if(cmp<0)node.left=put(node.left,key,value, ++depth);
        else node.right=put(node.right,key,value, ++depth);
        node.size=size(node.left)+size(node.right)+1;
        return node;
    }
    public int getDepth(Key key){
        return getDepth(root,key);
    }
    private int getDepth(Node node,Key key){
        isKeyNotNull(key);
        if(node==null)return 0;
        int cmp=key.compareTo(node.key);
        if(cmp==0)return node.depth;
        else if(cmp<0)return getDepth(node.left,key);
        else return getDepth(node.right,key);
    }
    public Value min(){
        return min(root).value;
    }
    private Node min(Node node){
        if(node.left==null)return node;
        return min(node.left);
    }
    public Value max(){
        return max(root).value;
    }
    private Node max(Node node){
        if(node.right==null)return node;
        return max(node.left);
    }
    public void deleteMin(){
        if(isEmpty())throw new NoSuchElementException();
        root=deleteMin(root);
    }
    private Node deleteMin(Node node){
        if(node.left==null)return node.right;
        node.left=deleteMin(node.left);
        node.size=size(node.left)+size(node.right)+1;
        return node;
    }
    public void delete(Key key){
        isKeyNotNull(key);
        root=delete(root,key);
    }
    private Node delete(Node node,Key key){
        if(node==null)return null;
        int cmp=key.compareTo(node.key);
        if(cmp<0)node.left=delete(node.left,key);
        else if(cmp>0)node.right=delete(node.right,key);
        else {
            if(node.left==null)return node.right;
            if(node.right==null)return node.left;
            Node temp=node;
            node=min(node.right);
            node.right=deleteMin(temp.right);
            node.left=temp.left;
        }
        node.size=size(node.left)+size(node.right)+1;
        return node;
    }

    @Override
    public String toString() {
        return "BST{" +
                toString(root)+
                '}';
    }
    private String toString(Node node){
        if(node==null)return "";
        return toString(node.left)+" key: "+node.key.toString()+ " value: " +node.value.toString()+
                " depth: "+ node.depth + " "+toString(node.right);
    }
}
