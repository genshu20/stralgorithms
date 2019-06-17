package lesson_6;

public class Main {
    public static void main(String[] args) {
        BST<Integer,String>bst=new BST<>();
        bst.put(5,"five");
        bst.put(1,"one");
        bst.put(3,"three");
        bst.put(2,"two");
        bst.put(4,"four");
        bst.put(6,"six");
        System.out.println(bst);

        BST<Integer,Integer>[]arrBst=new BST[20];
        for (int i = 0; i <20 ; i++) {
            arrBst[i]=TreeConstr.bstMaker();
            System.out.println("size "+arrBst[i].size());
            System.out.println(arrBst[i]);
        }




    }
}
