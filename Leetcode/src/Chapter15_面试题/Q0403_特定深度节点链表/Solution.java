package Chapter15_面试题.Q0403_特定深度节点链表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/01/2021 22:05
 **/

public class Solution {
    /**
     * 简单的广度遍历,每层采用这样的方法将同一高度的节点用链表串在一起
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        List <ListNode> res = new ArrayList <>();
        if (tree == null) {
            return res.toArray(new ListNode[0]);
        }
        Queue <TreeNode> queue = new LinkedList <>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode(-1);
            ListNode head = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                head.next = new ListNode(tmp.val);
                head = head.next;
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            res.add(dummy.next);
        }
        return res.toArray(new ListNode[0]);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}