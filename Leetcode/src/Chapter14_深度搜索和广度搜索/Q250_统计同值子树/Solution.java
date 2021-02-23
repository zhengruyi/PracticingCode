package Chapter14_深度搜索和广度搜索.Q250_统计同值子树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/02/2021 23:41
 **/

public class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return count;
    }
    public boolean dfs(TreeNode node){
        //当前不存在子树,那么当前节点就是有重复值的子树
        if(node.left == null && node.right == null){
            count++;
            return true;
        }
        boolean flag = true;
        //检查左子树是不是重复子树且值和自己相同
        if(node.left != null){
            flag = dfs(node.left)  && node.left.val == node.val && flag;
        }
        ////检查右子树是不是重复子树且值和自己相同
        if(node.right != null){
            flag = dfs(node.right) && node.right.val == node.val && flag;
        }
        if(!flag){
            return false;
        }
        //当前节点是一个重复值子树
        count++;
        return true;
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