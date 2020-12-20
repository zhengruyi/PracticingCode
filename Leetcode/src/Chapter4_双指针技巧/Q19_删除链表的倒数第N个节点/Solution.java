package Chapter4_双指针技巧.Q19_删除链表的倒数第N个节点;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/12/2020 23:04
 **/

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int offset = 0;
        //创建虚拟节点，是为了方便删除头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //快慢指针，快指针提前走n步
        ListNode fast = dummy;
        ListNode slow = dummy;
        //快指针先走n步，每走一步offset加1
        while(fast.next != null && offset < n){
            fast = fast.next;
            offset++;
        }
        //快慢指针同时走，快指针到达末尾时，慢指针正好指向要删除节点的前一个节点
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //只有在offset == n时，才能删除节点,如果offset != n则表示n大于链表长度，此时什么都不做
        if(offset == n){
            slow.next = slow.next.next;
        }
        return dummy.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
