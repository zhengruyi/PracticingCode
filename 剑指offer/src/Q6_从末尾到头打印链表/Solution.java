package Q6_从末尾到头打印链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/01/2021 23:13
 **/

public class Solution {
    /**
     * 先把链表反转后在遍历就是从末尾到头的遍历
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        ListNode next = cur;
        ListNode pre = null;
        int size = 0;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            size++;
        }
        int[] res = new int[size];
        int index = 0;
        while (pre != null) {
            res[index++] = pre.val;
            pre = pre.next;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}