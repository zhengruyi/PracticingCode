package Q52_两个链表的第一个公共节点;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/01/2021 21:25
 **/

public class Solution {
    /**
     * 这里的方法是就是两个指针分别从两个链表开头往后递增，如果到达末尾那就保存
     * 最后的节点，然后从另外一个链表开头进行遍历，两者的终止节点不同则不存在
     * 相同的节点，不然第一次相遇的节点就是公共节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA != null ^ headB != null){
            return null;
        }
        ListNode end1 = null;
        ListNode end2 = null;
        ListNode h1 = headA;
        ListNode h2 = headB;
        while(h1 != h2){
            //保存终点然后切换开头
            if(h1.next == null){
                end1 = h1;
                h1 = headB;
            }else{
                h1 = h1.next;
            }

            if(h2.next == null){
                end2 = h2;
                h2 = headA;
            }else{
                h2 = h2.next;
            }
            //检查两个链表是否存在公共节点
            if(end1 != null && end2 != null && end1 != end2){
                return null;
            }
        }
        return h1;
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