package Chapter14_深度搜索和广度搜索.Q589_N叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/04/2021 21:58
 **/

public class Solution {
    List <Integer> res = new ArrayList();
    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }
    public void dfs(Node root){
        if(root == null){
            return;
        }
        res.add(root.val);
        for(Node node : root.children){
            dfs(node);
        }
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