package Chapter15_面试题.Q0207_链表相交;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/01/2021 21:30
 **/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA != null ^ headB != null) {
            return null;
        }
        ListNode end1 = null;
        ListNode end2 = null;
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2) {
            if (h1.next == null) {
                end1 = h1;
                h1 = headB;
            } else {
                h1 = h1.next;
            }

            if (h2.next == null) {
                end2 = h2;
                h2 = headA;
            } else {
                h2 = h2.next;
            }
            if (end1 != null && end2 != null && end1 != end2) {
                return null;
            }
        }
        return h1;
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