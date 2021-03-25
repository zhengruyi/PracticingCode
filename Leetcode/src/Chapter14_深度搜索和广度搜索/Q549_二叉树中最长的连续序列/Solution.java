package Chapter14_深度搜索和广度搜索.Q549_二叉树中最长的连续序列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/03/2021 23:28
 **/

public class Solution {
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return res;
    }
    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        //表示左子树比自己大1的连续序列长度
        //和左子树中比自己小1的连续序列长度
        int leftInc = 1, leftDec = 1;
        if(root.left != null){
            int[] offsetLeft = dfs(root.left);
            //如果左子树的根节点比当前节点小1或者大1，那么可以刚好连接上,升序或者降序的长度加1
            leftInc = root.val - root.left.val == -1 ? offsetLeft[0] + 1 : leftInc;
            leftDec = root.val - root.left.val == 1 ?  offsetLeft[1] + 1 : leftDec;
        }
        //右子树相同
        int rightInc = 1, rightDec = 1;
        if(root.right != null){
            int[] offsetRight = dfs(root.right);
            rightInc = root.val - root.right.val == -1 ? offsetRight[0] + 1 : rightInc;
            rightDec = root.val - root.right.val == 1 ?  offsetRight[1] + 1 : rightDec;
        }
        //最长的序列长度等于左升右降，或者反过来的长度和,这里减去1是因为当前节点被计算了两次
        res = Math.max(res,Math.max(leftInc+rightDec - 1,leftDec+rightInc - 1));
        //选取左右子树的降序最长和升序最长返回上一层
        return new int[]{Math.max(leftInc,rightInc),Math.max(leftDec,rightDec)};
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