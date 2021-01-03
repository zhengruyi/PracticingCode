package Chapter14_深度搜索和广度搜索.Q1372_二叉树中的最长交错路径;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/01/2021 22:42
 **/

public class Solution {
    int res;
    public int longestZigZag(TreeNode root) {
        res = 0;
        //用false来表示父节点到目前节点是左方向,true表示为右方向
        //由于根节点没有父节点所以这里是0
        dfs(root,0,false);
        dfs(root,0,true);
        return res;
    }
    public void dfs(TreeNode root, int len, boolean dir){
        //更新最长路劲
        res = Math.max(res, len);
        //根据父节点到目前节点的方向来进行下一步操作
        //如果是左方向，那么下一步就要走右边,len +1
        //或者继续走左方向,但是len必须重新就算,为1
        if(!dir){
            if(root.right != null){
                dfs(root.right,len+1,true);
            }
            if(root.left != null){
                dfs(root.left,1,false);
            }
        }else{
            if(root.left != null){
                dfs(root.left,len+1,false);
            }
            if(root.right != null){
                dfs(root.right,1,true);
            }
        }
    }
}
class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;
    TreeNode(int x) { val = x; }
}