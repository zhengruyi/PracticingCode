package Chapter14_深度搜索和广度搜索.Q993_二叉树的堂兄弟节点;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/04/2021 21:38
 **/

public class Solution {
    TreeNode parentX = null;
    TreeNode parentY = null;
    int depthX = -1;
    int depthY = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,0,x,y);
        return depthX == depthY && parentX != parentY;
    }

    /**
     * 简单的深度搜索,具体来说就是当子节点的值等于x或者y时，保存一下
     * x或者y的父节点和对应的深度,最后比较一下x和y的深度和对应的父节点是否一样来
     * 判断这两个节点是不是堂兄弟节点
     * @param root
     * @param depth
     * @param x
     * @param y
     */
    public void dfs(TreeNode root,int depth,int x, int y){
        if(root == null){
            return;
        }
        if((root.left != null && root.left.val == x) || (root.right != null && root.right.val == x)){
            parentX = root;
            depthX = depth + 1;
        }
        if((root.left != null && root.left.val == y) || (root.right != null && root.right.val == y)){
            parentY = root;
            depthY = depth + 1;
        }
        dfs(root.left, depth + 1,x,y);
        dfs(root.right,depth + 1,x,y);
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