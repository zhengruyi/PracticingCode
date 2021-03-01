package Chapter14_深度搜索和广度搜索.Q536_从字符串生成二叉树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/03/2021 22:29
 **/

public class Solution {
    public TreeNode str2tree(String s) {
        if(s == null ||s.length() == 0){
            return null;
        }
        TreeNode root = new TreeNode(0);
        dfs(root,s,0);
        return root;
    }
    public int dfs(TreeNode root, String s, int i){
        int index = i;
        //将所有数字的字符串选中
        while(i < s.length() && ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '-')){
            i++;
        }
        //重新给这个节点赋值
        root.val = Integer.parseInt(s.substring(index,i));
        //递归处理左子节点
        if(i < s.length() && s.charAt(i) == '('){
            root.left = new TreeNode(0);
            i = dfs(root.left,s,i+1);
        }
        //递归处理右子节点
        if(i < s.length() && s.charAt(i) == '('){
            root.right = new TreeNode(0);
            i = dfs(root.right,s,i+1);
        }
        //避开所有的右括号
        if(i < s.length() && s.charAt(i) == ')'){
            return ++i;
        }
        return i;
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