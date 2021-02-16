package Chapter14_深度搜索和广度搜索.Q1302_层数最深叶子节点的和;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/02/2021 23:03
 **/

public class Solution {
    /**
     * 本质就是广度遍历,通过遍历完一层后，queue是不是空来判断刚刚遍历的那层是不是最后一层
     * 每轮开头都将sum设置成0，然后记录这一层所有节点的和,如果遍历完这层后发现queue是空,那么刚刚那一层就是
     * 最后一层
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        Queue <TreeNode> queue = new LinkedList <>();
        queue.offer(root);
        int sum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                sum += tmp.val;
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
            }
            if(queue.size() == 0){
                return sum;
            }
        }
        return sum;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}