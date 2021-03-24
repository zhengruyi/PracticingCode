package Chapter14_深度搜索和广度搜索.Q1026_节点与其祖先之间的最大差值;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/03/2021 23:50
 **/

public class Solution {
    int res = 0;

    /**
     * 沿途保存路径上的最大最小值就可以了
     * @param root
     * @return
     */
    public int maxAncestorDiff(TreeNode root) {
        dfs(root,root.val, root.val);
        return res;
    }
    public void dfs(TreeNode root, int min, int max){
        if(root == null){
            return;
        }
        int gap = Math.max(Math.abs(root.val - min),Math.abs(max - root.val));
        res = Math.max(res,gap);
        dfs(root.left, Math.min(min,root.val),Math.max(max,root.val));
        dfs(root.right, Math.min(min,root.val),Math.max(max,root.val));
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