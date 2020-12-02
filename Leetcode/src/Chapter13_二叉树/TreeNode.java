package Chapter13_二叉树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/12/2020 22:31
 **/

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
