package Chapter14_深度搜索和广度搜索.Q285_二叉搜索树中的顺序后继;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/02/2021 23:06
 **/

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        //如果有右子节点,那么后继节点就是右子树的最左子节点
        if(p.right != null){
            TreeNode tmp = p.right;
            while(tmp.left != null){
                tmp = tmp.left;
            }
            res = tmp;
        }else{
            //如果不存在，那么后记节点在往上递归中，当当前节点是父节点的左子节点时，父节点就是后继节点
            for(TreeNode t = root; t != p;){
                if(t.val > p.val){
                    res = t;
                    t = t.left;
                }else{
                    t = t.right;
                }
            }
        }
        return res;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}