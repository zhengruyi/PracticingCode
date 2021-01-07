package Chapter0_其他.Q86_分隔链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/01/2021 22:04
 **/

public class Solution {
    /**
     * 本题的解释就是用两个虚拟节点把链表划分成两部分然后合并到一起
     * 唯一需要注意的就是需用l.next = null 和 g.next = null
     * 不然会出现链表的环
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null ){
            return null;
        }
        ListNode less = new ListNode(-1);
        ListNode l = less;
        ListNode greater = new ListNode(-1);
        ListNode g = greater;
        while(head != null){
            if(head.val < x){
                l.next = head;
                l = l.next;
            }else{
                g.next = head;
                g = g.next;
            }
            head = head.next;
            l.next = null;
            g.next = null;
        }
        l.next = greater.next;
        return less.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}