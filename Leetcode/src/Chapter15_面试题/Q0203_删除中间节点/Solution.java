package Chapter15_面试题.Q0203_删除中间节点;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/01/2021 23:15
 **/

public class Solution {
    /**
     * 将下一个节点的值复制给自己，然后删除下一个节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}