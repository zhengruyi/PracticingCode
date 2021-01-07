package Q32_从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/01/2021 22:07
 **/

public class Solution {
    /**
     * 基本的广度遍历
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        List <Integer> res = new ArrayList <>();
        Queue <TreeNode> queue = new LinkedList <>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            res.add(tmp.val);
            if(tmp.left != null){
                queue.offer(tmp.left);
            }
            if(tmp.right != null){
                queue.offer(tmp.right);
            }
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }