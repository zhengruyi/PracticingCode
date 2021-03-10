package Q22_链表中倒数第k个节点;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/03/2021 22:54
 **/

public class Solution {
    /**
     * 简单的快慢指针解决问题
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        while(fast.next != null && k != 1){
            fast = fast.next;
            k--;
        }
        ListNode slow = head;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}