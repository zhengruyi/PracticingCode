package Chapter3_二叉树问题.Q15_判断一棵二叉树是否为二叉搜索树和完全二叉树;

import Chapter3_二叉树问题.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/06/2020 10:37
 **/

public class CheckBSTAndCompleteBT {
    public boolean checkBST(Tree root){
        ArrayList<Integer> array  = new ArrayList <>();
        inTraverse(root,array);
        for (int i = 0; i < array.size() - 1; i++) {
            if(array.get(i) > array.get(i + 1)){
                return false;
            }
        }
        return  true;
    }
    public boolean checkCompleteBinaryTree(Tree root){
        if(root == null){
            return false;
        }
        Deque<Tree> deque = new ArrayDeque <>();
        deque.addLast(root);
        boolean beLeaf = false;
        while (!deque.isEmpty()){
            Tree temp = deque.removeFirst();
            if(beLeaf && (temp.left != null || temp.right != null)){
                return false;
            }
            if (temp.left != null ) {
                deque.addLast(temp.left);
                if(temp.right  == null){
                    beLeaf = true;
                }else{
                    deque.addLast(temp.right);
                }
            }else{
                if(temp.right != null){
                    return false;
                }
            }
        }
        return true;
    }
    public void inTraverse(Tree root, ArrayList<Integer> array){
        if(root == null){
            return;
        }
        inTraverse(root.left,array);
        array.add(root.value);
        inTraverse(root.right,array);
    }

    @Test
    void test(){
        Tree t2 = new Tree(2);
        Tree t4 = new Tree(4);
        Tree t6 = new Tree(6);
        Tree t8 = new Tree(8);
        Tree t3 = new Tree(3,t2,t4);
        Tree t7 = new Tree(7,t6,t8);
        Tree t5 = new Tree(5,t3,t7);
        Assertions.assertTrue(checkBST(t5));
        Assertions.assertTrue(checkCompleteBinaryTree(t5));
        t7.left = null;
        Assertions.assertFalse(checkCompleteBinaryTree(t5));
        t7.right = null;
        Assertions.assertTrue(checkCompleteBinaryTree(t5));
    }
}
