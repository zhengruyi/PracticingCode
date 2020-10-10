package Q15_链表中倒数第k个节点;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/04/2020 22:14
 **/

public class Find {
    public Node findInverseK(Node head, int k) {
        if (head == null || k <= 0)
            return null;
        Node first = head;
        Node second = head;
        int step = 0;
        while (step <= k - 1) {
            if (first == null)
                return null;
            first = first.next;
            step++;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    @Test
    void test() {
        Node n4 = new Node(4, null);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node head = new Node(1, n2);

        Assertions.assertEquals(3, findInverseK(head, 2).value);
        Assertions.assertEquals(null, findInverseK(null, 1));
        Assertions.assertEquals(null,findInverseK(head,9));
        Assertions.assertEquals(null,findInverseK(head,0));
        Assertions.assertEquals(1,findInverseK(head,4).value);
        Assertions.assertEquals(4,findInverseK(head,1).value);

    }
}

class Node {
    public Node next;
    public int value;

    public Node(int value, Node next) {
        this.next = next;
        this.value = value;
    }
}