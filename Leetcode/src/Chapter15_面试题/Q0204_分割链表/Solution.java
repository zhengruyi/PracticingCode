package Chapter15_面试题.Q0204_分割链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/01/2021 21:09
 **/

public class Solution {
    ListNode less = new ListNode(-1);
    ListNode low = less;
    ListNode greater = new ListNode(-1);
    ListNode big = greater;

    /**
     * 按照是否小于x或者大于等于x分成两个链表，最后合并到一起
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        while (head != null) {
            ListNode t = head;
            head = head.next;
            t.next = null;
            if (t.val < x) {
                low.next = t;
                low = t;
            } else {
                big.next = t;
                big = t;
            }
        }
        low.next = greater.next;
        return less.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}