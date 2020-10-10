package DataStructure.Stack;

import DataStructure.LinkedList.StaticLinkedList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/07/2019 19:11
 **/

public class ArrayStack<T>{

    private int MAX_SIZE;
    private int top=-1;
    private Object[] stack;
    public ArrayStack(int size) {
        this.MAX_SIZE=size;
        this.stack=new Object[MAX_SIZE];
    }
    public void push(Object object){
        if(top==MAX_SIZE-1)
            throw new RuntimeException("The stack is full");
        top++;
        stack[top]=object;
    }

    public Object pop(){
        if(top==-1)
            throw  new RuntimeException("The stack is empty");
        Object object=stack[top];
        top--;
        return  object;
    }

    @Override
    public String toString() {
        for(Object object:stack){
            System.out.println(object);
        }
        return "";
    }

    public static void main(String[] args) {
        ArrayStack stack=new ArrayStack(10);

        for(int i=1;i<=10;i++)
            stack.push(i);
        System.out.println(stack);

        while (true){
            try{
                System.out.println(stack.pop());
            }catch (RuntimeException e){
                break;
            }

        }


    }
}
