package Chapter3_二叉树问题.Q7_找到二叉树中最大搜索二叉子树;

import Chapter3_二叉树问题.Tree;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 31/05/2020 16:10
 **/

public class FindBinarySearchTree {
    public static Tree find(Tree root){
        if(root == null){
            return null;
        }
        //数组分别表示节点数目,子树的最小值，子树的最大值
        int[] record = new int[3];
        return postOrder(root,record);
    }
    public static Tree postOrder(Tree root,int[] record){
        if(root == null){
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
            return null;
        }
        Tree LBST = postOrder(root.left,record);
        int  numLeft = record[0];
        int  minLeft = record[1];
        int  maxLeft = record[2];
        Tree RBST = postOrder(root.right,record);
        int  numRight = record[0];
        int  minRight = record[1];
        int  maxRight = record[2];
        record[1] = Math.min(minLeft,root.value);
        record[2] = Math.max(maxRight,root.value);
        if(root.left == LBST && root.right == RBST && maxLeft < root.value && minRight > root.value){
            record[0] = numLeft + numRight + 1;
            return root;
        }
        record[0] = Math.max(numLeft,numRight);
        return record[0] == numLeft ? LBST : RBST;
    }

    public static void main(String[] args) {
        Tree t0 = new Tree(0);
        Tree t3 = new Tree(3);
        Tree t2 = new Tree(2);
        Tree t5 = new Tree(5);
        Tree t11 = new Tree(11);
        Tree t15 = new Tree(15);
        Tree t20 = new Tree(20);
        Tree t16 = new Tree(16);
        Tree t1 = new Tree(1,t0,t3);
        Tree t4 = new Tree(4,t2,t5);
        Tree t14 = new Tree(14,t11,t15);
        Tree t10 = new Tree(10,t4,t14);
        Tree t13 = new Tree(13,t20,t16);
        Tree t12 = new Tree(12,t10,t13);
        Tree t6 = new Tree(6,t1,t12);
        find(t6);
    }
}
