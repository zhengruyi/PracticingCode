package Chapter3_二叉树问题.Q13_判断二叉树是否为平衡二叉树;

import Chapter3_二叉树问题.Tree;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/06/2020 18:59
 **/

public class IsBalancedBinaryTree {
    public boolean isBalanced(Tree root){
        boolean[] res = new boolean[1];
        checked(root,res,0);
        return res[0];
    }
    public int checked(Tree root, boolean[] res, int level){
        if(root == null){
            return level;
        }
        //获取左侧节点数目
        int numLeft = checked(root.left,res,level+1);
        //如果左子树已经不是二叉平衡树则直接返回，返回的数字无意义
        if(!res[0]){
            return level;
        }
        //获取右侧节点数目
        int numRight = checked(root.right,res,level+1);
        //如果右子树已经不是二叉平衡树则直接返回，返回的数字无意义
        if(!res[0]){
            return level;
        }
        //如果左右子树的节点数目大于1则不是二叉平衡树
        if(Math.abs(numLeft - numRight) > 1){
            res[0] = false;
        }
        //返回当前左右子树中节点数目较大的那个
        return Math.max(numLeft,numRight);
    }
}
