package Chapter14_深度搜索和广度搜索.Q979_在二叉树中分配硬币;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/03/2021 23:37
 **/

public class Solution {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        //左边需要的硬币数目
        int left = dfs(root.left);
        //右边需要的数目
        int right = dfs(root.right);
        //从当前节点出发需要的移动数目
        res += Math.abs(left) + Math.abs(right);
        //当前节点需要父节点提供的数目，-1是因为自己要留一个
        return root.val + left + right - 1;
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