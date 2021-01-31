package Chapter14_深度搜索和广度搜索.Q1038_把二叉搜索树转换为累加树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 31/01/2021 23:35
 **/

public class Solution {
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return root;
        }
        dfs(root, 0);
        return root;
    }

    public int dfs(TreeNode root, int sum) {
        //为了把sum返回出去，所以在Null时返回sum
        if (root == null) {
            return sum;
        }
        //由于只考虑大于当前节点的值，所以采用先右子树在根节点在左子树的遍历方式
        sum = dfs(root.right, sum);
        root.val = root.val + sum;
        int left = dfs(root.left, root.val);
        return left;
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