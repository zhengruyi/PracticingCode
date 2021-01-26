package Q32_从上到下打印二叉树III;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 23:11
 **/

public class Solution {
    /**
     * 简单的广度遍历，但是要根据方向来决定弹出元素的位置和做左右子节点哪个先放入队列
     * @param root
     * @return
     */
    public List<List <Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList <>();
        if(root == null){
            return res;
        }
        LinkedList <TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                //根据搜索方向来决定从开头或者结尾处取值
                TreeNode tree = leftToRight ? queue.pollFirst() : queue.pollLast();
                tmp.add(tree.val);
                //根据方向选择将左右节点放入队列的顺序
                if(leftToRight){
                    if(tree.left != null){
                        queue.offer(tree.left);
                    }
                    if(tree.right != null){
                        queue.offer(tree.right);
                    }
                }else{
                    if(tree.right != null){
                        queue.offerFirst(tree.right);
                    }
                    if(tree.left != null){
                        queue.offerFirst(tree.left);
                    }
                }
            }
            res.add(tmp);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}