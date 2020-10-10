package Chapter3_二叉树问题.Q9_二叉树的按成打印与ZigZag打印;

import Chapter3_二叉树问题.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/06/2020 10:45
 **/

public class PrintBinaryTree {
    /**
     * 按层级打印
     * @param root
     */
    public static void printInLevel(Tree root) {
        Tree last;
        int level = 1;
        Deque <Tree> deque = new ArrayDeque <>();
        deque.addLast(root);
        last = root;
        System.out.print("Level " + level +" : ");
        while (!deque.isEmpty()) {
            Tree temp = deque.removeFirst();
            System.out.print(" "+temp.value+" ");

            if (temp.left != null) {
                deque.addLast(temp.left);
            }
            if (temp.right != null) {
                deque.addLast(temp.right);
            }

            if(temp == last){
                if(!deque.isEmpty()){
                    System.out.println();
                    last = deque.getLast();
                    level++;
                    System.out.print("Level " + level +" :");
                }
            }
        }
    }

    /**
     * 按zigzag方式正反交替打印，注意双向对列的添加位置和树的左右节点添加位置
     * @param root
     */
    public static void printInZigZag(Tree root){
        Tree last;
        int level = 1;
        Deque <Tree> deque = new ArrayDeque <>();
        boolean leftToRight = true;
        deque.addLast(root);
        last = root;
        System.out.print("Level " + level +" : ");
        while (!deque.isEmpty()) {
            Tree temp = leftToRight ? deque.removeFirst() : deque.removeLast();
            System.out.print(" "+temp.value+" ");
            if(leftToRight){
                if(temp.left != null){
                    deque.addLast(temp.left);
                }
                if(temp.right != null){
                    deque.addLast(temp.right);
                }
            }else{
                if(temp.right != null){
                    deque.addFirst(temp.right);
                }
                if(temp.left != null){
                    deque.addFirst(temp.left);
                }
            }

            if(temp == last){
                if(!deque.isEmpty()){
                    System.out.println();
                    leftToRight = !leftToRight;
                    last = leftToRight ? deque.getLast() : deque.getFirst();
                    level++;
                    System.out.print("Level " + level +" :");

                }
            }
        }
    }

    public static void main(String[] args) {
        Tree t7 = new Tree(7);
        Tree t8 = new Tree(8);
        Tree t5 = new Tree(5,t7,t8);
        Tree t6 = new Tree(6);
        Tree t3 = new Tree(3,t5,t6);
        Tree t4 = new Tree(4);
        Tree t2 = new Tree(2,t4,null);
        Tree t1 = new Tree(1,t2,t3);
        printInLevel(t1);
        System.out.println();
        System.out.println("-------------------");
        printInZigZag(t1);
    }
}
