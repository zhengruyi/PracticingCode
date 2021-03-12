package Chapter14_深度搜索和广度搜索.Q1145_二叉树着色游戏;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/03/2021 22:11
 **/

public class Solution {
    //用来记录着色点的左右子树
    TreeNode leftTree = null;
    TreeNode rightTree = null;
    int val;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        val = x;
        //找到着色的点
        dfs(root);
        //找出着色点的左子树的节点数目
        int left = dfs(leftTree);
        //找出着色点的右子树的节点数目
        int right = dfs(rightTree);
        //父节点所在的节点的连通分量的节点数目
        int parent = n - left - right - 1;
        List <Integer> list = Arrays.asList(left,right,parent);
        //如果三个连通分量中有一个它的节点数目大于总数目,那么第二人必胜
        for(int num : list){
            if(num > n /2){
                return true;
            }
        }
        return false;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        //获得左右子树的节点数目
        int left = dfs(root.left);
        int right = dfs(root.right);
        //找到涂颜色节点的左右子树
        if(root.val == val){
            leftTree = root.left;
            rightTree = root.right;
        }
        //返回以当前节点为根节点的树的总结点数目
        return left + right + 1;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}