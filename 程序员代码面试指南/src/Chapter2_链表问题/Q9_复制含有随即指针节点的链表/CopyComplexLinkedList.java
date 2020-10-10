package Chapter2_链表问题.Q9_复制含有随即指针节点的链表;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/05/2020 19:29
 **/

public class CopyComplexLinkedList {
    public Node copy(Node head){
        if(head == null){
            return null;
        }
        Node node = head;
        while (node != null){
            Node temp = new Node(node.value);
            temp.next = node.next;
            node.next =temp;
            node = node.next.next;
        }
        node = head;
        while (node != null){
            if(node.point != null){
                node.next.point = node.point.next;
            }
            node = node.next.next;
        }
        Node dummyHead = new Node(-1);
        Node dummyEnd = dummyHead;
        node = head;
        while (node != null){
            dummyEnd.next = node.next;
            dummyEnd = node.next;
            node.next = node.next.next;
            node = node.next;
        }
        return dummyHead.next;
    }
    @Test
    void test(){
        Node n4 = new Node(4);
        Node n3 = new Node(3,n4);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);
        n1.point = n4;
        n2.point = n4;
        n3.point = n1;
        Node h = copy(n1);
        Assertions.assertEquals(4,h.point.value);
        Assertions.assertEquals(4,h.next.point.value);
        Assertions.assertEquals(1,h.next.next.point.value);
        Assertions.assertEquals(2,h.next.next.point.next.value);
        Assertions.assertNotEquals(h,n1);
        Assertions.assertEquals(h,h);
    }
}
class Node{
    public int value;
    public Node next;
    public Node point;
    Node(int value){
        this.value = value;
    }
    Node(int value, Node next){
        this.value =value;
        this.next = next;
    }
}