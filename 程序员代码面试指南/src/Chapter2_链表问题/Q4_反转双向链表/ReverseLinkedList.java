package Chapter2_链表问题.Q4_反转双向链表;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/05/2020 20:23
 **/

public class ReverseLinkedList {
    public Node reverse(Node head){
        if(head == null){
            return head;
        }
        Node first = head.last;
        Node mid = head;
        Node last = head.next;
        boolean flag = true;
        while (mid != head || flag){
            flag = false;
            mid.last = last;
            mid.next = first;
            first = mid;
            mid = last;
            last = last.next;
        }
        return first;
    }
    @Test
    void test(){
        Node n3 = new Node(3);
        Node n2 = new Node(2,n3,null);
        Node head = new Node(1,n2,n3);
        n2.last = head;
        n3.next = head;
        n3.last = n2;
        head = reverse(head);
        Assertions.assertEquals(3,head.value);
        Assertions.assertEquals(2,head.next.value);
        Assertions.assertEquals(1,head.last.value);
    }
}
class Node {
    public int value;
    public Node next;
    public Node last;
    Node(int value){
        this.value = value;
    }

    public Node(int value, Node next,Node last) {
        this.value = value;
        this.next = next;
        this.last = last;
    }
}