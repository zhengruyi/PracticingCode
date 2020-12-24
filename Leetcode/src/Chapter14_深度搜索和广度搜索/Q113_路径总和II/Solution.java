package Chapter14_深度搜索和广度搜索.Q113_路径总和II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 00:46
 **/

public class Solution {
    /**
     * 由于这里固定好起始点和终点，所以深度优先搜索很好找
     */
    List<List <Integer>> res = new ArrayList <>();
    LinkedList <Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return res;
    }
    public void dfs(TreeNode root, int sum){
        if(root == null){
            return;
        }
        sum -= root.val;
        path.offerLast(root.val);
        if(root.left == null && root.right == null && sum == 0){
            res.add(new LinkedList<>(path));
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
        path.pollLast();
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
