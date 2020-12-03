package Chapter13_二叉树.Q104_二叉树的最大深度;

import Chapter13_二叉树.TreeNode;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/12/2020 22:56
 **/

public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //最大深度等于左右子树的最大深度加上根节点
        return Math.max(left,right) + 1;
    }
}
