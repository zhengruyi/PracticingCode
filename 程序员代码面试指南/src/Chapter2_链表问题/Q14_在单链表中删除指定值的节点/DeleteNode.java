package Chapter2_链表问题.Q14_在单链表中删除指定值的节点;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/05/2020 14:38
 **/

public class DeleteNode {
    public Node deleteNode(Node head, int n){
        if(head == null){
            return null;
        }
        Node dummyHead = new Node(-1);
        Node dummyEnd = dummyHead;
        Node temp = head;
        while (temp != null){
            if(temp.value != n){
                dummyEnd.next = temp;
                dummyEnd = temp;
            }
            temp = temp.next;
        }
        return  dummyHead.next;
    }
    @Test
    void test(){
        Node n4 = new Node(4);
        Node n3 = new Node(3,n4);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);
        Node h = deleteNode(n1,3);
        Assertions.assertEquals(1,h.value);
        Assertions.assertEquals(2,h.next.value);
        Assertions.assertEquals(4,h.next.next.value);
    }
}
class Node{
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
