package Chapter14_深度搜索和广度搜索.Q1530_好叶子节点对的数量;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/03/2021 22:27
 **/

public class Solution {
    int res = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return res;
    }

    /**
     * 返货左右子树中的叶子节点到当前节点的距离
     * @param root
     * @param distance
     * @return
     */
    public List <Integer> dfs(TreeNode root, int distance){
        //返回空的列表
        if(root == null){
            return new ArrayList();
        }
        //返回只有1的列表
        if(root.left == null && root.right == null){
            return Arrays.asList(1);
        }
        //返回给上一层节点的列表
        List<Integer> next = new ArrayList();
        //获取左子树的叶子节点到当前节点的距离
        List<Integer> left = dfs(root.left, distance);
        //过滤掉加1后超出最大距离的节点
        for(int item : left){
            if(++item <= distance){
                next.add(item);
            }
        }
        //右子树同样操作
        List<Integer> right = dfs(root.right,distance);
        for(int item : right){
            if(++item <= distance){
                next.add(item);
            }
        }
        //统计好叶子节点对数目
        for(int l : left){
            for(int r : right){
                if(l + r <= distance){
                    res ++;
                }
            }
        }
        return next;
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