package Chapter14_深度搜索和广度搜索.Q103_二叉树的锯齿形层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/01/2021 22:06
 **/

public class Solution {
    /**
     * 简单的层序遍历，但是要考虑到不同方向的添加顺序不同
     * @param root
     * @return
     */
    public List<List <Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList <>();
        if(root == null){
            return res;
        }
        boolean dir = true;
        LinkedList<TreeNode> queue = new LinkedList <>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            TreeNode tmp = null;
            for(int i = 0; i < size; i++){
                tmp = dir ? queue.pollFirst() : queue.pollLast();
                list.add(tmp.val);
                if(dir){
                    if(tmp.left != null){
                        queue.addLast(tmp.left);
                    }
                    if(tmp.right != null){
                        queue.addLast(tmp.right);
                    }
                }else{
                    if(tmp.right != null){
                        queue.addFirst(tmp.right);
                    }
                    if(tmp.left != null){
                        queue.addFirst(tmp.left);
                    }
                }
            }
            res.add(list);
            dir = !dir;
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