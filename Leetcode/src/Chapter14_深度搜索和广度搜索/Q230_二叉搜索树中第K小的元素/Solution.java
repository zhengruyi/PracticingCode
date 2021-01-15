package Chapter14_深度搜索和广度搜索.Q230_二叉搜索树中第K小的元素;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/01/2021 21:40
 **/

public class Solution {
    int index;
    int ans;

    /**
     * 二叉搜索树的前序遍历就是一个有序数组，所以直接计数并记录答案就可以
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return ans;
        }
        index = 0;
        preOrder(root,k);
        return ans;
    }
    public void preOrder(TreeNode root,int k){
        if(root == null){
            return;
        }
        preOrder(root.left,k);
        index++;
        if(index == k){
            ans = root.val;
        }
        preOrder(root.right,k);
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