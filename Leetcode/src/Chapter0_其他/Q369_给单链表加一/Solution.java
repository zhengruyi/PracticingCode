package Chapter0_其他.Q369_给单链表加一;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/02/2021 23:20
 **/

public class Solution {
    public ListNode plusOne(ListNode head) {
        //先翻转链表
        ListNode begin = reverse(head);
        ListNode h = begin;
        int carry = 0;
        h.val = h.val + 1;
        ListNode pre = null;
        //将链表的数字加1，然后更新链表的值
        while(h != null){
            int sum = h.val + carry;
            carry = sum / 10;
            h.val = sum % 10;
            if(carry == 0){
                break;
            }
            pre = h;
            h = h.next;
        }
        if(carry != 0){
            pre.next = new ListNode(carry);
        }
        //最后再将链表翻转回来，得到最终的结果
        return reverse(begin);
    }

    /**
     * 将链表反转
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode pre = null;
        ListNode next = curr;
        while(curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }