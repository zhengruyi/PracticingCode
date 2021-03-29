package Chapter14_深度搜索和广度搜索.Q110_平衡二叉树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/03/2021 18:48
 **/

public class Solution {
    boolean res = true;

    /**
     * 计算两边子树的高度,判断是否平衡
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(Math.abs(left - right) > 1){
            res = false;
        }
        return Math.max(left,right) + 1;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}