package Chapter14_深度搜索和广度搜索.Q1214_查找两棵二叉搜索树之和;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/03/2021 23:01
 **/

public class Solution {
    /**
     * 二叉搜索树的性质，中序遍历得到一个有序列表
     * 然后两个指针进行搜索,检查是否存在满足条件的结果
     * @param root1
     * @param root2
     * @param target
     * @return
     */
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List <Integer> t1 = new ArrayList();
        List<Integer> t2 = new ArrayList();
        dfs(root1,t1);
        dfs(root2,t2);
        int i = 0, j = t2.size() - 1;
        while(i < t1.size() && j >= 0){
            if(t1.get(i) + t2.get(j) == target){
                return true;
            }else if(t1.get(i) + t2.get(j) < target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
    public void dfs(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
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