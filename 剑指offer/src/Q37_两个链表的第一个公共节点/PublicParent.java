package Q37_两个链表的第一个公共节点;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/04/2020 20:24
 **/

public class PublicParent {
    public Node findParent(Node n1, Node n2) {
        if (n1 == null || n2 == null)
            return null;

        int l1 = 0;
        Node h1 = n1;

        while (h1 != null) {
            h1 = h1.next;
            l1++;
        }

        int l2 = 0;
        Node h2 = n2;

        while (h2 != null) {
            h2 = h2.next;
            l2++;
        }

        if (l1 - l2 > 0) {
            int length = l1 - l2;
            while (length > 0) {
                n1 = n1.next;
                length--;
            }
        } else {
            int length = l2 - l1;
            while (length > 0) {
                n2 = n2.next;
                length--;
            }

        }
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        if(n1 == null && n2 == null)
            throw new RuntimeException();
        return n2;

    }
    @Test
    void test(){
        Node t7 = new Node(7,null);
        Node t6 = new Node(6,t7);
        Node t3 = new Node(3,t6);
        Node t2 = new Node(2,t3);
        Node t1 = new Node(1,t2);
        Node t5 = new Node(5,t6);
        Node t4 = new Node(4,t5);
        Assertions.assertEquals(6,findParent(t1,t4).value);
        Node n3 = new Node(3,null);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);
        Node n5 = new Node(5,null);
        Node n4 = new Node(4,n5);
        Assertions.assertThrows(RuntimeException.class,()->findParent(n1,n4));
    }

}

class Node {
    public int value;
    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}