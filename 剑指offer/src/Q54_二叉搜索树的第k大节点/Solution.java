package Q54_二叉搜索树的第k大节点;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/03/2021 23:17
 **/

public class Solution {
    int res = -1;
    int count = 0;

    /**
     * 二叉搜索树的后序遍历就是一个递减序列,讲述一个变量用来统计数字就可以
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }
    public void dfs(TreeNode root, int k){
        if(root == null){
            return;
        }
        dfs(root.right,k);
        count++;
        if(count == k){
            res = root.val;
        }
        dfs(root.left,k);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}