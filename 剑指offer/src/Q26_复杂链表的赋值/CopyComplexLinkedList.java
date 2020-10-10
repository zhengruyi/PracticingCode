package Q26_复杂链表的赋值;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/04/2020 11:27
 **/

public class CopyComplexLinkedList {
    public Node copy(Node head){
        if(head == null)
            return null;
        Node start = head;
        while (start != null){
            Node temp = new Node(start.value, null, null);
            temp.next = start.next;
            start.next = temp;
            start = start.next.next;
        }
        start = head;
        while (start != null){
            Node next = start.next;
            if(start.sibling != null){
                next.sibling = start.sibling.next;
            }else{
                next.sibling = null;
            }
            start = start.next.next;
        }
        start = head;
        Node root = start.next;
        while (start != null){
            Node temp = start.next;
            start.next = start.next.next;
            start = start.next;
            if(start !=null){
                temp.next = temp.next.next;
            }else{
                temp.next = null;
            }

    }
        return root;

    }

    @Test
    void test(){
        Node n5 = new Node(5,null,null);
        Node n4 = new Node(4,n5,null);
        Node n3 = new Node(3,n4,null);
        Node n2 = new Node(2,n3,n5);
        n4.sibling = n2;
        Node n1 = new Node(1,n2,n3);
        Node root = copy(n1);
        Assertions.assertEquals(3,root.sibling.value);
        Assertions.assertEquals(2,root.next.next.next.sibling.value);
        Assertions.assertEquals(5,root.next.sibling.value);

    }

}

class Node{
    public  int  value;
    public  Node next;
    public  Node sibling;

    public Node(int value, Node next, Node sibling){
        this.value = value;
        this.next = next;
        this.sibling = sibling;

    }
}
