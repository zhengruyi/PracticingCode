package Chapter3_二叉树问题.Q21_先序中序和后序数组两两结合重构二叉树;

import Chapter3_二叉树问题.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/06/2020 21:20
 **/

public class ReconstructBinaryTree {


    public static Tree reconstructByPreAndIn(int[] pre, int[] in){
        HashMap<Integer,Integer> map = new HashMap <>(in.length);
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        Tree root = reconstructPI(pre,0,pre.length-1, in, 0, in.length -1,map);
        return root;
    }


    public static Tree reconstructPI(int[] pre, int preStart, int preEnd, int[] in,
                                     int inStart, int inEnd,HashMap<Integer,Integer> map){
        if(preStart > preEnd){
            return null;
        }
        Tree root = new Tree(pre[preStart]);
        int rootIndexIn = map.get(root.value);
        //前序遍历的范围的终点等于起点加上中序遍历的左子树的节点数目
        root.left = reconstructPI(pre,preStart + 1,preStart + rootIndexIn - inStart,
                in,inStart,rootIndexIn -1,map);
        root.right = reconstructPI(pre,preStart + rootIndexIn - inStart + 1,preEnd,
                in,rootIndexIn + 1,inEnd,map
        );
        return root;
    }

    public static Tree reconstructByInAndPost(int[] in, int[] post){
        HashMap<Integer,Integer> map = new HashMap <>(in.length);
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        Tree root = reconstructIP(in,0,in.length - 1,post,0,post.length -1,map);
        return root;
    }

    public static Tree reconstructIP(int[] in, int inStart, int inEnd, int[] post,
                                     int postStart, int postEnd,HashMap<Integer,Integer> map){
        if(postStart > postEnd){
            return null;
        }
        Tree root = new Tree(post[postEnd]);
        int rootIndex = map.get(root.value);
        root.left = reconstructIP(in,inStart,rootIndex - 1,post,postStart,postStart+ rootIndex - inStart - 1,map);
        root.right = reconstructIP(in,rootIndex + 1,inEnd,post,postStart+ rootIndex - inStart,postEnd -1, map);
        return root;
    }
    public static Tree reconstructByPreAndPost(int[] pre, int[] post){
        HashMap<Integer,Integer> map = new HashMap <>(post.length);
        for (int i = 0; i < post.length; i++) {
            map.put(post[i],i);
        }
        Tree root = reconstructPrePost(pre,0,pre.length - 1,post,0,post.length - 1,map);
        return root;
    }
    public static Tree reconstructPrePost(int[]pre,int preStart,int preEnd,
                                          int[] post, int postStart, int postEnd,HashMap<Integer,Integer> map){
        Tree root = new Tree(post[postEnd--]);
        if(preStart == preEnd){
            return root;
        }
        int index = map.get(pre[++preStart]);
        root.left = reconstructPrePost(pre,preStart,preStart+ index - postStart,post,postStart,index,map);
        root.right = reconstructPrePost(pre,preStart+index - postStart+1,preEnd,post,index+1,postEnd,map);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,3,5,6};
        int[] in = {4,2,1,5,3,6};
        int[] post = {4,2,5,6,3,1 };
        reconstructByPreAndIn(pre,in);
        reconstructByInAndPost(in,post);
        //一个二叉树只有在除叶子节点外，每个节点都有左右节点时才可以通过先序和后序数组来重建
        reconstructByPreAndPost(new int[]{1,2,4,5,3,6,7},new int[]{4,5,2,6,7,3,1});
    }
}
