package Chapter14_深度搜索和广度搜索.Q669_修剪二叉搜索树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/02/2021 22:36
 **/

public class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return dfs(root,low,high);
    }
    public TreeNode dfs(TreeNode root, int low, int high){
        if(root == null){
            return null;
        }
        /**
         * 根据数字的大小组建子树，层层往上构建
         */
        TreeNode left = dfs(root.left, low, high);
        TreeNode right = dfs(root.right, low, high);
        if(root.val <= high && root.val >= low){
            root.left = left;
            root.right = right;
            return root;
        }else if(left != null){
            return left;
        }else{
            return right;
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