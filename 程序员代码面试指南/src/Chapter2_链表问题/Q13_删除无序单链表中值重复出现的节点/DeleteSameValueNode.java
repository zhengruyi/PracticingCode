package Chapter2_链表问题.Q13_删除无序单链表中值重复出现的节点;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/05/2020 13:18
 **/

public class DeleteSameValueNode {
    public Node delete(Node head){
        Set <Node> set = new TreeSet <Node>(new Compare());
        Node dummyHead = new Node(-1);
        Node dummyEnd = dummyHead;
        while (head != null){
           Node t =head;
           head = head.next;
           t.next = null;
           set.add(t);

        }
        Iterator<Node> it = set.iterator();
        while (it.hasNext()){
            dummyEnd.next = it.next();
            dummyEnd = dummyEnd.next;
        }
        return dummyHead.next;
    }
    @Test
    void test(){
        Node head = new Node(1);
        Node end = head;
        int [] array = {2,3,3,4,4,2,1,1};
        for (int i = 0; i < array.length; i++) {
            Node temp = new Node(array[i]);
            end.next = temp;
            end = temp;
        }
        Node h = delete(head);
        assertEquals(1,h.value);
        assertEquals(2,h.next.value);
        assertEquals(3,h.next.next.value);
        assertEquals(4,h.next.next.next.value);
    }
}
class Compare implements Comparator<Node>{

    @Override
    public int compare(Node o1, Node o2) {
        return o1.value - o2.value;
    }
}
class Node {
    public int value;
    public Node next;
    Node(int value){
        this.value = value;
    }
    Node(int value , Node next){
        this.value = value;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Node node = (Node) o;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }
}