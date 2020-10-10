package Q19_二叉树的镜像;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/04/2020 21:40
 **/

public class BinaryTreeMirror {
    public Tree getMirror(Tree root){

        if(root == null)
            return null;

        if(root.left == null && root.right == null)
            return root;

        Tree temp = root.left;
        root.left = root.right;
        root.right = temp;
        getMirror(root.left);
        getMirror(root.right);

        return root;

    }

    @Test
    void test(){
        Tree leaf5 = new Tree(5,null,null);
        Tree leaf7 = new Tree(7,null,null);
        Tree leaf9 = new Tree(9,null,null);
        Tree leaf11 = new Tree(11,null,null);
        Tree t6 = new Tree(6,leaf5,leaf7);
        Tree t10 = new Tree(10,leaf9,leaf11);
        Tree root = new Tree(8,t6,t10);
        /*
        Tree result  = getMirror(root);
        Assertions.assertEquals(11,result.left.left.value);
        Assertions.assertEquals(9,result.left.right.value);
        Assertions.assertEquals(7,result.right.left.value);
        Assertions.assertEquals(5,result.right.right.value);
        Assertions.assertEquals(10,result.left.value);
        Assertions.assertEquals(6,result.right.value);
        */

        Tree root1 = new Tree(8,t6,null);
        Tree r1 =  getMirror(root1);
        Assertions.assertEquals(6,r1.right.value);
        Assertions.assertEquals(7,r1.right.left.value);
        Assertions.assertEquals(5,r1.right.right.value);
        Assertions.assertNull(r1.left);

    }
}
class Tree {
    public int value;
    public Tree left;
    public Tree right;

    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
