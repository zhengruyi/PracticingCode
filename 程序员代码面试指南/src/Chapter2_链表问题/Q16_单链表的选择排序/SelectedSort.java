package Chapter2_链表问题.Q16_单链表的选择排序;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/05/2020 16:47
 **/

public class SelectedSort {
    public Node sort(Node head) {
        Node dummyHead = new Node(-1);
        Node dummyEnd = dummyHead;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        temp = head;
        while (temp.next != temp) {
            Node endPoint = temp;
            Node min = temp;
            temp = temp.next;
            while (temp != endPoint) {
                if (min.value > temp.value) {
                    min = temp;
                }
                temp = temp.next;
            }
            Node t = min.next;
            int minValue = min.value;
            min.value = min.next.value;
            min.next = min.next.next;
            t.value = minValue;
            dummyEnd.next = t;
            dummyEnd = t;
            temp = min;

        }
        dummyEnd.next = temp;
        temp.next = null;
        return dummyHead.next;
    }

    @Test
    void test() {
        Node n1 = new Node(1);
        Node n2 = new Node(2, n1);
        Node n5 = new Node(5, n2);
        Node n3 = new Node(3, n5);
        Node head = new Node(1, n3);
        Node h = sort(head);
        Assertions.assertEquals(1, h.value);
        Assertions.assertEquals(1, h.next.value);
        Assertions.assertEquals(2, h.next.next.value);
        Assertions.assertEquals(3, h.next.next.next.value);
        Assertions.assertEquals(5, h.next.next.next.next.value);
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
