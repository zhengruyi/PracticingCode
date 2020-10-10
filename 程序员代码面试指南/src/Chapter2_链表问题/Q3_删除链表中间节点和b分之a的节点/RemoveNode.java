package Chapter2_链表问题.Q3_删除链表中间节点和b分之a的节点;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/05/2020 19:19
 **/

public class RemoveNode {
    Node n1;
    Node n2;
    Node n3;
    Node n5;
    public Node removeMidNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        if(head.next.next == null){
            return head.next;
        }
        Node fast = head.next.next;
        Node slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public Node removeNodeByRatio(Node head, int a, int b){
        if(head == null || a < 1 || a > b){
            return head;
        }
        int n = 0;
        Node curr = head;
        while (curr != null){
            n++;
            curr = curr.next;
        }
        n = (int) Math.ceil((double)(n *a)/b);
        if (n == 1){
            return head.next;
        }else{
            Node temp = head;
            while (--n != 1){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        return head;
    }

    @BeforeEach
    void setup(){
        n1 = new Node(1);
        Node l2 = new Node(2);
        n2 = new Node(1,l2);
        Node t5 = new Node(5);
        Node t4 = new Node(4,t5);
        Node t3 = new Node(3,t4);
        Node t2 = new Node(2,t3);
        n5 = new Node(1,t2);
        Node m3 = new Node(3);
        Node m2 = new Node(2,m3);
        n3 = new Node(1,m2);
    }
    @Test
    @DisplayName("remove mid test")
    void test(){
        Assertions.assertEquals(3,removeMidNode(n3).next.value);
        Assertions.assertEquals(2,removeMidNode(n2).value);
        Assertions.assertEquals(4,removeMidNode(n5).next.next.value);
    }
    @Test
    @DisplayName("remove node by ratio")
    void test1(){
        Assertions.assertEquals(2,removeNodeByRatio(n5,1,5).value);
    }
    @Test
    void test2(){
        Assertions.assertEquals(4,removeNodeByRatio(n5,3,5).next.next.value);
    }
    @Test
    void test3(){
        Assertions.assertEquals(5,removeNodeByRatio(n5,4,5).next.next.next.value);
    }


}
class Node{
    public int value;
    public Node next;
    Node(int value){
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}