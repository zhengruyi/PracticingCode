package Chapter13_二叉树.Q236_二叉树的最近公共祖先;

import Chapter13_二叉树.TreeNode;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/12/2020 22:19
 **/

public class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        //搜索左子树和右子树，只要左右子树中存在一个p或q节点，就会返回true
        boolean hasLeft = dfs(root.left,p,q);
        boolean hasRight = dfs(root.right,p,q);
        //满足两个条件时可以赋值，比如左右节点都返回true
        //或者左右子树中有一个返回true,且当前节点的值正好等于另外一个要寻找的节点
        if((hasLeft && hasRight) || ((p.val == root.val || q.val == root.val)&&(hasRight ||hasLeft))){
            ans = root;
        }
        //当左右子树中包含一个目标节点，或者当前节点就是所求的节点时,返回true
        return hasLeft || hasRight || p.val == root.val || q.val == root.val;
    }
}
