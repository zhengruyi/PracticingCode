package Chapter3_二叉树问题.Q17_在二叉树中找到一个节点的后继节点;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/06/2020 19:39
 **/

public class FindNextNode {
    /**
     * 中续遍历的下一个节点称为后继节点
     * @param node
     * @return
     */
    public Tree getNextNode(Tree node){
        if(node.right != null){
            return node.right;
        }
        if(node.parent.left == node){
            return node.parent;
        }
        while (node.parent != null){
            if(node.parent.left == node){
                return node.parent;
            }
            node = node.parent;
        }
        return null;
    }


    @Test
    void test(){
        Tree t2 = new Tree(2);
        Tree t5 = new Tree(5);
        Tree t7 = new Tree(7);
        Tree t1 = new Tree(1,null,t2);
        Tree t4 = new Tree(4,null,t5);
        Tree t3 = new Tree(3,t1,t4);
        Tree t8 = new Tree(8,t7,null);
        Tree t10 = new Tree(10);
        Tree t9 = new Tree(9,t8,t10);
        Tree t6 = new Tree(6,t3,t9);
        t2.parent = t1;
        t1.parent = t3;
        t5.parent = t4;
        t4.parent = t3;
        t3.parent = t6;
        t7.parent =t8;
        t8.parent = t9;
        t10.parent = t9;
        t9.parent = t6;
        t6.parent = null;
        Assertions.assertEquals(2,getNextNode(t1).value);
        Assertions.assertEquals(6,getNextNode(t5).value);
        Assertions.assertNull(getNextNode(t10));
    }
}
class Tree {
    public  int value;
    public Tree left;
    public Tree right;
    public Tree parent;
    public Tree(int value){
        this.value = value;
    }
    public Tree(int value, Tree left, Tree right){
        this.value =value;
        this.left = left;
        this.right = right;
    }
}