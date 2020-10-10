package DataStructure.Queue;

import javafx.beans.binding.ObjectExpression;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/07/2019 20:41
 **/

public class LoopArrayQueue {
    private int MAX_SIZE;
    private int top=0;
    private int rear=0;
    private int length=0;
    private Object[] queue;
    public LoopArrayQueue(int size) {
        this.MAX_SIZE = size;
        queue=new Object[MAX_SIZE];
    }
    public void push(int data){
        if((rear+1)%MAX_SIZE==top)
            throw new RuntimeException("Queue is full");
        queue[rear]=data;
        rear=(rear+1)%MAX_SIZE;
        length++;
    }

    public Object pop(){
        if(rear==top)
            throw  new RuntimeException("The queue is empty");
        Object object=queue[top];
        top=(top+1)%MAX_SIZE;
        return object;
    }

    @Override
    public String toString() {
        int t=top;
        while(t!=rear){
            System.out.println(queue[t]);
            t=(t+1)%MAX_SIZE;
        }
        return " ";
    }

    public static void main(String[] args) {
        // To identify the state empty and full, we waste a space.
        LoopArrayQueue queue=new LoopArrayQueue(11);
        for(int i=1;i<=10;i++)
            queue.push(i);
        System.out.println(queue);
        queue.pop();
        queue.pop();
        queue.push(20);
        queue.push(30);
        System.out.println(queue);
    }
}
