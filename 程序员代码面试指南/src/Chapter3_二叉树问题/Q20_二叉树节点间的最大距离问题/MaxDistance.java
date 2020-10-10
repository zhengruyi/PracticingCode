package Chapter3_二叉树问题.Q20_二叉树节点间的最大距离问题;

import Chapter3_二叉树问题.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/06/2020 20:44
 **/

public class MaxDistance {
    public int getMaxDistance(Tree root){
        int[] dis = new int[1];
        return calculate(root,dis);
    }
    public int calculate(Tree root, int[] distance){
        if(root == null){
            //表示左子树到到右子树的距离为0
            distance[0] = 0;
            return 0;
        }
        //后续遍历方式
        int maxLeft = calculate(root.left,distance);
        //表示当前节点的左子树的最大高度,每次累加直到根节点，为了计算跨越根节点的节点间最大距离
        int maxFromLeft = distance[0];
        int maxRight = calculate(root.right,distance);
        int maxFromRight = distance[0];
        //当前节点的左右节点节点间的最大距离
        int curNodeMax = maxLeft + maxRight + 1;
        //当前节点作为父节点的子节点，它的左子树最远距离为当前节点左右子树的最远距离加1
        distance[0] = Math.max(maxFromLeft,maxFromRight) + 1;
        return Math.max(Math.max(maxLeft,maxRight),curNodeMax);
    }
    @Test
    void test(){
        Tree t4 = new Tree(4);
        Tree t5 = new Tree(5);
        Tree t2 = new Tree(2,t4,null);
        Tree t3 = new Tree(3,null,t5);
        Tree t1 = new Tree(1,t2,t3);
        Assertions.assertEquals(5,getMaxDistance(t1));
    }
}
