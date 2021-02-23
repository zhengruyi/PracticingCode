package Chapter0_其他.Q156_上下翻转二叉树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/02/2021 23:31
 **/

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode parent = null;
        TreeNode parent_right = null;
        while(root != null){
            //向链表反转的next操作
            TreeNode root_left = root.left;
            root.left = parent_right;
            parent_right = root.right;
            root.right = parent;
            //跟新parent指针
            parent = root;
            //迭代下一轮
            root = root_left;
        }
        return parent;
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