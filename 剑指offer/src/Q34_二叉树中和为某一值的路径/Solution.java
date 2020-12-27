package Q34_二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 22:36
 **/

public class Solution {
    List<List <Integer>> res = new ArrayList <>();
    List<Integer> path = new ArrayList<>();

    /**
     * 深度搜索，保存当前节点或者当前子节点应该为的某一个值,
     * 当且仅当前节点为叶子节点且值等于sum时才将结果保存在结果集中
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return res;
        }
        dfs(root,sum);
        return res;
    }
    public void dfs(TreeNode root, int sum){
        if(root.left == null && root.right == null && sum == root.val){
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size() -1);
            return;
        }
        path.add(root.val);
        if(root.left != null){
            dfs(root.left, sum - root.val);
        }
        if(root.right != null){
            dfs(root.right, sum - root.val);
        }
        path.remove(path.size() -1);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
