package Chapter14_深度搜索和广度搜索.Q437_路径总和III;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/12/2020 20:33
 **/

public class Solution {
    HashMap <Integer,Integer> prefixSum = new HashMap<>();
    public int pathSum(TreeNode root, int sum) {
        //记录第一次路劲和等于目标值时能统计进去
        prefixSum.put(0,1);
        return dfs(root,0,sum);
    }

    /**
     * 整体思路就是在深度搜索中使用前缀和来判断是否中间路径的区间和
     * 等于目标值，用hashmap来保存相同值的出现次数
     * @param root
     * @param currSum
     * @param target
     * @return
     */
    public int dfs(TreeNode root, int currSum, int target){
        if(root == null){
            return 0;
        }
        int res = 0;
        //计算前缀和
        currSum += root.val;
        //查找区间和是否等于目标值
        res+= prefixSum.getOrDefault(currSum - target, 0);
        //更新出现次数
        prefixSum.put(currSum,prefixSum.getOrDefault(currSum,0)+1);
        //递归索引下层节点
        res += dfs(root.left,currSum,target);
        res += dfs(root.right,currSum,target);
        //回溯返回后，更新出现次数
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
        return res;
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