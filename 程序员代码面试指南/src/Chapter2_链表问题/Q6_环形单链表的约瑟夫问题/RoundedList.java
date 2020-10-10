package Chapter2_链表问题.Q6_环形单链表的约瑟夫问题;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/05/2020 12:21
 **/

public class RoundedList {
    public Node getLastNode(Node head, int m) {
        if(head == null || m < 1){
            return null;
        }
        int len = 1;
        Node temp = head;
        while (temp.next != head) {
            len++;
            temp = temp.next;
        }
        int times = getLive(len,m);
        temp =head;
        while (--times > 0){
            temp = temp.next;
        }
        return temp;
    }

    public int getLive(int n, int m) {
        if (n == 1) {
            return 1;
        }
        return ((getLive(n - 1,m) + m -1 ) % n + 1);
    }
    @Test
    void test(){
        Node n3 = new Node(3);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);
        n3.next = n1;
        Assertions.assertEquals(2,getLastNode(n1,4).value);
    }
    @Test
    void test1(){
        Node n5 = new Node(5);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node head = new Node(1, n2);
        n5.next = head;
        Assertions.assertEquals(4,getLastNode(head,3).value);
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
