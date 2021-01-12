package Chapter14_深度搜索和广度搜索.Q1325_删除给定值的叶子节点;

/**
@author Ruyi ZHENG
@version 1.00
@time 12/01/2021 19:55
 **/

public class Solution {
    /**
     * 第一点，对于对象时赋值，所以我们在遍历过程中自己重新构成一棵树
     * 并且返回根节点
     * @param root
     * @param target
     * @return
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        //返回左子节点
        TreeNode left = removeLeafNodes(root.left, target);
        //返回右子节点
        TreeNode right = removeLeafNodes(root.right, target);
        //构建子树
        root.left = left;
        root.right = right;
        //检查更新完子树后当前节点是不是叶子节点且值等于target
        if (left == null && right == null && root.val == target) {
            return null;
        }
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