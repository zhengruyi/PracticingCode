package Chapter14_深度搜索和广度搜索.Q687_最长等值路径;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/12/2020 22:37
 **/

public class Solution {
    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //计算左子树等值路径
        int left = dfs(root.left);
        //计算右子树等值路径
        int right = dfs(root.right);
        int rootLeft = 0;
        int rootRight = 0;
        //如果当前节点值等于左侧节点值，那么左边路径长度加1
        if (root.left != null && root.val == root.left.val) {
            rootLeft += left + 1;
        }
        //如果当前节点值等于右侧节点值，那么右边路径长度加1
        if (root.right != null && root.val == root.right.val) {
            rootRight += right + 1;
        }
        //总路径长度等于左右路径长度之和
        ans = Math.max(ans, rootLeft + rootRight);
        //当前节点作为子节点，只能取左右路径中的最大值
        return Math.max(rootLeft, rootRight);
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
