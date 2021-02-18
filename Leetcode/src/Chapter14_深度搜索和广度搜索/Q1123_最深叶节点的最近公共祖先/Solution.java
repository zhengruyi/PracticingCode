package Chapter14_深度搜索和广度搜索.Q1123_最深叶节点的最近公共祖先;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/02/2021 22:26
 **/

public class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null){
            return null;
        }
        //深度遍历返回左右子树的深度
        int left = dfs(root.left);
        int right = dfs(root.right);
        //如果左右子树一样深，那么当前节点就是答案
        if(left == right){
            return root;
            //左子树更深，那么答案在左子树上
        }else if( left > right){
            return lcaDeepestLeaves(root.left);
            //答案在右子树上
        }else{
            return lcaDeepestLeaves(root.right);
        }
    }

    /**
     * 深度遍历求树的深度
     * @param root
     * @return
     */
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