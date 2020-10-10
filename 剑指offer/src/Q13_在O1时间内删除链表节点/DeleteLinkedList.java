package Q13_在O1时间内删除链表节点;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/04/2020 20:36
 **/

public class DeleteLinkedList {
    Node n4 = new Node(4, null);
    Node n3 = new Node(3, n4);
    Node n2 = new Node(2, n3);
    Node n1 = new Node(1, n2);

    public void delete(Node head, Node target) {
        if (head == null || target == null)
            return;

        if (head == target) {
            this.n1 = this.n1.next;
        } else if (target.next == null) {
            Node temp = head;
            while (temp.next != target) {
                temp = temp.next;
            }
            temp.next = target.next;
        } else {
            target.value = target.next.value;
            target.next = target.next.next;
        }
    }

    @Test
    void test() {

        delete(this.n1, this.n2);
        Assertions.assertEquals(3, this.n2.value);

        delete(this.n1, this.n4);
        Assertions.assertEquals(null, this.n2.next);

        delete(this.n1, this.n1);
        Assertions.assertEquals(3, this.n1.value);

        delete(this.n1, this.n1);
        Assertions.assertEquals(null, this.n1);


    }
}

class Node {
    public Node next;
    public int value;

    public Node(int value, Node node) {
        this.next = node;
        this.value = value;
    }
}
