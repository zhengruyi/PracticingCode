package Chapter14_深度搜索和广度搜索.Q951_翻转等价二叉树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/01/2021 23:48
 **/

public class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        //同一棵树不用翻转
        if (root1 == root2) {
            return true;
        }
        //其中一方为Null或者两者的根节点值不等
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        //两者可能的匹配路径:原样匹配和翻转后的匹配
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
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