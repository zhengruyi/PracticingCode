package Chapter0_其他.Q1669_合并两个链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/02/2021 23:14
 **/

public class Solution {
    /**
     * 简单的链表拼接操作
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list1Begin = null;
        ListNode list1End = null;
        int i = 0;
        ListNode l1 = list1;
        while(l1 != null){
            if(i == a - 1){
                list1Begin = l1;
            }
            if(i == b + 1){
                list1End = l1;
                break;
            }
            i++;
            l1 = l1.next;
        }
        ListNode l2 = list2;
        ListNode list2End = null;
        while(l2.next != null){
            l2 = l2.next;
        }
        list1Begin.next = list2;
        l2.next = list1End;
        return list1;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}