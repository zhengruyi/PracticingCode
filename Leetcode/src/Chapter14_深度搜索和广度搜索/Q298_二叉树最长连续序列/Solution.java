package Chapter14_深度搜索和广度搜索.Q298_二叉树最长连续序列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/02/2021 17:46
 **/

public class Solution {
    int maxLength = 1;

    /**
     * 深度遍历,以将当前值存入,去查看是否有子节点的值等于父节点的值加1，如果有就将总长度加1,不然就就将长度赋值成1
     * 用全局变量来保存最长的连续递增子序列
     * @param root
     * @return
     */
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root,null,1);
        return maxLength;
    }
    public void dfs(TreeNode node, TreeNode parent, int len){
        if(node == null){
            return;
        }
        if(parent != null && node.val == parent.val + 1){
            len += 1;
            maxLength = Math.max(maxLength, len);
        }else{
            len = 1;
        }
        dfs(node.left,node,len);
        dfs(node.right,node,len);
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