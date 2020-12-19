package Chapter0_其他.Q83_删除排序链表中的重复元素;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/12/2020 23:21
 **/

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode h1 = head;
        while(h1 != null && h1.next != null){
            //采用删除后续节点的办法来消除重复的元素
            if(h1.next != null && h1.val == h1.next.val){
                h1.next = h1.next.next;
            }else{
                //两个节点元素值不一样，所以后退h1
                h1 = h1.next;
            }
        }
        return head;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
