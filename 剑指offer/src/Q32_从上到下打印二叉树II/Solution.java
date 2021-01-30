package Q32_从上到下打印二叉树II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/01/2021 21:34
 **/

public class Solution {
    /**
     * 简单的广度遍历
     * @param root
     * @return
     */
    public List <List <Integer>> levelOrder(TreeNode root) {
        List <List <Integer>> res = new ArrayList <>();
        if (root == null) {
            return res;
        }
        Queue <TreeNode> queue = new LinkedList <>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List <Integer> tmp = new ArrayList <>();
            for (int i = 0; i < size; i++) {
                TreeNode tree = queue.poll();
                tmp.add(tree.val);
                if (tree.left != null) {
                    queue.offer(tree.left);
                }
                if (tree.right != null) {
                    queue.offer(tree.right);
                }
            }
            res.add(tmp);
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