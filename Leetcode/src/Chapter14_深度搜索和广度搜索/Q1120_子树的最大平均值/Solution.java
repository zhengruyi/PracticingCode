package Chapter14_深度搜索和广度搜索.Q1120_子树的最大平均值;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/04/2021 21:11
 **/

public class Solution {
    double max = 0.0;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return max;
    }

    /**
     * 返回的数组,第一个元素表示子节点的节点数目,
     * 第二个元素表示子树的所有节点的数字和
     * @param root
     * @return
     */
    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int sum = left[1] + right[1] + root.val;
        int num = left[0] + right[0] + 1;
        max = Math.max(max, sum  * 1.0 / num);
        return new int[]{num,sum};
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}