package Chapter13_二叉树.Q102_二叉树的层序遍历;

import Chapter13_二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/12/2020 22:49
 **/

public class Solution {
    public List<List <Integer>> levelOrder(TreeNode root) {
        //双端队列
        Deque <TreeNode> queue = new LinkedList <TreeNode>();
        List<List<Integer>> res = new ArrayList <List<Integer>>();
        if(root == null){
            return res;
        }
        queue.addFirst(root);
        //以null为分割符表示一行节点结束
        queue.addFirst(null);
        List<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            //表示一行节点遍历结束
            if(queue.getLast() == null){
                res.add(list);
                list = new ArrayList<Integer>();
                queue.removeLast();
                //防止出现数组中元素为null时循环添加null情况，所以需要特殊检查
                if(!queue.isEmpty() && queue.getLast() != null){
                    queue.addFirst(null);
                }
            }else{
                //层级遍历
                TreeNode tmp = queue.removeLast();
                list.add(tmp.val);
                if(tmp.left != null){
                    queue.addFirst(tmp.left);
                }
                if(tmp.right != null){
                    queue.addFirst(tmp.right);
                }
            }
        }
        return res;
    }
}
