package Chapter13_二叉树.Q101_对称二叉树;

import Chapter13_二叉树.TreeNode;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/12/2020 22:57
 **/

public class SolutionRecursion {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }
}
