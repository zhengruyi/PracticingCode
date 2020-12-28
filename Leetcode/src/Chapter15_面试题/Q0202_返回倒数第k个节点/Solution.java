package Chapter15_面试题.Q0202_返回倒数第k个节点;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/12/2020 23:26
 **/

public class Solution {
    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        ListNode fast = head;
        ListNode slow = head;
        //快慢指针，一个先移动k-1步，然后两者同时移动
        //这里保证k有效所以不需要考虑特殊情况比如k > 链表长度
        while (k > 1) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}