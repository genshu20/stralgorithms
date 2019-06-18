package lesson_6;

public class TreeConstr {
    public static BST<Integer,Integer> bstMaker(){
        BST<Integer,Integer>bst=new BST<>();
        while (true) {
            int a = (int) (Math.random() * 199) - 99;
            if(!bst.contains(a)) bst.put(a,a);
            if(bst.getDepth(a)==7){
                bst.delete(a);
                return bst;
            }
        }
    }
}
