package Q68_二叉搜索树的最近公共祖先;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/03/2021 22:37
 **/

public class Solution {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        dfs(root,p,q);
        return res;
    }
    public int dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return 0;
        }
        //左子树中的pq数目
        int left = dfs(root.left, p, q);
        //右子树的pq数目
        int right = dfs(root.right, p, q);
        //当前节点是不是p或者q
        int mid = root == p || root == q ? 1 : 0;
        //找到第一个父节点
        if(left + right + mid >= 2 && res == null){
            res = root;
        }
        //返回总的数目
        return left + right + mid;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}