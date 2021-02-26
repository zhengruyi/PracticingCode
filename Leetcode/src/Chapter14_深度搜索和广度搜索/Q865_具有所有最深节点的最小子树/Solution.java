package Chapter14_深度搜索和广度搜索.Q865_具有所有最深节点的最小子树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/02/2021 23:48
 **/

public class Solution {
    /**
     * 永远往最深的一边前进，当左右两边一样深时返回自己
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == right){
            return root;
        }else if(left < right){
            return subtreeWithAllDeepest(root.right);
        }else{
            return subtreeWithAllDeepest(root.left);
        }
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(dfs(root.left), dfs(root.right));
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