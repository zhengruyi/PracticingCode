package Chapter15_面试题.Q0205_链表求和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 00:44
 **/

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(l1 != null || l2 != null){
            int v1 = 0;
            if(l1 != null){
                v1 = l1.val;
                l1 = l1.next;
            }
            int v2 = 0;
            if(l2 != null){
                v2 = l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode((v1 + v2 + carry)%10);
            carry = (v1 + v2 + carry)/10;
            pre = pre.next;
        }
        if(carry != 0){
            pre.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
