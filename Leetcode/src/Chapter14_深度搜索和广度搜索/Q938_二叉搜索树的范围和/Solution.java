package Chapter14_深度搜索和广度搜索.Q938_二叉搜索树的范围和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/02/2021 20:53
 **/

public class Solution {
    int res = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root,low,high);
        return res;
    }

    /**
     * 根据BST的特性进行优化,进行剪枝操作
     * @param root
     * @param low
     * @param high
     */
    public void dfs(TreeNode root, int low, int high){
        if(root == null){
            return ;
        }
        if(root.val > low){
            dfs(root.left,low,high);
        }
        if(root.val < high){
            dfs(root.right,low,high);
        }
        if(root.val >= low && root.val <= high){
            res += root.val;
        }
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