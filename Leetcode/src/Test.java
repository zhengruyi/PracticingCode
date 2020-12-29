import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode mid = getMid(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(head,l2);
    }
    public ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = head;
        while(curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
    public ListNode mergeList(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(h1 != null && h2 != null){
            pre.next = h1;
            pre = h1;
            pre.next = h2;
            pre = h2;
            h1 = h1.next;
            h2 = h2.next;
        }
        if(h1 != null){
            pre.next = h1;
        }
        if(h2 != null){
            pre.next = h2;
        }
        return dummy.next;
    }
    @org.junit.jupiter.api.Test
    void test(){
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);
        reorderList(n1);

    }

    public static void main(String[] args) {
        System.out.println((char)('b'+'A' - 'a'));
        System.out.println('A' - 'a');
    }

}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}