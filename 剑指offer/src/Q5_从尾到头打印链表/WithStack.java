package Q5_从尾到头打印链表;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/04/2020 20:26
 **/

public class WithStack {


    public String reversePrint(Node head) {
        Stack <Integer> stack = new Stack <>();
        StringBuffer buffer = new StringBuffer();
        if (head == null)
            return null;
        while (head != null) {
            stack.push(head.value);
            head = head.next;
        }
        while (!stack.empty()) {
            buffer.append(stack.pop());
        }
        return buffer.toString();
    }

    @Test
    void test() {
        // 13->6->2->5
        Node n3 = new Node(5,null);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(6,n2);
        Node head = new Node(13,n1);

        Assertions.assertEquals("52613",reversePrint(head));
        Assertions.assertEquals("5",reversePrint(n3));
        Assertions.assertNull(reversePrint(null));
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

