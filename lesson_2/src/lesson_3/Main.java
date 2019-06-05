package lesson_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        MyStack<Integer> myStack=new MyStack(8);
//        myStack.push(1);
//        myStack.push(2);
//        myStack.push(3);
//        myStack.push(4);
//        myStack.push(5);
//        myStack.push(6);
//        myStack.push(6);
//        myStack.push(6);
//        myStack.push(6);
//        myStack.push(6);
//        System.out.println(myStack);
//        for (int i = 0; i <6 ; i++) {
//            System.out.println(myStack.pop());
//        }
//        Expression e=new Expression("(weyuiweq{sdfkahf[vn]nvksdv}vv}");
//        System.out.println(e.checkBracket());
//        MyQueue<Integer>myQueue=new MyQueue<>(5);
//        myQueue.insert(1);
//        myQueue.insert(2);
//        myQueue.insert(3);
//        System.out.println(myQueue);
//        System.out.println(myQueue.remove());
//        System.out.println(myQueue.remove());
//        System.out.println(myQueue);
//        myQueue.insert(11);
//        myQueue.insert(12);
//        myQueue.insert(13);
//        System.out.println(myQueue);
//        MyQueue<Integer>myQueue=new MyQueue<>(4);
//        myQueue.insert(1);
//        myQueue.insert(2);
//        myQueue.insert(3);
//        myQueue.insert(4);
//       myQueue.insert(5);
//       myQueue.insert(6);
//        myQueue.insert(7);
//        System.out.println(myQueue);
//        myQueue.remove();
//        myQueue.remove();
//        myQueue.remove();
//        System.out.println(myQueue);
//        myQueue.insert(1);
//        myQueue.insert(2);
//        myQueue.insert(3);
//        myQueue.insert(3);
//        myQueue.insert(4);
//        myQueue.insert(4);
//        myQueue.insert(4);
//        myQueue.insert(4);
//        myQueue.insert(5);
//        myQueue.insert(6);
//        myQueue.insert(7);
//        System.out.println(myQueue);
//        MyDeque<Integer>myDeque=new MyDeque<>(4);
//        myDeque.insertLeft(3);
//        myDeque.insertRight(1);
//        myDeque.insertRight(2);
//        myDeque.insertLeft(4);
//        myDeque.insertLeft(5);
//        System.out.println(myDeque);
//        myDeque.removeLeft();
//        System.out.println(myDeque);
//        myDeque.removeRight();
//        System.out.println(myDeque);
//        System.out.println(myDeque.peekRight());
//        System.out.println(myDeque.peekLeft());
        MyStack<Character> myStack=new MyStack<>();//разворот строки стэком
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the string");
        String str=sc.next();
        for (int i = 0; i <str.length() ; i++) {
            myStack.push(str.charAt(i));
        }
        char[]ch=new char[str.length()];
        for (int i = 0; i <str.length() ; i++) {
            ch[i]=myStack.pop();
        }
        String revert=str.copyValueOf(ch);
        System.out.println(str);
        System.out.println(revert);

        MyStack<Integer> myStackInt=new MyStack<>(3);// проверка стэка
        myStackInt.push(1);
        myStackInt.push(2);
        myStackInt.push(3);
        myStackInt.push(4);
        System.out.println(myStackInt);
        myStackInt.pop();
        System.out.println(myStackInt);

        MyQueue<Integer> myQueue=new MyQueue<>(3);// проверка queue
        myQueue.insert(1);
        myQueue.insert(2);
        myQueue.insert(3);
        myQueue.insert(4);
        System.out.println(myQueue);
        myQueue.remove();
        System.out.println(myQueue);

        MyDeque<Integer>myDeque=new MyDeque<>(3);
        myDeque.insertLeft(1);
        myDeque.insertLeft(2);
        myDeque.insertRight(3);
        myDeque.insertRight(4);
        System.out.println(myDeque);
        myDeque.removeRight();
        System.out.println(myDeque);
        myDeque.removeLeft();
        System.out.println(myDeque);
    }
}
