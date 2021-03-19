package Q55_二叉树的深度;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/03/2021 23:33
 **/

public class Solution {
    /**
     * 简单的深度遍历
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return 1 + Math.max(left,right);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}