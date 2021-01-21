package Q35_复杂链表的复制;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/01/2021 21:31
 **/

public class Solution {
    /**
     * 先把链表完全复制一遍在把链表的随机指针赋值
     * 注意处理随机指针可嗯呢该为Null的情况，最后
     * 再把链表拆分成相等的两部分，完成复制
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node dummy = new Node(-1);
        Node h = head;
        while(h != null){
            Node tmp = new Node(h.val);
            tmp.next = h.next;
            h.next = tmp;
            h = h.next.next;
        }
        h = head;
        while(h != null){
            if(h.random != null){
                h.next.random = h.random.next;
            }
            h = h.next.next;
        }
        h = head;
        Node tmp  = dummy;
        while(h != null){
            tmp.next = h.next;
            h.next = h.next.next;
            tmp = tmp.next;
            h = h.next;
        }
        return dummy.next;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}