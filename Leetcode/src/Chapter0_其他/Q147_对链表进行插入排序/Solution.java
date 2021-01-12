package Chapter0_其他.Q147_对链表进行插入排序;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/01/2021 22:40
 **/

public class Solution {
    /**
     * 这里尤其注意因为插入的节点值可能为负值，所以设置成-1会严重打乱排序
     */
    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    public ListNode insertionSortList(ListNode head) {
        while(head != null){
            ListNode t = head;
            head = head.next;
            insert(t);
        }
        return dummy.next;
    }
    public void insert(ListNode node){
        node.next = null;
        ListNode prev = dummy;
        ListNode curr = dummy;
        //prev负责指向要插入位置的前一个节点，将prev设置成dummy是为了处理边界情况
        while(curr != null && node.val > curr.val){
            prev = curr;
            curr = curr.next;
        }
        node.next = prev.next;
        prev.next = node;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}