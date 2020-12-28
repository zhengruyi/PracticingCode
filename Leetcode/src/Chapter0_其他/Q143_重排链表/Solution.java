package Chapter0_其他.Q143_重排链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/12/2020 23:05
 **/

public class Solution {
    /**
     * 基本思路，找到链表的中间节点，分成两条链表后
     * 翻转右边部分链表，最后按照规则合并两个链表
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode mid = getMid(head);
        //中间链表的下一个节点就是右半部分链表的头结点
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(head,l2);
    }

    /**
     * 找出链表的中间节点
     * @param head
     * @return
     */
    public ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 翻转链表并返回新的节点头
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = head;
        while(curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 合并两个有序链表
     * @param h1
     * @param h2
     * @return
     */
    public ListNode mergeList(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(h1 != null && h2 != null){
            pre.next = h1;
            pre = h1;
            h1 = h1.next;
            pre.next = h2;
            pre = h2;
            h2 = h2.next;
        }
        if(h1 != null){
            pre.next = h1;
        }
        if(h2 != null){
            pre.next = h2;
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