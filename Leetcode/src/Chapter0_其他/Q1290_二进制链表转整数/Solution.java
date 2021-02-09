package Chapter0_其他.Q1290_二进制链表转整数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/02/2021 21:23
 **/

public class Solution {
    /**
     * 简单的数字转换
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        int num = 0;
        while(head != null){
            num = num * 2 + head.val;
            head = head.next;
        }
        return num;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}