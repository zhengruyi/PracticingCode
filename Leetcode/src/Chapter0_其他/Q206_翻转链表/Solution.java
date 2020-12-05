package Chapter0_其他.Q206_翻转链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/12/2020 20:15
 **/

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode post = curr;
        while(curr != null){
            post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
        }
        return pre;
    }
}
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
