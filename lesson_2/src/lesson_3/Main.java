package lesson_3;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
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
        String revert=String.copyValueOf(ch);
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

        MyPriorityQueue<Integer>mpq=new MyPriorityQueue<>();
        mpq.insert(5);
        System.out.println(mpq);
        mpq.insert(3);
        System.out.println(mpq);
        mpq.insert(1);
        System.out.println(mpq);
        mpq.insert(8);
        System.out.println(mpq);
        mpq.remove();
        System.out.println(mpq);
        Stack st=new Stack();
    }
}
