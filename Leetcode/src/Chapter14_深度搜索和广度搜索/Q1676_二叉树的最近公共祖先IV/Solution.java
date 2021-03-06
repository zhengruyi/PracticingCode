package Chapter14_深度搜索和广度搜索.Q1676_二叉树的最近公共祖先IV;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/03/2021 22:52
 **/

public class Solution {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Arrays.sort(nodes,(o1, o2)-> o1.val - o2.val);
        dfs(root,nodes);
        return res;
    }
    public int dfs(TreeNode root,TreeNode[] nodes){
        if(root == null){
            return 0;
        }
        //左子树找到几个在node里面的元素
        int left = dfs(root.left,nodes);
        //当前节点是否在nodes里面
        int mid = binarySearch(nodes,root.val) >= 0 ? 1 : 0;
        //右子树里面有几个在nodes里面的元素
        int right = dfs(root.right,nodes);
        int sum = left + mid + right;
        //当前所有nodes节点都找到且最近公共节点还没有被赋值时,当前root就是答案
        if(sum == nodes.length && res == null){
            res = root;
        }
        return sum;
    }
    public int binarySearch(TreeNode[] nodes, int val){
        int left = 0, right = nodes.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nodes[mid].val == val){
                return mid;
            }else if(nodes[mid].val < val){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}