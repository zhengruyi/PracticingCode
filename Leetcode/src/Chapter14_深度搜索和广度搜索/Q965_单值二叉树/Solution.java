package Chapter14_深度搜索和广度搜索.Q965_单值二叉树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/04/2021 19:27
 **/

public class Solution {
    boolean res = true;
    Integer lastVal = null;
    public boolean isUnivalTree(TreeNode root) {
        dfs(root);
        return res;
    }

    /**
     * 简单的深度搜索
     * @param root
     */
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        if(lastVal == null){
            lastVal = root.val;
        }
        if(root.val != lastVal){
            res = false;
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}