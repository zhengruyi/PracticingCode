package Q39_二叉树的深度;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/04/2020 10:50
 **/

public class IsBalanced {
    private int depth = 0;
    private int left = 0;
    private int right = 0;
    public boolean checkBalanced(Tree root){
        if(root == null)
            return true;
        return checkedSubBalanced(root);
    }
    public boolean checkedSubBalanced(Tree root){
        if(root == null){
            depth = 0;
            return true;
        }
        if(checkedSubBalanced(root.left)){
            left = depth;
            if(checkedSubBalanced(root.right)){
                right = depth;
                int diff = left - right;
                if(diff <= 1 && diff >= -1){
                    depth = left >= right ? left +1 : right + 1;
                    return true;
                }


            }

        }
        return false;

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
        Assertions.assertFalse(checkBalanced(root));

        Tree t1 = new Tree(1,null,null);
        Tree t5 = new Tree(5,null,null);
        Tree t4 = new Tree(4,t1,null);
        Tree root2 = new Tree(6,t4,t5);
        Assertions.assertTrue(checkBalanced(root2));
    }

}
