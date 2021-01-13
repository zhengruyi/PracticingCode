import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    @org.junit.jupiter.api.Test
    void test(){
        ListNode n1 = new ListNode(-2);
        ListNode n2 = new ListNode(-23);
        ListNode n3 = new ListNode(-1);
        n2.next = n3;
        n1.next = n2;
        insertionSortList(n1);
    }
    ListNode dummy = new ListNode(-1);
    public ListNode insertionSortList(ListNode head) {
        while(head != null){
            ListNode t = head;
            head = head.next;
            insert(t);
        }
        return dummy.next;
    }
    public void insert(ListNode node){
        node.next = null;
        ListNode prev = dummy;
        ListNode curr = dummy;
        while(curr != null && node.val > curr.val){
            prev = curr;
            curr = curr.next;
        }
        node.next = prev.next;
        prev.next = node;
    }

    public static void main(String[] args) {
        ListNode n3 = new ListNode(-2);
        ListNode n2 = new ListNode(-23);
        ListNode n1 = new ListNode(-1);
        n2.next = n3;
        n1.next = n2;
    }

}

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}