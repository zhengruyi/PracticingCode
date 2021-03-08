package Chapter0_其他.Q1721_交换链表中的节点;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/03/2021 22:51
 **/

public class Solution {
    /**
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        while(k - 1 != 0){
            fast = fast.next;
            k -= 1;
        }
        //找到从左到右的第k个节点
        ListNode L = fast;
        ListNode slow = head;
        //由于不存在越界情况,所以快慢指针来找出倒数第k个节点
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //交换两个节点的值
        ListNode R = slow;
        int temp = L.val;
        L.val = R.val;
        R.val = temp;
        return head;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}