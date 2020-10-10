package Chapter3_二叉树问题.Q14_根据后序数组重建二叉搜索树;

import Chapter3_二叉树问题.Tree;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/06/2020 22:24
 **/

public class PostArrayToBST {
    public static Tree constructBST(int[] array){
        Tree root = construct(array,0,array.length -1);
        return root;
    }
    public static Tree construct(int[] array, int start, int end){
        if(start == end){
            return  new Tree(array[start]);
        }
        //初始化当前值为根节点
        Tree root = new Tree(array[end]);
        int leftEnd = -1;
        int rightStart = end;
        for (int i = start; i < end  ; i++) {
            //确定左子树的终点
            if(array[i] < array[end]){
                leftEnd = i;
            }else{
                //确定右子树的起点
                rightStart = rightStart == end ? i : rightStart;
            }
        }
        //左子树存在的情况下递归建立左子树
        if(leftEnd != -1){
            root.left = construct(array,start,leftEnd);
        }
        //右子树存在的情况下递归建立右子树
        if(rightStart != end){
            root.right = construct(array,rightStart, end -1);
        }
        //返回当前节点
        return root;
    }

    public static void main(String[] args) {
        int[] array = {1,4,3,6,8,7,5};
        constructBST(array);
    }
}
