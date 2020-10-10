package Chapter3_二叉树问题.Q11_判断t1树中是否包含t2树中的全部拓扑结构;

import Chapter3_二叉树问题.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/06/2020 14:31
 **/

public class ContainsTopologyStructure {
    public boolean contains(Tree t1, Tree t2){
        return check(t1,t2) || contains(t1.left,t2) || contains(t1.right, t2);
    }
    public boolean check(Tree head, Tree target){
        if(target == null){
            return true;
        }
        if(head == null || head.value != target.value){
            return false;
        }
        return check(head.left, target.left) && check(head.right,target.right);
    }
    @Test
    void test(){
        Tree t8 = new Tree(8);
        Tree t9 = new Tree(9);
        Tree t10 = new Tree(10);
        Tree t4 = new Tree(4,t8,t9);
        Tree t5 = new Tree(5,t10,null);
        Tree t2 = new Tree(2,t4,t5);
        Tree t6 = new Tree(6);
        Tree t7 = new Tree(7);
        Tree t3 = new Tree(3,t6,t7);
        Tree t1 = new Tree(1,t2,t3);

        Tree m8 = new Tree(8);
        Tree m4 = new Tree(4,m8,null);
        Tree m5 = new Tree(5);
        Tree m2 = new Tree(2,m4,m5);

        Assertions.assertTrue(contains(t1,m2));
    }
}
