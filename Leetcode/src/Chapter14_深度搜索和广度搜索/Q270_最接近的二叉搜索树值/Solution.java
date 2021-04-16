package Chapter14_深度搜索和广度搜索.Q270_最接近的二叉搜索树值;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/04/2021 21:00
 **/

public class Solution {
    int res = 0;
    double gap = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        dfs(root,target);
        return res;
    }
    public void dfs(TreeNode root, double target){
        if(root == null){
            return;
        }
        if(Math.abs(root.val - target) < gap){
            res = root.val;
            gap = Math.abs(root.val - target);
        }
        if(root.val < target){
            dfs(root.right,target);
        }else if(root.val > target){
            dfs(root.left,target);
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