package Chapter2_链表问题.Q12_将单链表的每k个节点之间逆序;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/05/2020 12:30
 **/

public class ReverseForKLinkedList {
    Node n1;
    public Node reverseKthLinkedList(Node head, int k){
        if(head == null || k < 1){
            return head;
        }
        Node temp = head;
        Node dummyHead = new Node(-1);
        Node dummyEnd = dummyHead;
        while (temp != null){
            Node reverseStart = temp;
            int offset = k;
            while (temp != null && --offset != 0){
                temp = temp.next;
            }
            if (offset == 0){
                Node reverseEnd = temp;
                temp = temp.next;
                reverseEnd.next = null;
                dummyEnd.next = reverse(reverseStart);
                dummyEnd = reverseStart;
            }else{
                dummyEnd.next = reverseStart;
                break;
            }

        }
        return dummyHead.next;
    }
    public Node reverse(Node h){
        if(h == null || h.next == null){
            return h;
        }
        Node first = null;
        Node mid = h;
        Node last = null;
        while (mid != null){
            last = mid.next;
            mid.next = first;
            first = mid;
            mid = last;
        }
        return  first;
    }
    @BeforeEach
    void setup(){
        Node n8 = new Node(8);
        Node n7 = new Node(7,n8);
        Node n6 = new Node(6,n7);
        Node n5 = new Node(5,n6);
        Node n4 = new Node(4,n5);
        Node n3 = new Node(3,n4);
        Node n2 = new Node(2,n3);
        n1 = new Node(1,n2);
    }

    @Test
    @DisplayName("reverse for each 3 nodes")
    void test(){
        Node h = reverseKthLinkedList(n1,3);
        assertEquals(3,h.value);
        assertEquals(1,h.next.next.value);
        assertEquals(6,h.next.next.next.value);
    }
    @Test
    void test1(){
        Node h = reverseKthLinkedList(n1,1);
        assertEquals(1,h.value);
        assertEquals(3,h.next.next.value);
        assertEquals(4,h.next.next.next.value);
    }
    @Test
    void test2(){
        Node h = reverseKthLinkedList(n1,8);
        assertEquals(8,h.value);
        assertEquals(6,h.next.next.value);
        assertEquals(5,h.next.next.next.value);
    }
}
class Node {
    public int value;
    public Node next;
    Node(int value){
        this.value = value;
    }
    Node(int value , Node next){
        this.value = value;
        this.next = next;
    }
}