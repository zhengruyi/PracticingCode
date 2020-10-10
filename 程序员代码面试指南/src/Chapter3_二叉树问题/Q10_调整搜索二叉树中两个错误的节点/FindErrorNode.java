package Chapter3_二叉树问题.Q10_调整搜索二叉树中两个错误的节点;

import Chapter3_二叉树问题.Tree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/06/2020 13:37
 **/

public class FindErrorNode {
    public static int[] findError(Tree root){
        ArrayList<Integer> array = new ArrayList <>();
        preOrder(root,array);
        int index = 0;
        int temp = 0;
        int[] result = new int[2];
        for (int i = 0; i < array.size() - 1; i++) {
            //中序遍历时二叉搜索树中的错误节点分别是第一次降序中较大的节点和地第二次降序中较小的节点
            //如果只有一个节点，那么错误节点靠在一起，是降序的两个节点
            if(array.get(i) > array.get(i + 1)){
                result[index] = index ==0 ? array.get(i) : array.get(i + 1);
                temp = i;
                index++;
            }
        }
        if(index == 1){
            result[1] = array.get(temp + 1);
        }
        return result;
    }
    public static void preOrder(Tree root, ArrayList<Integer> array){
        if(root == null){
            return;
        }
        preOrder(root.left,array);
        array.add(root.value);
        preOrder(root.right,array);
    }

    public static void main(String[] args) {
        Tree t1 = new Tree(1);
        Tree t7 = new Tree(7);
        Tree t3 = new Tree(3,t1,t7);
        Tree t6 = new Tree(6);
        Tree t8 = new Tree(8);
        Tree t4 = new Tree(4,t6,t8);
        Tree t5 = new Tree(5,t3,t4);
        int[] result = findError(t5);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }


        Tree n1 = new Tree(1);
        Tree n2 = new Tree(2,n1,null);
        Tree n5 = new Tree(5);
        Tree n3 = new Tree(3,null,n5);
        Tree n4 = new Tree(4,n2,n3);
        result = findError(n4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}