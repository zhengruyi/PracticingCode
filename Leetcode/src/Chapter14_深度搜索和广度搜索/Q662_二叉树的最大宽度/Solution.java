package Chapter14_深度搜索和广度搜索.Q662_二叉树的最大宽度;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/01/2021 20:53
 **/

public class Solution {
    int ans = 0;
    Map <Integer, Integer> map;

    /**
     * 这题的知识点就是标记子节点的位置，对于二叉树来说按0开始计算
     * 左子节点的值等于2 * i,右子节点的位置为2 * i + 1
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        map = new HashMap <>();
        dfs(root, 0, 0);
        return ans;
    }

    public void dfs(TreeNode root, int position, int depth) {
        if (root == null) {
            return;
        }
        //计算当前层的最左边界点位置
        map.computeIfAbsent(depth, x -> position);
        //更新最大宽度
        ans = Math.max(ans, position - map.get(depth) + 1);
        //递归带下一层，注意左右子节点的位置表示方法
        dfs(root.left, 2 * position, depth + 1);
        dfs(root.right, 2 * position + 1, depth + 1);
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