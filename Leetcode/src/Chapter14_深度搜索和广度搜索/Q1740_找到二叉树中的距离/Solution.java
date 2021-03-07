package Chapter14_深度搜索和广度搜索.Q1740_找到二叉树中的距离;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/03/2021 22:45
 **/

public class Solution {
    int dist = -1;
    public int findDistance(TreeNode root, int p, int q) {
        if(p == q){
            return 0;
        }
        dfs(root,p,q);
        return dist;
    }
    public int dfs(TreeNode root,int p, int q){
        if(root == null){
            return 0;
        }
        //从p或者q点到当前点的边的数目
        int left = dfs(root.left,p,q);
        int right = dfs(root.right,p,q);
        //说明当前点是最低公共祖先
        if(left != 0 && right != 0 && dist == -1){
            dist = left + right;
        }
        //左右子树中存在一个目标节点且当前点就是另外一个节点
        if((left != 0 || right != 0) && (root.val == p || root.val == q) && dist == -1){
            dist = left != 0 ? left : right;
        }
        //左右子树都不存在，检查当前点是否是目标节点之一
        if(left == 0 && right == 0){
            if(root.val == p || root.val == q){
                return 1;
            }else{
                return 0;
            }
        }
        //返回左右子树中不为0的那条边
        return left == 0 ?  right + 1 : left + 1;
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