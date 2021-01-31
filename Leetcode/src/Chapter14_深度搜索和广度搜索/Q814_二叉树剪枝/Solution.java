package Chapter14_深度搜索和广度搜索.Q814_二叉树剪枝;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 31/01/2021 23:33
 **/

public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //获取剪枝后的左子树
        TreeNode left = pruneTree(root.left);
        //获取剪枝后的右子树
        TreeNode right = pruneTree(root.right);
        //如果左右子树都是Null且当前根节点也为0,那么返回null
        if (left == null && right == null && root.val == 0) {
            return null;
        }
        //拼接当前子树，返回结果
        root.left = left;
        root.right = right;
        return root;
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