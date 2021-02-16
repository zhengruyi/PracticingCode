package Chapter14_深度搜索和广度搜索.Q1315_祖父节点值为偶数的节点和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/02/2021 23:14
 **/

public class Solution {
    int sum = 0;

    /**
     * 简单的深度搜索，难点在于要将祖父节点和父节点一起带入递归中求解
     * @param root
     * @return
     */
    public int sumEvenGrandparent(TreeNode root) {
        dfs(null,null,root);
        return sum;
    }
    public void dfs(TreeNode grandfather, TreeNode parent, TreeNode node){
        if(node == null){
            return;
        }
        if(grandfather != null && grandfather.val % 2 == 0){
            sum += node.val;
        }
        if(node.left != null){
            dfs(parent,node,node.left);
        }
        if(node.right != null){
            dfs(parent,node,node.right);
        }
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}