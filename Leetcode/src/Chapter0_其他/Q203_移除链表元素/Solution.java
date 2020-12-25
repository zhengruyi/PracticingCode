package Chapter0_其他.Q203_移除链表元素;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 23:31
 **/

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode h1 = dummy;
        while(h1 != null && h1.next != null){
            if(h1.next.val == val){
                //删除元素后不能立刻后移可能会有多个元素连续需要删除的情况
                h1.next = h1.next.next;
            }else{
                h1 = h1.next;
            }
        }
        return dummy.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
