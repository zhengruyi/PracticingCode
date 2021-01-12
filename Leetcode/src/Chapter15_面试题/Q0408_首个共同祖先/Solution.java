package Chapter15_面试题.Q0408_首个共同祖先;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/01/2021 19:19
 **/

public class Solution {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return res;
    }

    /**
     * 主要检测两个目标节点是否走在子树上或者其中一个在，另外一个是自己
     * 一共三种情况，分别讨论就行
     * @param root
     * @param p
     * @param q
     * @return
     */
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        //分别搜索左右子树
        boolean isLeft = dfs(root.left,p,q);
        boolean isRight = dfs(root.right,p,q);
        //两个节点分别在左右子树上，另外一种情况是其中一个节点在子树上而另外一个节点是自己
        if((isLeft && isRight) || ((root.val == p.val || root.val == q.val) && (isLeft || isRight))){
            res = root;
        }
        //只要由一个节点在左子树，右子树或者是当前节点就返回true
        return isLeft || isRight || root.val == p.val || root.val == q.val;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}