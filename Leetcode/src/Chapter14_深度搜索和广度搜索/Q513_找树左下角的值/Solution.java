package Chapter14_深度搜索和广度搜索.Q513_找树左下角的值;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/01/2021 21:37
 **/

public class Solution {
    /**
     * 简单的广度遍历，每次遍历开始时保存一下值，然后如果当前轮遍历完
     * 任然队列为空，说明当前curr的值就是左下角的值，否则即继续下一轮遍历
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue <TreeNode> queue = new LinkedList <>();
        int curr = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (i == 0) {
                    curr = t.val;
                }
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            if (queue.size() == 0) {
                return curr;
            }
        }
        return curr;
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