package Q45_圆圈中最后剩下的数字;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/04/2020 10:39
 **/

public class LastNumber {
    public int  getLastNumber(int n, int m){
        if(n < 0 || m < 0)
            return -1;
        Node head  = new Node(0,null);
        Node h = head;
        int num = n;
        for (int i = 1; i < n; i++) {
            Node temp = new Node(i,null);
            h.next = temp;
            h = temp;
        }
        h.next = head;
        h = head;
        while (num != 1){
            int i = 1;
            while (i < m){
                h = h.next;
                i++;
            }
            h.value = h.next.value;
            h.next = h.next.next;
            num -- ;
        }
        return h.value;
    }

    @Test
    void test(){
        Assertions.assertEquals(3,getLastNumber(5,3));
        Assertions.assertEquals(3,getLastNumber(6,6));
    }
}
class Node {
    public Node next;
    public int value;

    public Node(int value, Node next) {
        this.next = next;
        this.value = value;
    }
}
