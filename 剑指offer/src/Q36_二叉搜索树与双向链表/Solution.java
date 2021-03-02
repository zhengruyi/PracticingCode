package Q36_二叉搜索树与双向链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/03/2021 23:20
 **/

public class Solution {
    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        dfs(root);
        //处理首尾节点的连接关系
        last.right = first;
        first.left = last;
        return first;

    }
    public void dfs(Node root){
        if(root == null){
            return;
        }
        dfs(root.left);
        //将last上一个节点和当前节点用双向指针连接在一起
        if(last != null){
            last.right = root;
            root.left = last;
        }else{
            //指向链表的起始节点
            first = root;
        }
        //last用来指向上一个处理过的节点
        last = root;
        dfs(root.right);
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}