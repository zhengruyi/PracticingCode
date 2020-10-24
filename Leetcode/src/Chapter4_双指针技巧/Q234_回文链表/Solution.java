package Chapter4_双指针技巧.Q234_回文链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/10/2020 22:11
 **/

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //快慢指针来找出链表终点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //当链表为奇数时，slow需要在移动一次来
        if (fast != null) {
            slow = slow.next;
        }
        //反转以slow为头结点的链表
        ListNode right = reverse(slow);
        ListNode left = head;
        //比较两个链表，看是否相等
        while (right != null) {
            if (right.val != left.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode nxt = head;
        //链表反转方式，需要记忆
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
