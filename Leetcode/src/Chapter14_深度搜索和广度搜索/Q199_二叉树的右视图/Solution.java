package Chapter14_深度搜索和广度搜索.Q199_二叉树的右视图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/12/2020 20:55
 **/

public class Solution {
    /**
     * 右视图就是采用层遍历时每层的最右边一个元素,构成了二叉树的右视图
     * @param root
     * @return
     */
    public List <Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList <>();
        List<Integer> res = new ArrayList <>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode t = queue.poll();
                if(i == size -1){
                    res.add(t.val);
                }
                if(t.left != null){
                    queue.offer(t.left);
                }
                if(t.right != null){
                    queue.offer(t.right);
                }
            }
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
