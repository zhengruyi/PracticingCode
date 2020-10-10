package Q23_从上往下打印二叉树;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/04/2020 14:50
 **/

public class WideTravesalTree {
    public static void traversal(Tree root) {
        LinkedBlockingDeque <Tree> deque = new LinkedBlockingDeque <>();
        if (root == null)
            return;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            Tree temp = deque.removeFirst();
            System.out.println(temp.value);
            if (temp.left != null)
                deque.addLast(temp.left);
            if (temp.right != null)
                deque.addLast(temp.right);
        }

    }

    public static void main(String[] args) {
        Tree leaf1 = new Tree(4, null, null);
        Tree leaf2 = new Tree(3, null, null);
        Tree t2 = new Tree(2, leaf2, leaf1);

        Tree leaf3 = new Tree(6, null, null);
        Tree leaf4 = new Tree(7, null, null);
        Tree t5 = new Tree(5, leaf3, leaf4);
        Tree root = new Tree(1, t2, t5);
        traversal(root);
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
