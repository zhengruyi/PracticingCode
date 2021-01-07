package Chapter15_面试题.Q0405_合法二叉搜索树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/01/2021 22:08
 **/

public class Solution {
    /**
     * BST有效的条件当前节点的值大于左边节点小于右边节点
     * 且所有子节点都满足条件,这里还有一个补充就是子树的最大值必须小于右子树的最小值
     * 所以在遍历子树时需要提供上下限
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return dfs(root,null,null);
    }
    public boolean dfs(TreeNode root, Integer lower, Integer upper){
        if(root == null){
            return true;
        }
        int val = root.val;
        if(lower != null && lower >= val){
            return false;
        }
        if(upper != null && upper <= val){
            return false;
        }
        if(!dfs(root.left,lower,val) || !dfs(root.right,val,upper)){
            return false;
        }
        return true;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}