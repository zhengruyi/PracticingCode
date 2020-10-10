package DataStructure.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/07/2019 21:05
 **/

public class LinkedListQueue {
    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    
    private Node top;
    private Node rear;
    
    public void push(int data){
        Node target=new Node(data);
        if(rear==null){
            rear=target;
            top=target;
            return;
        }
        rear.setNext(target);
        rear=target;
        
    }
    
    public Node pop(){
        if(top==null)
            throw new RuntimeException("The queue is full");
        Node node=top;
        top=top.getNext();
        return node;
    }


    @Override
    public String toString() {
        Node temporary=top;
        while(temporary!=null){
            System.out.println(temporary.getData());
            temporary=temporary.getNext();
        }
        return "";
    }
    public static void main(String[] args) {
        LinkedListQueue queue=new LinkedListQueue();
        for(int i=1;i<=40;i++)
            queue.push(i);
        System.out.println(queue);

        while (true){
            try{
                System.out.println(queue.pop().getData());
            }catch (RuntimeException e){
                break;
            }

        }


    }

}
