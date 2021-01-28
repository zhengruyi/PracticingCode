package Chapter15_面试题.Q0208_环路检测;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/01/2021 23:21
 **/

public class Solution {
    /**
     * 基本原理就是快慢指针，快指针每次走两步，慢指针每次走一步，如果快指针追上慢指针，那么说明存在环
     * 然后把快指针放回到开头，然后快慢指针每次都各走一步，他们再一次相遇的点就是链表环的起始节点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}