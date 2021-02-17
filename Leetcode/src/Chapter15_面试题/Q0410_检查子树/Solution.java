package Chapter15_面试题.Q0410_检查子树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/02/2021 18:53
 **/

public class Solution {
    /**
     * 如果当前点和目标节点的值相等,那么就分别比较左右子树和目标子树是不是都相等
     * 如果和当前点的值不相等,那么查找左右子树是否存在目标子树
     * @param t1
     * @param t2
     * @return
     */
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(t2 == null){
            return true;
        }
        if(t1 == null){
            return false;
        }
        if(t1.val == t2.val){
            return checkSubTree(t1.left,t2.left) && checkSubTree(t1.right,t2.right);
        }else{
            return checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2);
        }
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}