package Chapter4_双指针技巧.Q160_相交链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/12/2020 23:35
 **/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode h1 = headA;
        ListNode h2 = headB;
        int min = Integer.MIN_VALUE;
        int endA = min;
        int endB = min;
        while(h1 != h2){
            //h1从链表A开始跑，跑到尽头时记录下终点的值然后在从链表B开始跑
            if(h1.next == null){
                endA = h1.val;
                h1 = headB;
            }else{
                h1 = h1.next;
            }
            //h2从链表B开始跑，跑到尽头时记录下终点的值然后在从链表A开始跑
            if(h2.next == null){
                endB = h2.val;
                h2 = headA;
            }else{
                h2 = h2.next;
            }
            //如果两个人跑到终点记录下的值不一样，代表两个链表没有相交，所以返回null
            if(endA != min && endB != min && endA != endB){
                break;
            }
        }
        //如果链表是相交的，那么h1和h2相遇的节点就一定是第一个相交的节点
        return endA == endB ? h1 : null;
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