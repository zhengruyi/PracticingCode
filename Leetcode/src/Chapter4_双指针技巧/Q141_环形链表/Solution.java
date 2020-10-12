package Chapter4_双指针技巧.Q141_环形链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/10/2020 16:52
 **/

public class Solution {
    public boolean hasCycle(ListNode head) {
        //通过创建dummy node 来简化判断条件，可以避免当两节点成环造成的判断错误
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast != null && fast.next != null){
            if(fast == slow && fast != dummy){
                return true;
            }
            //快指针每次前进两步
            fast = fast.next.next;
            //慢指针每次前进一步
            slow = slow.next;
        }
        return false;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
