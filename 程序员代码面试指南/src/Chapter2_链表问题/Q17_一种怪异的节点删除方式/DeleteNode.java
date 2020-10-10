package Chapter2_链表问题.Q17_一种怪异的节点删除方式;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/05/2020 17:31
 **/

public class DeleteNode {
    Node n2;
    Node n3;
    Node n1;

    /**
     * 注意这种方式无法删除最后一个节点
     * @param n
     */
    public void delete(Node n){
        if(n.next == null){
            n = null;
        }else{
            n.value = n.next.value;
            n.next = n.next.next;
        }
    }

    @BeforeEach
    void setup(){
        n3 = new Node(3);
        n2 = new Node(2,n3);
        n1 = new Node(1,n2);
    }
    @Test
    @DisplayName("delete mid Node")
    void test1(){
        delete(n2);
        Assertions.assertEquals(3,n1.next.value);
    }
    @Test
    @DisplayName("delete last Node")
    void test2(){
        delete(n3);
        Assertions.assertEquals(3,n1.next.next.value);
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
