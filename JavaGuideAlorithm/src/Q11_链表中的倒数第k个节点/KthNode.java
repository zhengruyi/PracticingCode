package Q11_链表中的倒数第k个节点;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/05/2020 19:49
 **/

public class KthNode {
    Node n1;
    public Node getNode(Node head, int k){
        if(k < 1 || head == null)
            return null;
        Node temp = head;
        int  step = 0;
        while (head.next != null){
            if(step >= k - 1){
                temp = temp.next;
            }
            step++;
            head = head.next;
        }
        if(step < k - 1){
            return null;
        }else{
            return temp;
        }
    }
    @BeforeEach
    void setup(){
        Node n5 = new Node(5);
        Node n4 = new Node(4);
        n4.next =n5;
        Node n3 = new Node(3);
        n3.next =n4;
        Node n2 = new Node(2);
        n2.next = n3;
        n1 = new Node(1);
        n1.next = n2;
    }
    @Test
    void test(){
        Assertions.assertEquals(3,getNode(n1,3).value);
        Assertions.assertNull(getNode(n1,7));
        Assertions.assertEquals(1,getNode(n1,5).value);
    }

}
class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
