package Chapter2_链表问题.Q11_两个单链表相交的一系列问题;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/05/2020 21:39
 **/

public class IntersectNode {
    public Node getIntersectedNode(Node h1, Node h2){
        if( h1 == null || h2 == null){
            return null;
        }
        Node loop1 = getLoopNode(h1);
        Node loop2 = getLoopNode(h2);
        if(loop1  == null && loop2 == null){
            return noLoop(h1,h2);
        }else if( loop1 != null && loop2 != null){
            return bothLoop(h1,loop1,h2,loop2);
        }
        return null;
    }
    /**
      确认链表是否有环，如果有就返回第一个入环节点,没有就返回null
     */
    public Node getLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node fast = head.next.next;
        Node slow = head.next;
        while (fast != slow){
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    /**
     * 确认在两个链表都是无环情况下求得第一个公共交点
     * @param head1
     * @param head2
     * @return
     */
    public Node noLoop(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        int len1 = 1;
        Node end1 = head1;
        int len2 = 1;
        Node end2 = head2;
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1.next != null || temp2.next != null){
            if(temp1.next != null){
                len1 ++;
                temp1 = temp1.next;
                end1 = temp1;
            }
            if(temp2.next != null){
                len2 ++;
                temp2 = temp2.next;
                end2 = temp2;
            }
        }
        if(end1 != end2){
            return null;
        }
        int n = len1 - len2;
        Node cur1 = n > 0 ? head1 : head2;
        Node cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n-- != 0){
            cur1 = cur1.next;
        }
        while (cur1 != cur2){
            cur1 =cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 在都是有环链表的情况下，分出入环节点相同和不同来分别进行考虑
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    public Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int len1 = 1;
            while (cur1 != loop1){
                len1 ++;
                cur1 = cur1.next;
            }
            int len2 =1;
            while (cur2 != loop2){
                len2 ++;
                cur2 = cur2.next;
            }
            int n = len1 - len2;
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n-- != 0){
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur1.next;
            }
            return cur1;
        }else{
            cur1 = loop1.next;
            while (cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
        }
        return null;
    }

    @Test
    void test(){
        Node n5 = new Node(5);
        Node n4 = new Node(4,n5);
        Node n3 = new Node(3,n4);
        Node n2 = new Node(2,n3);
        Node n1 = new Node(1,n2);
        Node t2 = new Node(2,n4);
        Assertions.assertEquals(4,getIntersectedNode(n1,t2).value);
    }

}
class Node {
    public int value;
    public Node next;
    Node(int value){
        this.value = value;
    }
    Node(int value ,Node next){
        this.value = value;
        this.next = next;
    }
}
