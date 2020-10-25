package Chapter0_其他.Q382_链表随机节点;

import java.util.Random;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/10/2020 21:41
 **/

public class Solution {
    Random r;
    ListNode head;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        this.head = head;
        r = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int i = 0;
        int res = 0;
        ListNode p = head;
        //// 1/i *(1-1/(i+1)) *(1-1/(i+2))..... = 1/n
        while (p != null) {
            if (r.nextInt(++i) == 0) {
                res = p.val;
            }
            p = p.next;
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