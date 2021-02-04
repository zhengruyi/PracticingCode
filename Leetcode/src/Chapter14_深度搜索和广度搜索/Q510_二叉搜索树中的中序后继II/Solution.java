package Chapter14_深度搜索和广度搜索.Q510_二叉搜索树中的中序后继II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/02/2021 23:29
 **/

public class Solution {
    /**
     * 根据搜索二叉树的性质,当前节点的后继节点有两种可能
     * 如果存在右子节点，那么后继节点在右子树的最左子节点
     * 如果不存在右子树，那么后继节点就存在父节点往上遍历,知道当前节点是父节点的左子节点,那么这个父节点就是后继节点
     * @param node
     * @return
     */
    public Node inorderSuccessor(Node node) {
        if(node == null){
            return node;
        }
        if(node.right != null){
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }else{
            while(node.parent != null && node == node.parent.right){
                node = node.parent;
            }
            return node.parent;
        }
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}