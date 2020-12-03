package Chapter13_二叉树.Q105_从前序与中序遍历序列构造二叉树;

import Chapter13_二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/12/2020 23:11
 **/

public class Solution {
    Map <Integer,Integer> map = new HashMap <Integer,Integer>();
    int preIndex = 0;;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //保存值和索引的对应关系
        for(int i =0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return buildTree(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder,int[]inorder,int start, int end){
        if(start > end){
            return null;
        }
        //前序遍历，顺序为根左右，所以中间节点的值要从0往后递增
        int val = preorder[preIndex];
        TreeNode root = new TreeNode(val);
        int mid = map.get(val);
        preIndex++;
        //先构造左子树
        root.left = buildTree(preorder,inorder,start,mid-1);
        //构造右子树
        root.right = buildTree(preorder,inorder,mid+1,end);
        return root;
    }
}
