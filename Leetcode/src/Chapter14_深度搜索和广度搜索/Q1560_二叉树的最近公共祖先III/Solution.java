package Chapter14_深度搜索和广度搜索.Q1560_二叉树的最近公共祖先III;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/03/2021 22:50
 **/

public class Solution {
    /**
     * 从两个起始点出发,每次走一步,第一次相交的点就是最近的公共祖先
     * 每个节点都有指向父类的指针,所以这题就是广度遍历
     * @param p
     * @param q
     * @return
     */
    public Node lowestCommonAncestor(Node p, Node q) {
        if(p == q){
            return p;
        }
        Set <Node> set = new HashSet();
        Queue <Node> queue = new LinkedList <>();
        queue.offer(p);
        set.add(p);
        queue.offer(q);
        set.add(q);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node tmp = queue.poll();
                if(tmp.parent != null){
                    if(set.contains(tmp.parent)){
                        return tmp.parent;
                    }
                    set.add(tmp.parent);
                    queue.offer(tmp.parent);
                }
            }
        }
        return null;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};