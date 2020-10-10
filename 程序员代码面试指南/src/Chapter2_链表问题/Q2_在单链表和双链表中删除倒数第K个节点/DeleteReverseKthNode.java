package Chapter2_链表问题.Q2_在单链表和双链表中删除倒数第K个节点;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/05/2020 21:40
 **/

public class DeleteReverseKthNode {
    Node head;
    public Node delete(Node head, int k){
        if(head == null || k < 1){
            return null;
        }
        Node cur = head;
        //会多转一轮,所以k==0是表示删除头结点
        while (cur != null){
            k--;
            cur = cur.next;
        }
        if(k == 0){
            return head.next;
        }else if(k < 0){
            Node temp = head;
            //为了找到被删节点的前一个节点，所以用 ++k
            while (++k != 0){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        return head;
    }
    @BeforeEach
    void setup(){
        Node n5 = new Node(5);
        Node n4 = new Node(4,n5);
        Node n3 = new Node(3,n4);
        Node n2 = new Node(2,n3);
        head = new Node(1,n2);
    }

    @Test
    @DisplayName("DeleteHead")
    void test(){
        Assertions.assertEquals(2,delete(head,5).value);
    }

    @Test
    @DisplayName("Delete last node")
    void test1(){
        Assertions.assertNull(delete(head,1).next.next.next.next);
    }
    @Test
    @DisplayName("Delete a mid Node")
    void test2(){
        Assertions.assertEquals(3,delete(head,4).next.value);
        Assertions.assertEquals(4,delete(head,3).next.value);
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
