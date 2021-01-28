package Chapter14_深度搜索和广度搜索.Q426_将二叉搜索树转化成双向链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/01/2021 23:30
 **/

public class Solution {
    //记录访问到的上一个节点
    Node last = null;
    //用来记录全局的最小节点，方便最后首尾相连
    Node first = null;

    /**
     * 基本思想就是要保证有序，需要对二叉搜索树进行中序遍历这样就能得到一个升序序列
     * 这里主要要注意保存全局最小的节点以及保存上一个节点
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        dfs(root);
        first.left = last;
        last.right = first;
        return first;
    }
    public void dfs(Node root){
        if(root == null){
            return;
        }
        dfs(root.left);
        //如果last为Null,说明当前节点是全局最小点保存下来
        if(last != null){
            //构建双向链表
            last.right = root;
            root.left = last;
        }else{
            first = root;
        }
        //把当前节点最为上一个已经遍历过的节点
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