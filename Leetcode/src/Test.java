import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    @org.junit.jupiter.api.Test
    void test() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n1.random = n3;
        copyRandomList(n1);
    }

    public static void main(String[] args) {
        System.out.println("\t".length());
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node dummy = new Node(-1);
        Node h = head;
        while(h != null){
            Node tmp = new Node(h.val);
            tmp.next = h.next;
            h.next = tmp;
            h = h.next.next;
        }
        h = head;
        while(h != null){
            if(h.random != null){
                h.next.random = h.random.next;
            }
            h = h.next.next;
        }
        h = head;
        Node node  = dummy;
        while(h != null){
            node.next = h.next;
            h.next = h.next.next;
            node = node.next;
        }
        return dummy.next;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}