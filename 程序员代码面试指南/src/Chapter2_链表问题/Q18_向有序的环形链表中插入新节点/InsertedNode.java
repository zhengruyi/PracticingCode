package Chapter2_链表问题.Q18_向有序的环形链表中插入新节点;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/05/2020 19:35
 **/

public class InsertedNode {
    Node n1;
    public Node insert(Node head, Node node){
        if(node == null){
            return head;
        }
        if(head == null){
            node.next = node;
            return node;
        }
        Node temp = head;
        while (true){
            if(temp.next == head || temp.value <= node.value && temp.next.value >= node.value ){
                node.next = temp.next;
                temp.next = node;
                break;
            }
            temp =temp.next;
        }
        return node.value < head.value ? node : head;
    }
    @BeforeEach
    void setup(){
        Node n2 = new Node(2);
        n1 = new Node(1,n2);
        n2.next = n1;
    }
    @Test
    void test(){
        Node node = new Node(2);
        Node h = insert(n1,node);
        assertEquals(1,h.value);
        assertEquals(2,h.next.value);
        assertEquals(2,h.next.next.value);
    }
    @Test
    void test1(){
        Node node = new Node(3);
        Node h = insert(n1,node);
        assertEquals(1,h.value);
        assertEquals(2,h.next.value);
        assertEquals(3,h.next.next.value);
    }
    @Test
    void test2(){
        Node node = new Node(1);
        Node h = insert(n1,node);
        assertEquals(1,h.value);
        assertEquals(1,h.next.value);
        assertEquals(2,h.next.next.value);
    }
    @Test
    void test3(){
        Node node = new Node(0);
        Node h = insert(n1,node);
        assertEquals(0,h.value);
        assertEquals(1,h.next.value);
        assertEquals(2,h.next.next.value);
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

