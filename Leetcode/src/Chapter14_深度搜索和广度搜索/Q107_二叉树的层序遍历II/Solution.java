package Chapter14_深度搜索和广度搜索.Q107_二叉树的层序遍历II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/01/2021 21:53
 **/

public class Solution {
    /**
     * 逆序的方式主要就是采用linkedList的addFirst方法
     * @param root
     * @return
     */
    public List <List <Integer>> levelOrderBottom(TreeNode root) {
        LinkedList <List <Integer>> res = new LinkedList <>();
        if (root == null) {
            return res;
        }
        Queue <TreeNode> queue = new LinkedList <>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List <Integer> tmp = new ArrayList <>();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                tmp.add(t.val);
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            res.addFirst(tmp);
        }
        return res;
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