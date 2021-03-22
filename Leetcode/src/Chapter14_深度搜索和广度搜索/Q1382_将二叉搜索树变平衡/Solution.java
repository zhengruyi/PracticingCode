package Chapter14_深度搜索和广度搜索.Q1382_将二叉搜索树变平衡;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/03/2021 21:37
 **/

public class Solution {
    /**
     * 因为原来的树是二叉搜索树,所以可以直接中序遍历,得到一个有序数组,最后根据这个有序数组
     * 重新构建一个平衡的二叉搜索树
     * @param root
     * @return
     */
    public TreeNode balanceBST(TreeNode root) {
        List <Integer> inOrder = new ArrayList();
        dfs(root,inOrder);
        return buildTree(inOrder,0,inOrder.size() - 1);
    }

    /**
     * 深度遍历得到一个有序列表
     * @param root
     * @param path
     */
    public void dfs(TreeNode root, List<Integer> path){
        if(root == null){
            return;
        }
        dfs(root.left,path);
        path.add(root.val);
        dfs(root.right,path);
    }
    public TreeNode buildTree(List<Integer> in, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) /2;
        TreeNode root = new TreeNode(in.get(mid));
        //递归构建左边的子树
        root.left = buildTree(in,start,mid - 1);
        //递归构建右边的子树
        root.right = buildTree(in,mid + 1, end);
        return root;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}