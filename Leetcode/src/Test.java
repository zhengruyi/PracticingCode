import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node h1 = head;
        while(h1 != null){
            Node tmp = new Node(h1.val);
            tmp.next = h1.next;
            h1.next = tmp;
            h1 = h1.next.next;
        }
        h1 = head;
        while(h1 != null){
            if(h1.random != null){
                h1.next.random = h1.random.next;
            }
            h1 = h1.next.next;
        }
        Node dummy = new Node(-1);
        Node h2 = dummy;
        h1 = head;
        while(h1 != null){
            h2.next = h1.next;
            h2 = h2.next;
            h1 = h1.next.next;
        }
        return dummy.next;
    }
    @org.junit.jupiter.api.Test
    void test(){
        Node h1 = new Node(1);
        Node h2 = new Node(2);
        Node h3 = new Node(3);
        h1.next = h2;
        h2.next = h3;
        h1.random = h3;
        h2.random = h1;
        copyRandomList(h1);
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList <>();
        res.add(1);
        Integer[] num = res.toArray(new Integer[0]);
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
