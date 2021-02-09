package Chapter14_深度搜索和广度搜索.Q590_N叉树的后序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/02/2021 21:20
 **/

public class Solution {
    List <Integer> res = new ArrayList <>();

    /**
     * 简单的后序遍历,从左到右各自深度遍历子节点
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        dfs(root);
        return res;
    }
    public void dfs(Node root){
        if(root == null){
            return;
        }
        for(Node node : root.children){
            dfs(node);
        }
        res.add(root.val);
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