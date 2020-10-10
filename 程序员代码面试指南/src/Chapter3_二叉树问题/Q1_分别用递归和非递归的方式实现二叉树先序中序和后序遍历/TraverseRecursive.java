package Chapter3_二叉树问题.Q1_分别用递归和非递归的方式实现二叉树先序中序和后序遍历;

import Chapter3_二叉树问题.Tree;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/05/2020 21:34
 **/

public class TraverseRecursive {
    public static void preTraverse(Tree root){
        if(root == null){
            return;
        }
        System.out.print(root.value);
        preTraverse(root.left);
        preTraverse(root.right);

    }
    public static void inTraverse(Tree root){
        if(root == null){
            return;
        }
        inTraverse(root.left);
        System.out.print(root.value);
        inTraverse(root.right);
    }
    public static void postTraverse(Tree root){
        if(root == null){
            return;
        }
        postTraverse(root.left);
        postTraverse(root.right);
        System.out.print(root.value);

    }

    public static void main(String[] args) {
        Tree n4 = new Tree(4);
        Tree n5 = new Tree(5);
        Tree n6 = new Tree(6);
        Tree n7 = new Tree(7);
        Tree n2 = new Tree(2,n4,n5);
        Tree n3 = new Tree(3,n6,n7);
        Tree root = new Tree(1,n2,n3);
        preTraverse(root);
        System.out.println();
        inTraverse(root);
        System.out.println();
        postTraverse(root);

    }
}
