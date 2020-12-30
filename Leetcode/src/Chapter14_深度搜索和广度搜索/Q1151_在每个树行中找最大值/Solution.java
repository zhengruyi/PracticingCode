package Chapter14_深度搜索和广度搜索.Q1151_在每个树行中找最大值;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/12/2020 21:03
 **/

public class Solution {
    /**
     * 宽度遍历，然后在每一行中选取最大值
     * @param root
     * @return
     */
    public List <Integer> largestValues(TreeNode root) {
        Queue <TreeNode> queue = new LinkedList <>();
        List<Integer> res = new ArrayList <>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                max = Math.max(max,tmp.val);
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
            }
            res.add(max);
        }
        return res;
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