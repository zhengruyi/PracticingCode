package Chapter0_其他.Q82_删除排序链表中的重复元素II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 22:46
 **/

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        //虚拟节点来简化删除头节点的情况
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        //考虑到可能会有多个相同元素，所以这里用变量来保存检测到的相同的值
        int duplicateValue = Integer.MIN_VALUE;
        while(cur != null){
            //更新重复值
            if(cur.next != null && cur.val == cur.next.val){
                duplicateValue = cur.val;
            }
            //删除重复节点
            if(cur.val == duplicateValue){
                cur = cur.next;
                pre.next = cur;
                continue;
            }
            //更新链表
            pre.next = cur;
            pre = pre.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
