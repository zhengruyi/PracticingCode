package Chapter14_深度搜索和广度搜索.Q783_二叉搜索树节点最小距离;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/04/2021 21:43
 **/

public class Solution {
    List <Integer> list;

    /**
     * 二叉搜索树的中序遍历是一个有序序列
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        list = new ArrayList();
        dfs(root);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size() - 1; i++){
            min = Math.min(min,list.get(i+1) - list.get(i));
        }
        return min;
    }
    public void dfs(TreeNode root){
        if(root ==  null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}