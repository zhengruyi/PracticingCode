package Chapter2_链表问题.Q8_将单向链表按某值划分成左边小中间相等右边大的形式;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/05/2020 16:52
 **/

public class SplitLinkedList {
    public Node splitList(Node head, int pivot){
        if( head == null){
            return null;
        }
        Node dummySmallHead = new Node(-1);
        Node smallEnd = dummySmallHead;
        Node dummyEqualHead = new Node(-1);
        Node equalEnd = dummyEqualHead;
        Node dummyBigHead = new Node(-1);
        Node bigEnd = dummyBigHead;
        while (head != null){
            if(head.value < pivot){
                smallEnd.next = head;
                smallEnd = head;
            }else if( head.value == pivot){
                equalEnd.next = head;
                equalEnd = head;
            }else{
                bigEnd.next = head;
                bigEnd = head;
            }
            head = head.next;
        }
        //要考虑分成的三组链表中可能有一两组是null这会影响最后的返回结果
        if(dummySmallHead.next == null){
            if(dummyEqualHead.next == null){
                return dummyBigHead.next;
            }else{
                equalEnd.next = dummyBigHead.next;
                return dummyEqualHead.next;
            }
        }else{
            if(dummyEqualHead.next == null){
                smallEnd.next = dummyBigHead.next;
                return dummySmallHead.next;
            }else{
                equalEnd.next = dummyEqualHead.next;
                equalEnd.next = dummyBigHead.next;
                return dummySmallHead.next;
            }
        }
    }
    @Test
    void test(){
        Node n1 = new Node(1);
        Node n5 = new Node(5,n1);
        Node n4 = new Node(4,n5);
        Node n0 = new Node(0,n4);
        Node head = new Node(9,n0);
        Node h = splitList(head,3);
        Assertions.assertEquals(0,h.value);
        Assertions.assertEquals(1,h.next.value);
        Assertions.assertEquals(9,h.next.next.value);
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

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

