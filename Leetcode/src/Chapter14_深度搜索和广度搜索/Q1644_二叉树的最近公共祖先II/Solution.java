package Chapter14_深度搜索和广度搜索.Q1644_二叉树的最近公共祖先II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/02/2021 23:05
 **/

public class Solution {
    TreeNode parent = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return parent;
    }
    public boolean dfs(TreeNode root,TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        //检查左子树是否有p或者q中的一个
        boolean left = dfs(root.left, p, q);
        //检查右子树中是否有p或者q中的一个
        boolean right = dfs(root.right, p, q);
        //如果pq都满足，且parent不存在,那么赋值一个答案
        if(left && right){
            if(parent == null){
                parent = root;
            }
            //检查是否左右子树中存在一个，当前节点也存在另一个
        }else if(left && (root.val == p.val || root.val == q.val)){
            parent = root;
            //检查是否左右子树中存在一个，当前节点也存在另一个
        }else if(right && (root.val == p.val || root.val == q.val)){
            parent = root;
        }
        //检查以当前节点为根节点的子树是否保存一个数值
        return root.val == p.val || root.val == q.val || left || right;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}