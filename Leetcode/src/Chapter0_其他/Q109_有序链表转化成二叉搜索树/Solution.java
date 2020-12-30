package Chapter0_其他.Q109_有序链表转化成二叉搜索树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/12/2020 20:41
 **/

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return findMidi(head);
    }

    public TreeNode findMidi(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        //快慢指针找到中点，其中pre节点指向slow前一个节点
        ListNode pre = head;
        ListNode fast = head;
        ListNode slow = head;
        //获取链表的中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        //构造根节点
        TreeNode root = new TreeNode(slow.val);
        //将pre指向的节点断开，左边链表递归构成右子树
        pre.next = null;
        root.left = findMidi(head);
        //右边链表构成右子树
        root.right = findMidi(slow.next);
        return root;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}