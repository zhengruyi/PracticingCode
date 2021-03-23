package Chapter14_深度搜索和广度搜索.Q1602_找到二叉树中最近的右侧节点;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/03/2021 23:43
 **/

public class Solution {
    /**
     * 简单的广度遍历
     * @param root
     * @param u
     * @return
     */
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue <TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                if(tmp.val == u.val){
                    return i == size -1 ? null : queue.poll();
                }
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
            }
        }
        return null;
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