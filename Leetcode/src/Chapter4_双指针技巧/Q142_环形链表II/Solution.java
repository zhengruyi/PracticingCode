package Chapter4_双指针技巧.Q142_环形链表II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/10/2020 16:55
 **/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        ListNode meet = null;
        //通过快慢指针找到相遇的节点
        while(fast != null && fast.next != null){
            if(fast == slow && fast != dummy){
                meet = fast;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果没有相遇节点，说明不成环，直接返回
        if(meet == null){
            return null;
        }
        //然后通过两个慢节点一个从起始点出发一个从相遇点出发，每次各走一步，再次相遇的节点就是链表环的起始点
        slow = dummy;
        while(slow != meet){
            slow = slow.next;
            meet = meet.next;
        }
        return meet;
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

