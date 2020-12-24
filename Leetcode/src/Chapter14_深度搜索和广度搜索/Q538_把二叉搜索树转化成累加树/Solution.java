package Chapter14_深度搜索和广度搜索.Q538_把二叉搜索树转化成累加树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 00:27
 **/

public class Solution {
    /**
     * 二叉树搜索树的特性的根节点的值大于左子节点的值但小于右子节点的值
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        sumTree(root,0);
        return root;
    }
    public int sumTree(TreeNode root, int offset){
        //如果当前为Null,则返回offset
        if(root == null){
            return offset;
        }
        //将祖先节点的值传递到下层节点计算和
        int val = sumTree(root.right,offset);
        //更新当前节点的值
        root.val = val + root.val;
        //然后将当前计算那结果传入左子树
        return  sumTree(root.left, root.val);
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
