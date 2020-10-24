package Chapter0_其他.Q25_K个一组翻转链表;


public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }
        int i = 1;
        ListNode tmp = head;
        while(i <= k){
            if(tmp == null ){
                return head;
            }
            tmp = tmp.next;
            i++;
        }
        //如果满足k个节点，则进行翻转
        ListNode newHead = reverse(head, tmp);
        //反转后，head为尾结点，而该函数返回的是新的头结点
        head.next = reverseKGroup(tmp,k);
        return newHead;
    }

    /**
     * 翻转链表函数，用来翻转【[head,end)部分的链表
     * @param head
     * @param end
     * @return
     */
    public ListNode reverse(ListNode head, ListNode end){
        ListNode curr = head;
        ListNode prev = null;
        ListNode nxt = head;
        //新的翻转函数，需要记得
        while(curr != end){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;

        }
        return prev;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }