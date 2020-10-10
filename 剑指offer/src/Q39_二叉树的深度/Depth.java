package Q39_二叉树的深度;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/04/2020 09:41
 **/

public class Depth {
    public int getDepth(Tree root){
        if(root == null)
            return 0;

        int depth = 0;
        return next(root, depth);
    }
    public int next (Tree root, int depth){
        if(root == null)
            return depth;

        depth ++;
        int depth_left = depth;
        int depth_right = depth;
        if(root.left != null){
             depth_left = next(root.left, depth);
        }

        if(root.right != null){
            depth_right = next(root.right,depth);
        }

        return depth_right >= depth_left ? depth_right : depth_left;
    }

    @Test
    void test(){
        Tree leaf1 = new Tree(1,null,null);
        Tree leaf2 = new Tree(2,leaf1,null);
        Tree leaf4 = new Tree(4, leaf2, null);
        Tree leaf8 = new Tree(8, null, null);
        Tree leaf12 = new Tree(12, null, null);
        Tree leaf16 = new Tree(16, null, null);
        Tree t6 = new Tree(6, leaf4, leaf8);
        Tree t14 = new Tree(14, leaf12, leaf16);
        Tree root = new Tree(10, t6, t14);
        Assertions.assertEquals(5,getDepth(root));
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