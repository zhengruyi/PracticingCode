package Chapter15_面试题.Q0404_检查平衡性;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/01/2021 22:39
 **/

public class Solution {
    //全局变量用来表示结果
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        //计算左右子树的节点高度
        int left = dfs(root.left);
        int right = dfs(root.right);
        //如果高度差大于1，那么就不是平衡二叉树，所以赋值成false
        if(Math.abs(left - right) > 1){
            ans = false;
        }
        //选左右子树中最高的一颗在加上1
        return Math.max(left,right) + 1;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
