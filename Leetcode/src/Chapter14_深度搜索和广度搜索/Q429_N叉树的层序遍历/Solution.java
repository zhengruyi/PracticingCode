package Chapter14_深度搜索和广度搜索.Q429_N叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/01/2021 21:53
 **/

public class Solution {
    /**
     * 基本的层序遍历方式，区别无非是N叉树和二叉树而已
     * @param root
     * @return
     */
    public List<List <Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList <>();
        if(root == null){
            return res;
        }
        Queue <Node> queue = new LinkedList <>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();;
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                tmp.add(node.val);
                for(Node n : node.children){
                    if(n != null){
                        queue.offer(n);
                    }
                }
            }
            res.add(new ArrayList<>(tmp));
            tmp.clear();
        }
        return res;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}