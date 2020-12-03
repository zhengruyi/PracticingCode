package Chapter13_二叉树.Q106_从中序与后序遍历序列构造二叉树;

import Chapter13_二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/12/2020 23:10
 **/

public class Solution {
    Map <Integer,Integer> map = new HashMap <Integer,Integer>();
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //用来快速查找中序遍历中对应的值所对应的索引
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        //后续遍历，中间节点左放在最后，所以从后开始遍历找到中间节点
        postIndex = postorder.length -1;
        return buildTree(inorder,postorder,0,postorder.length-1);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder,int start, int end){
        if(start > end){
            return null;
        }
        //找到中间节点的值
        int val = postorder[postIndex];
        postIndex--;
        int mid = map.get(val);
        //创建根节点
        TreeNode root = new TreeNode(val);
        //由于后续遍历，顺序为左右根，所以要先构造右子树
        root.right = buildTree(inorder,postorder,mid+1,end);
        root.left = buildTree(inorder,postorder,start,mid -1);
        return root;
    }
}
