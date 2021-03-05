package Q18_删除链表的节点;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/03/2021 22:55
 **/

public class Solution {
    /**
     * 注意虚拟节点的技巧,来简化删除头结点的情况
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next != null && pre.next.val != val){
            pre = pre.next;
        }
        if(pre.next.val == val){
            pre.next = pre.next.next;
        }
        return dummy.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}