package Chapter14_深度搜索和广度搜索.Q965_单值二叉树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/04/2021 19:27
 **/

public class Solution {
    //二叉树上是否只有一个值
    boolean res = true;
    //节点值的全局变量
    Integer lastVal = null;
    public boolean isUnivalTree(TreeNode root) {
        dfs(root);
        return res;
    }

    /**
     * 简单的深度搜索,通过记忆全局的节点的值来判断一棵树上是否有多个不同的值
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