package Chapter15_面试题.Q0412_求和路劲;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/02/2021 23:40
 **/

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        //检查当前节点作为根节点是否能找到路径和等于目标
        //在加上左子树或者右子树上开始的搜索结果就是最终结果
        return dfs(root,sum) + pathSum(root.left,sum) + pathSum(root.right, sum);
    }
    public int dfs(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        //注意这里不能写 if(sum == 0) return 1,因为要的是路劲和,在sum = 0的情况下,就得不到正确的结果
        sum -= root.val;
        //在左右节点搜索可能的后续
        return (sum == 0 ? 1 : 0) + dfs(root.left,sum) + dfs(root.right,sum);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}