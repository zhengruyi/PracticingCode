package Chapter14_深度搜索和广度搜索.Q559_N叉树的最大深度;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/02/2021 23:31
 **/

public class Solution {
    /**
     * 广度遍历，每次遍历完一层说明树的深度加1
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        int depth = 0;
        if(root == null){
            return 0;
        }
        Queue <Node> queue = new LinkedList <>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node tmp = queue.poll();
                for(Node node : tmp.children){
                    if(node != null){
                        queue.offer(node);
                    }
                }
            }
            depth++;
        }
        return depth;
    }
}
class Node {
    public int val;
    public List <Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};