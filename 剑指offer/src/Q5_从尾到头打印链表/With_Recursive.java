package Q5_从尾到头打印链表;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/04/2020 20:42
 **/

public class With_Recursive {

    public String reversePrintRecursive(Node head) {
        if (head == null)
            return null;
        StringBuffer buffer = new StringBuffer();
        recursive(head, buffer);
        return buffer.toString();
    }

    public void recursive(Node head, StringBuffer buffer) {
        if (head == null)
            return;
        else
            recursive(head.next, buffer);
        buffer.append(head.value);
    }

    @Test
    void test() {
        // 13->6->2->5
        Node n3 = new Node(5, null);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(6, n2);
        Node head = new Node(13, n1);

        Assertions.assertEquals("52613", reversePrintRecursive(head));
        Assertions.assertEquals("5", reversePrintRecursive(n3));
        Assertions.assertNull(reversePrintRecursive(null));
    }
}

