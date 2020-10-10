package Chapter2_链表问题.Q1_打印两个有序链表的公共部分;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/05/2020 21:10
 **/

public class PrintCommonPart {
    public static void print(Node h1, Node h2){
        if(h1 == null || h2 == null){
            return;
        }
        while ((h1 !=null && h2 !=null) &&(h1.value != h2.value)){
            if(h1.value < h2.value){
                h1 = h1.next;
            }else{
                h2 = h2.next;
            }
        }
        while (h1 != null && h2 !=null){
            System.out.println(h1.value);
            h1 = h1.next;
            h2 = h2.next;
        }
    }

    public static void main(String[] args) {
        Node n5 = new Node(5);
        Node n4 = new Node(4,n5);
        Node n2 = new Node(2,n4);
        Node n3 = new Node(3,n4);
        Node n1 = new Node(1,n3);
        print(n1,n2);
    }
}
class Node{
    public int value;
    public Node next;
    Node(int value){
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
