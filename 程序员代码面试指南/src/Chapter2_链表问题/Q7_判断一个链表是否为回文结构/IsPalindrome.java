package Chapter2_链表问题.Q7_判断一个链表是否为回文结构;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/05/2020 13:42
 **/

public class IsPalindrome {
    //把哟个链表拆成两半，然后逐个进行比较.
    public boolean checkPalindrome(Node head){
        if( head == null || head.next == null){
            return true;
        }
        int len = 1;
        Node temp = head;
        while (temp.next != null){
            len++;
            temp = temp.next;
        }
        Node fPre = head;
        boolean odd = len % 2 != 0;
        int offset = odd ? len/2 +1 : len/2 ;
        while (--offset != 0 && fPre != null){
            fPre = fPre.next;
        }
        Node end = fPre.next;
        Node mid = fPre.next;
        fPre.next = null;
        Node first = null;
        Node last = mid.next;
        while (mid != null){
            mid.next = first;
            first = mid;
            mid = last;
            if(last != null){
                last = last.next;
            }
        }
        if(odd){
            end.next = fPre;
        }
        while (first != null && head != null){
            if(first.value == head.value){
                first = first.next;
                head = head.next;
            }else{
                return false;
            }
        }
        if(first == null && head == null){
            return true;
        }
        return false;
    }

    @Test
    void test1(){
        Node n2 = new Node(2);
        Node n1 = new Node(1,n2);
        Assertions.assertFalse(checkPalindrome(n1));
    }
    @Test
    void test2(){
        Node n3 = new Node(1);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);
        Assertions.assertTrue(checkPalindrome(n1));
    }
    @Test
    void test3(){
        Node n4 = new Node(1);
        Node n3 = new Node(3,n4);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);
        Assertions.assertFalse(checkPalindrome(n1));
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
