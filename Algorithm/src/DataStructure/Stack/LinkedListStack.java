package DataStructure.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/07/2019 19:46
 **/

public class LinkedListStack {
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
    private int length=0;
    public void push(int data){
        Node target=new Node(data);
        target.setNext(top);
        top=target;
        length++;
    }

    public Node pop(){
        if(top==null)
            throw  new RuntimeException("Linked stack is empty");
        Node t=top;
        top=top.getNext();
        length--;
        return t;
    }

    @Override
    public String toString() {
        Node tempery=top;
        while(tempery!=null){
            System.out.println(tempery.getData());
            tempery=tempery.getNext();
        }
        return "";
    }


    public static void main(String[] args) {
        LinkedListStack stack=new LinkedListStack();
        for(int i=1;i<=10;i++)
            stack.push(i);
        System.out.println(stack);

        while (true){
            try{
                System.out.println(stack.pop().getData());
            }catch (RuntimeException e){
                break;
            }

        }


    }
}
