package Chapter14_深度搜索和广度搜索.Q654_最大二叉树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/01/2021 23:35
 **/

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length-1);
    }

    /**
     * 每回合遍历来搜索最大值，然后根据最大值把数组分成两部分
     * 分别表示左右子树,采用递归的方式来分别构建左右子树
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public TreeNode construct(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int index = max(nums,left,right);
        TreeNode root = new TreeNode(nums[index]);
        root.left = construct(nums,left,index-1);
        root.right = construct(nums,index+1,right);
        return root;
    }
    public int max(int[] nums, int left, int right){
        int index = left;
        for(int i = left; i <= right; i++){
            if(nums[index] < nums[i]){
                index = i;
            }
        }
        return index;
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
