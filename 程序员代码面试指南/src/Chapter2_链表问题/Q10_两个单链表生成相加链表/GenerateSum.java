package Chapter2_链表问题.Q10_两个单链表生成相加链表;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/05/2020 19:55
 **/

public class GenerateSum {
    public Node getSum(Node h1, Node h2){
        if(h1 == null){
            return h2;
        }else if(h2 == null){
            return h1;
        }
        Node t1 = reverse(h1);
        Node t2 = reverse(h2);
        Node dummyHead = new Node(-1);
        Node dummyEnd = dummyHead;
        int carry = 0;
        while (t1 != null || t2 != null){
            int c1 = t1 != null ? t1.value : 0;
            int c2 = t2 != null ? t2.value : 0;
            dummyEnd.next = new Node((c1 + c2 + carry) % 10);
            carry = (c1 + c2 + carry) / 10;
            dummyEnd = dummyEnd.next;
            t1 = t1 != null ? t1.next : null;
            t2 = t2 != null ? t2.next : null;
        }
        if(carry != 0){
            dummyEnd.next = new Node(carry);
        }
        return reverse(dummyHead.next);

    }
    public Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node first = null;
        Node mid = head;
        Node last = null;
        while (mid != null){
            last = mid.next;
            mid.next =first;
            first = mid;
            mid = last;
        }
        return first;
    }

    @Test
    void test(){
        Node n7 = new Node(7);
        Node n3 = new Node(3,n7);
        Node n9 = new Node(9,n3);
        Node t3 = new Node(3);
        Node t6 = new Node(6,t3);
        Node h = getSum(n9,t6);
        Assertions.assertEquals(1,h.value);
        Assertions.assertEquals(0,h.next.value);
        Assertions.assertEquals(0,h.next.next.value);
        Assertions.assertEquals(0,h.next.next.next.value);
    }
}
class Node {
    public int value;
    public Node next;

    Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
