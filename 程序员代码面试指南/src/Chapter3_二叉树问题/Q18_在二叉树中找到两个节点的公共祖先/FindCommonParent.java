package Chapter3_二叉树问题.Q18_在二叉树中找到两个节点的公共祖先;

import Chapter3_二叉树问题.Q15_判断一棵二叉树是否为二叉搜索树和完全二叉树.CheckBSTAndCompleteBT;
import Chapter3_二叉树问题.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/06/2020 20:39
 **/

public class FindCommonParent {
    Tree root,t2,t3,t4,t5,t6,t7,t8;
    public Tree findCommonParent(Tree root, Tree t1, Tree t2){
        if(root == null || t1 == root || t2 == root){
            return root;
        }
        Tree left =findCommonParent(root.left,t1,t2);
        Tree right = findCommonParent(root.right,t1,t2);
        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }

    public Tree findCommonParentBetter(Tree root, Tree t1, Tree t2){
        HashMap<Tree,Tree> map = new HashMap <>();
        setMap(root,map);
        HashSet<Tree> set = new HashSet <>();
        set.add(t1);
        while (map.containsKey(t1)){
            Tree temp = map.get(t1);
            set.add(temp);
            t1 = temp;
        }
        while (map.containsKey(t2)){
            Tree temp = map.get(t2);
            if(set.contains(temp)){
                return temp;
            }
            t2 = temp;
        }
        return null;
    }
    public void setMap(Tree root, HashMap<Tree,Tree> map){
        if(root == null){
            return;
        }
        if(root.left != null){
            map.put(root.left,root);
        }
        if(root.right != null){
            map.put(root.right,root);
        }
        setMap(root.left,map);
        setMap(root.right,map);
    }

    @BeforeEach
    void setup(){
        t4 = new Tree(4);
        t5 = new Tree(5);
        t6 = new Tree(6);
        t8 = new Tree(8);
        t7 = new Tree(7,t8,null);
        t2 = new Tree(2,t4,t5);
        t3 = new Tree(3,t6,t7);
        root = new Tree(1,t2,t3);
    }
    @Test
    void test(){
        Assertions.assertEquals(2,findCommonParent(root,t4,t5).value);
        Assertions.assertEquals(2,findCommonParent(root,t2,t5).value);
        Assertions.assertEquals(3,findCommonParent(root,t6,t8).value);
        Assertions.assertEquals(1,findCommonParent(root,t5,t8).value);
    }

    @Test
    void test1(){
        Assertions.assertEquals(2,findCommonParentBetter(root,t4,t5).value);
        Assertions.assertEquals(2,findCommonParentBetter(root,t2,t5).value);
        Assertions.assertEquals(3,findCommonParentBetter(root,t6,t8).value);
        Assertions.assertEquals(1,findCommonParentBetter(root,t5,t8).value);
    }

}
