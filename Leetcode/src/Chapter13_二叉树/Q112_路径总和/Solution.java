package Chapter13_二叉树.Q112_路径总和;

import Chapter13_二叉树.TreeNode;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/12/2020 23:02
 **/

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == sum;
        }

        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}
