package Chapter14_深度搜索和广度搜索.Q235_二叉搜索树的最近公共祖先;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/02/2021 23:14
 **/

public class Solution {
    /**
     * 查看左右子树的情况
     */
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return res;
    }
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        boolean left = dfs(root.left,p,q);
        boolean right = dfs(root.right,p,q);
        if(left && right && res == null){
            res = root;
        }
        if(left && (root.val == p.val || root.val == q.val)){
            res = root;
        }
        if(right && (root.val == p.val || root.val == q.val)){
            res = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }