package Chapter3_二叉树问题.Q16_通过有序数组生成平衡搜索二叉树;

import Chapter3_二叉树问题.Tree;
import com.sun.tools.attach.AgentInitializationException;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/06/2020 18:55
 **/

public class GenerateBST {
    public static Tree generate(int[] array) {
        if(array.length == 0){
            return null;
        }
        Tree root = construct(array,0,array.length - 1);
        return root;
    }

    public static  Tree construct(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Tree root = new Tree(array[mid]);
        root.left = construct(array,start, mid -1);
        root.right = construct(array,mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        generate(array);
    }
}
