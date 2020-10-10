package Chapter2_链表问题.Q5_反转部分单向链表;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/05/2020 21:34
 **/

public class ReversePartialLinkedList {
    Node head;
    public Node reverse(Node head, int from, int to) {
       int len =0;
       Node node1 = head;
       Node fPre = null;
       Node tPos = null;
       // 确定开始反转的起点和终点
       while (node1 != null){
           len++;
           fPre = len == from -1 ? node1 : fPre;
           tPos = len == to + 1 ? node1: tPos;
           node1 = node1.next;
       }
       if(from > to || from < 1 || to > len){
           return  head;
       }
       // 确定第一个反转的链表节点
       node1 = fPre == null ? head : fPre.next;
       // 要反转节点的后一个节点
       Node node2 = node1.next;
       //反转后的尾结点已经确定，可以提前连接起来
       node1.next = tPos;
       Node next = null;
       while (node2 != tPos){
           next = node2.next;
           node2.next = node1;
           node1 = node2;
           node2 = next;
       }
       //说明是从中间节点开始反转的，所以返回原链表的头结点
       if(fPre != null){
           fPre.next = node1;
           return head;
       }
       //说明是头结点参与了反转，node1指向最后一个参与反转的节点，也就是反转后的头结点
       return node1;
    }

    @BeforeEach
    void setup() {
        Node n5 = new Node(5);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        head = new Node(1, n2);
    }
    @Test
    @DisplayName("partial reverse")
    void test(){
        Node h = reverse(head,2,4);
        assertEquals(4,h.next.value);
        assertEquals(3,h.next.next.value);
        assertEquals(1,h.value);
    }
    @Test
    @DisplayName("reverse all list")
    void test2(){
        Node h = reverse(head,1,5);
        assertEquals(5,h.value);
        assertEquals(1,h.next.next.next.next.value);
    }
    @Test
    @DisplayName("reverse first nodes")
    void test3(){
        Node h = reverse(head,1,3);
        assertEquals(3,h.value);
        assertEquals(2,h.next.value);
        assertEquals(5,h.next.next.next.next.value);
    }
}

class Node {
    public int value;
    public Node next;

    Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}