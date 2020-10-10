package Chapter2_链表问题.Q20_按照左右半区的方式重新组合单链表;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/05/2020 20:25
 **/

public class RelocateList {
    public Node relocate(Node head){
        if(head == null || head.next == null){
            return head;
        }
        int len = 1;
        Node temp = head;
        while (temp.next != null){
            len++;
            temp = temp.next;
        }
        int mid = len/2;
        temp = head;
        while (--mid !=0){
            temp = temp.next;
        }
        Node first = head;
        Node second = temp.next;
        temp.next = null;
        while (first !=null){
            if(first.next != null){
                Node next = second.next;
                second.next = first.next;
                first.next =second;
                first = first.next.next;
                second = next;
            }else{
                first.next = second;
                break;
            }

        }
        return head;
    }
    @Test
    void test(){
        Node n6 = new Node(6);
        Node n5 = new Node(5,n6);
        Node n4 = new Node(4,n5);
        Node n3 = new Node(3,n4);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);
        Node h = relocate(n1);
        Assertions.assertEquals(1,h.value);
        Assertions.assertEquals(4,h.next.value);
        Assertions.assertEquals(2,h.next.next.value);
        Assertions.assertEquals(5,h.next.next.next.value);
        Assertions.assertEquals(3,h.next.next.next.next.value);
        Assertions.assertEquals(6,h.next.next.next.next.next.value);
    }
    @Test
    void test1(){
        Node n5 = new Node(5);
        Node n4 = new Node(4,n5);
        Node n3 = new Node(3,n4);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);
        Node h = relocate(n1);
        Assertions.assertEquals(1,h.value);
        Assertions.assertEquals(3,h.next.value);
        Assertions.assertEquals(2,h.next.next.value);
        Assertions.assertEquals(4,h.next.next.next.value);
        Assertions.assertEquals(5,h.next.next.next.next.value);
    }
}
class Node {
    public int value;
    public Node next;

    Node(int value) {
        this.value = value;
    }

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}