package Chapter14_深度搜索和广度搜索.Q1448_统计二叉树中好节点的数目;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/03/2021 22:19
 **/

public class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return count;
    }

    /**
     * 检录遍历路径上的最大值,从而计算好节点的数目
     * @param root
     * @param max
     */
    public void dfs(TreeNode root, int max){
        if(root == null){
            return;
        }
        if(root.val >= max){
            count++;
            max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right,max);
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