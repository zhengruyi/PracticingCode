package Chapter2_链表问题.Q15_将搜索二叉树转成双向链表;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/05/2020 15:00
 **/

public class ChangeTreeToDoubleLinkedList {
    public Node change(Node tree) {
        if (tree == null) {
            return tree;
        }
        Node end = process(tree);
        Node head = end.right;
        end.right = null;
        return head;
    }

    public Node process(Node head) {
        if (head == null) {
            return head;
        }
        Node leftEnd = process(head.left);
        Node rightEnd = process(head.right);
        Node leftStart = leftEnd == null ? null : leftEnd.right;
        Node rightStart = rightEnd == null ? null : rightEnd.right;
        if(leftEnd != null && rightEnd != null){
            head.left = leftEnd;
            leftEnd.right = head;
            head.right = rightStart;
            rightStart.left = head;
            rightEnd.right = leftStart;
            return rightEnd;
        }else if(leftEnd != null){
            leftEnd.right = head;
            head.left = leftEnd;
            head.right = leftStart;
            return head;
        }else if(rightEnd != null){
            head.right = rightStart;
            rightStart.left = head;
            rightEnd.right = head;
            return rightEnd;
        }else {
            head.right = head;
            return head;
        }
    }
    @Test
    void test(){
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n8 = new Node(8);
        Node n2 = new Node(2,n1,n3);
        Node n5 = new Node(5);
        Node n9 = new Node(9,n8,null);
        Node n4 = new Node(4,n2,n5);
        Node n7 = new Node(7,null,n9);
        Node n6 = new Node(6,n4,n7);
        Node h = change(n6);
        assertEquals(1,h.value);
        assertNull(h.left);
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}