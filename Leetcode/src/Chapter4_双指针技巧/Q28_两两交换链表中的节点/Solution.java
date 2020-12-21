package Chapter4_双指针技巧.Q28_两两交换链表中的节点;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/12/2020 23:31
 **/

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //创建虚拟节点来减少判断
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        //每个确保都有两个节点来进行翻转
        while(pre.next != null && pre.next.next != null){
            //翻转过程
            ListNode n1 = pre.next;
            ListNode n2 = pre.next.next;
            ListNode end = n2.next;
            pre.next = n2;
            n2.next = n1;
            n1.next = end;
            pre = pre.next.next;
        }
        return dummy.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
