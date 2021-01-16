package Chapter14_深度搜索和广度搜索.Q404_左叶子之和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/01/2021 20:52
 **/

public class Solution {
    int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root.left, true);
        dfs(root.right, false);
        return ans;
    }

    /**
     * 通过布尔值来判断是否是左叶子节点,true表示左子树，false表示右叶子节点
     * @param root
     * @param isLeft
     */
    public void dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && isLeft) {
            ans += root.val;
            return;
        }
        dfs(root.left, true);
        dfs(root.right, false);
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