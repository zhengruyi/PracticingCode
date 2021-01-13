package Chapter14_深度搜索和广度搜索.Q1008_前序遍历构建二叉树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/01/2021 19:49
 **/

public class Solution {
    /**
     * 基本思想就是把数组分成多段然后递归进行求解
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder,0,preorder.length-1);
    }
    public TreeNode construct(int[] preorder, int start, int end){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        //右子树的开始位置就是从当前节点往右搜索，第一个大于根节点值就是右子树的根节点
        int mid = findIndex(start,end,preorder);
        //递归构建左右子树
        root.left = construct(preorder,start+1,mid);
        root.right = construct(preorder,mid+1,end);
        return root;
    }

    /**
     * 根据更节点的值和索引来确定右节点的开始索引
     * @param start
     * @param end
     * @param preorder
     * @return
     */
    public int findIndex(int start, int end, int[]preorder){
        int i = start;
        while(i+1 <= end && preorder[i+1] < preorder[start]){
            i++;
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