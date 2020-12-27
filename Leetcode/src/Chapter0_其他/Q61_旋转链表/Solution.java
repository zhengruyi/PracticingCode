package Chapter0_其他.Q61_旋转链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 22:39
 **/

public class Solution {
    /**
     * 先将链表连接成环，再计算有效移动的步数，然后head指针指向头结点，end指针指向尾结点
     * 记得移动过后要将尾结点断开
     */
    ListNode end = null;
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        int size = getSize(head);
        //这里要记得用k - k % size,因为我们实际移动的是head指针，里面上应该移动end指针
        k = size - k % size;
        end.next = head;
        while(k > 0){
            end = end.next;
            head = head.next;
            k--;
        }
        end.next = null;
        return head;

    }

    /**
     * 获取链表总长度且找到末尾节点
     * @param head
     * @return
     */
    public int getSize(ListNode head){
        int size = 0;
        while(head != null){
            end = head;
            head = head.next;
            size++;
        }
        return size;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
