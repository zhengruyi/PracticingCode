package Q25_合并两个有序链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/01/2021 23:55
 **/

public class Solution {
    /**
     * 基础中的基础
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode d = dummy;
        while(h1 != null || h2 != null){
            ListNode tmp = null;
            if(h1 == null){
                tmp = h2;
                h2 = h2.next;
            }else if(h2 == null){
                tmp = h1;
                h1 = h1.next;
            }else{
                if(h1.val < h2.val){
                    tmp = h1;
                    h1 = h1.next;
                }else{
                    tmp = h2;
                    h2 = h2.next;
                }
            }
            d.next = tmp;
            d = tmp;
        }
        return dummy.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}