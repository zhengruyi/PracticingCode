package Chapter3_二叉树问题.Q24_统计完全二叉树的节点数;

import Chapter3_二叉树问题.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/06/2020 19:41
 **/

public class TreeNodeNumber {
    public int getNodeNumbers(Tree root){
        if(root == null){
            return 0;
        }
        int height = getHeight(root);
        return getNumber(root,height,1);
    }

    /**
     * 完全二叉树只有一个节点只有左孩子，其余节点都是满的
     * @param root
     * @param height
     * @param level
     * @return
     */
    public int getNumber(Tree root, int height, int level){
        if(root == null){
            return 0;
        }
        int rightSubHeight = getHeight(root.right);
        //求右子树的最左节点来判断左子树是否是满的
        if(rightSubHeight == height - level){
            //说明左子树的满的，所以一颗满的完全二叉树的节点数目为2^(height - 1) -1, 最后一个是根节点
            //全部数目等于左子树的数目机上根节点加上右子树的节点数目
            int leftSubNumber = (int)Math.pow(2,height-level) - 1 + 1;
            return leftSubNumber + getNumber(root.right,height,level+1);
        }else{
            //说明左子树是不满的，但反过来说右子树是满的，所以可以先用同样的方法来计算右子树节点数目
            //在迭代去求左子树的节点数目
            int rightSubNumber = (int)Math.pow(2,height-level -1) - 1 + 1;
            return rightSubNumber + getNumber(root.left,height,level+1);
        }
    }
    public int getHeight(Tree root){
        if(root == null){
            return 0;
        }
        int height = 1;
        while (root.left != null){
            height++;
            root = root.left;
        }
        return height;
    }
    @Test
    void test(){
        Tree t10 = new Tree(10);
        Tree t9 = new Tree(9);
        Tree t8 = new Tree(8);
        Tree t7 = new Tree(7);
        Tree t6 = new Tree(6);
        Tree t5 = new Tree(5,t10,null);
        Tree t4 = new Tree(4,t8,t9);
        Tree t3 = new Tree(3,t6,t7);
        Tree t2 = new Tree(2,t4,t5);
        Tree t1 = new Tree(1,t2,t3);
        Assertions.assertEquals(10,getNodeNumbers(t1));

    }

}
