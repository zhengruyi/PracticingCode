package Chapter14_深度搜索和广度搜索.Q958_二叉树的完全性检验;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/01/2021 22:43
 **/

public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue <TreeNode> queue = new LinkedList <>();
        queue.offer(root);
        boolean found = false;
        //完全二叉树的等价条件就是在广度遍历时在第一个Null节点后不存在非Null节点
        //如果有那么这棵树一定不是完全二叉树
        while(!queue.isEmpty()){
            TreeNode tmp =  queue.poll();
            if(tmp == null){
                found = true;
            }else{
                if(found){
                    return false;
                }
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }
        }
        return true;
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