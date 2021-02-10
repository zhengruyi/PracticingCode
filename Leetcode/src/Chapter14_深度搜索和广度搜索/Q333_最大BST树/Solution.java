package Chapter14_深度搜索和广度搜索.Q333_最大BST树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/02/2021 20:36
 **/

public class Solution {
    int res = 0;

    /**
     * BST的定义是根节点的值大于左子树的最大值且小于右子树的最小值，左右子树也都是BST树
     * 这里采用一个新的类包含以这个节点为根节点的BST树有多少个节点且这颗BST树的最小值和最大值
     * @param root
     * @return
     */
    public int largestBSTSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return res;
    }
    public Node dfs(TreeNode root){
        //说明当前节点是叶子节点,则该节点是BST,节点数目是1,且值的最小和最大值分别就是根节点的值
        if(root.left == null && root.right == null){
            res = Math.max(res,1);
            return new Node(root.val,root.val,1);
        }
        //以当前节点值为根节点值且左右子树构成的树是不是BST，默认是true
        boolean check = true;
        int size = 1;
        int min = root.val;
        int max = root.val;
        //当前节点的左子节点的值不是0,那么统计左子节点的为根节点的BST的最小值和最大值
        if(root.left != null){
            Node left = dfs(root.left);
            //更新全局最小值
            if(left.size != -1 && root.val > left.max){
                size += left.size;
                min = left.min;
            }else{
                check = false;
            }
        }
        //当前节点的右子节点的值不是null,那么统计右子节点的为根节点的BST的最小值和最大值
        if(root.right != null){
            Node right = dfs(root.right);
            //更新全局最大值
            if(right.size != -1 && root.val < right.min){
                size += right.size;
                max = right.max;
            }else{
                check = false;
            }
        }
        //如果以当前节点为根节点,左右子树构成的树是BST,那么就返回最小值，最大值和节点数目
        if(check){
            res = Math.max(size,res);
            return new Node(min,max,size);
        }
        //如果不是BST,那么所有值都赋值成-1
        return new Node(-1,-1,-1);
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
class Node{
    public int min;
    public int max;
    public int size;
    public Node(int min, int max, int size){
        this.max = max;
        this.min = min;
        this.size = size;
    }
}