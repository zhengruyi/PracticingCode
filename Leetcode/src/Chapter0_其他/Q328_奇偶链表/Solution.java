package Chapter0_其他.Q328_奇偶链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/01/2021 18:45
 **/

public class Solution {
    /**
     * 思想很简单,把原链表拆分成奇偶两部分，最后再把两部分合并好就行
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode tmp = even;
        ListNode dummy = odd;
        while (head != null) {
            odd.next = head;
            odd = odd.next;
            head = head.next;
            odd.next = null;
            if (head != null) {
                even.next = head;
                even = even.next;
                head = head.next;
                even.next = null;
            }
        }
        odd.next = tmp.next;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}