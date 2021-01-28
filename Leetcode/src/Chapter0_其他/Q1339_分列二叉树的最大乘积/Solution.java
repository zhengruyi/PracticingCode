package Chapter0_其他.Q1339_分列二叉树的最大乘积;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/01/2021 23:09
 **/

public class Solution {
    Map <TreeNode,Long> map;
    long max = 0;
    public int maxProduct(TreeNode root) {
        map = new HashMap <>();
        long sum = dfs(root);
        //因为去掉一边后会把原来的树分成两颗子树
        //那么两个子树的和分别是 v 和sum - v
        //遍历所有的子树来获取全局最大值
        for(TreeNode t : map.keySet()){
            long v = map.get(t);
            max = Math.max(max, (sum-v) * v);
        }
        return (int)(max % 1_000_000_007);
    }

    /**
     * 深度搜索用来返回以当前节点为根节点的子树上所有值的和
     * @param root
     * @return
     */
    public long dfs(TreeNode root){
        if(root == null){
            return 0L;
        }
        long left = dfs(root.left);
        long right = dfs(root.right);
        map.put(root,root.val+left+right);
        return root.val + left + right;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}