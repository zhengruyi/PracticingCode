package Chapter14_深度搜索和广度搜索.Q563_二叉树的坡度;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/01/2021 22:08
 **/

public class Solution {
    int res = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res += Math.abs(left - right);
        //将当前的总和最为父节点的左子树或者右子树和返回
        return root.val + left + right;
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