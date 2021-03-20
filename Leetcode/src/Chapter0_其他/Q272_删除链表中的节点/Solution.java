package Chapter0_其他.Q272_删除链表中的节点;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/03/2021 22:12
 **/

public class Solution {
    /**
     * 将下一个节点的值赋值给自己，然后删除下一个节点,简单的删除方案
     * @param node
     */
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        int val = next.val;
        next.val = node.val;
        node.val = val;
        node.next = next.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}