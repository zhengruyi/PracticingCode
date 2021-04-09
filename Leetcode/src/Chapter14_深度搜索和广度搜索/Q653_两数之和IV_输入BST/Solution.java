package Chapter14_深度搜索和广度搜索.Q653_两数之和IV_输入BST;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/04/2021 22:18
 **/

public class Solution {
    List <Integer> list;

    /**
     * 先用中序遍历将BST转化成有序序列,最后采用双指针来搜索是否有两个数字等于目标数字
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        list = new ArrayList();
        dfs(root);
        int i = 0, j = list.size() - 1;
        while(i < j){
            if(list.get(i) + list.get(j) > k){
                j--;
            }else if(list.get(i) + list.get(j) < k){
                i++;
            }else{
                return true;
            }
        }
        return false;

    }
    public void dfs(TreeNode root){
        if(root == null){
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