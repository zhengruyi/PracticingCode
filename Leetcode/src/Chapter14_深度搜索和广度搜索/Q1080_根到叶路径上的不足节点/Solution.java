package Chapter14_深度搜索和广度搜索.Q1080_根到叶路径上的不足节点;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/02/2021 23:27
 **/

public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root == null){
            return null;
        }
        //如果当前节点时叶子节点
        if(root.left == null && root.right == null){
            //如果这条路径不会满足最小值就返回Null表示删除这个叶子节点
            if(root.val < limit){
                return null;
            }
            //满足条件就返回节点本身，这很重要
            return root;
        }
        //递归处理左右子树
        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right,limit - root.val);
        //如果左右子树都被删除,那么当前节点也会被删除
        if(root.left == null && root.right == null){
            return null;
        }
        return root;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}