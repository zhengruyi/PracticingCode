package Q10_翻转链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/05/2020 16:26
 **/

public class ReverseLinkedList {
    public static Node reverse(Node head){
        if(head == null || head.next == null)
            return head;
        Node first = null;
        Node mid = head;
        Node last = head.next;
        while (mid.next != null){
            mid.next = first;
            first = mid;
            mid = last;
            last = last.next;
        }
        mid.next = first;
        return mid;
    }

    public static void main(String[] args) {
        Node n5 = new Node(5);
        Node n4 = new Node(4);
        n4.next =n5;
        Node n3 = new Node(3);
        n3.next =n4;
        Node n2 = new Node(2);
        n2.next = n3;
        Node n1 = new Node(1);
        n1.next = n2;
        Node head = reverse(n1);
        while (head != null){
            System.out.print(head.value);
            head = head.next;
        }
    }
}
class Node{
    int value;
    Node next;
    public Node(int value){
        this.value = value;
    }
}