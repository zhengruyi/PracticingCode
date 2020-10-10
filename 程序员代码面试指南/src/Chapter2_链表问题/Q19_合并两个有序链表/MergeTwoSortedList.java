package Chapter2_链表问题.Q19_合并两个有序链表;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/05/2020 20:11
 **/

public class MergeTwoSortedList {
    public Node merge(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        Node head = null;
        head = l1.value < l2.value ? l1 : l2;
        head.next = l1.value < l2.value ? merge(l1.next,l2) : merge(l1,l2.next);
        return head;
    }
    @Test
    void test(){
        Node l3 = new Node(3);
        Node l1 = new Node(1,l3);
        Node l4 = new Node(4);
        Node l2 = new Node(2,l4);
        Node h = merge(l1,l2);
        Assertions.assertEquals(1,h.value);
        Assertions.assertEquals(2,h.next.value);
        Assertions.assertEquals(3,h.next.next.value);
        Assertions.assertEquals(4,h.next.next.next.value);
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
