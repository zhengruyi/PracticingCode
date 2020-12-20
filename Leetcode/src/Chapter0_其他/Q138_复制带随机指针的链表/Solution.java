package Chapter0_其他.Q138_复制带随机指针的链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/12/2020 23:09
 **/

public class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node h1 = head;
        //先将单个节点复制一倍，挂在对应的节点后
        while(h1 != null){
            Node tmp = new Node(h1.val);
            tmp.next = h1.next;
            h1.next = tmp;
            h1 = h1.next.next;
        }
        //将每个节点的随机指针正确赋值
        h1 = head;
        while(h1 != null){
            if(h1.random != null){
                h1.next.random = h1.random.next;
            }
            h1 = h1.next.next;
        }
        //将原来复制过后的链表拆分成单独两个链表
        Node dummy = new Node(-1);
        Node h2 = dummy;
        h1 = head;
        while(h1 != null){
            h2.next = h1.next;
            h2 = h2.next;
            h1.next = h1.next.next;
            h1 = h1.next;
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
