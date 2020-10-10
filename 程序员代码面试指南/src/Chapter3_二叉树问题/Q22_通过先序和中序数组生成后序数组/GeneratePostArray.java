package Chapter3_二叉树问题.Q22_通过先序和中序数组生成后序数组;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/06/2020 11:52
 **/

public class GeneratePostArray {
    public static int[] generate(int[] pre, int[] in){
        int[] post = new int[pre.length];
        HashMap<Integer,Integer> map = new HashMap <>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        int[]index = {pre.length -1};
        generatePostByPreAndIn(pre,0,pre.length - 1,in,0,in.length -1,map,post,index);
        return post;
    }
    public static void generatePostByPreAndIn(int[] pre, int preStart, int preEnd, int[] in, int inStart,
                                       int  inEnd, HashMap<Integer,Integer> map, int[] post, int[] index){
        if(preStart > preEnd){
            return;
        }
        int root = pre[preStart];
        post[index[0]--] = root;
        int rootIndex = map.get(root);

        generatePostByPreAndIn(pre,preStart+rootIndex - inStart+1,preEnd,
                in,rootIndex+1,inEnd,map,post,index);

        generatePostByPreAndIn(pre,preStart+1,preStart+rootIndex - inStart,
                in,inStart,rootIndex -1,map,post,index);
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] in = {4,2,5,1,6,3,7};
        generate(pre,in);
    }
}
