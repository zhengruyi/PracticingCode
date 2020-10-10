package Chapter3_二叉树问题.Q5_遍历二叉树的神级方法;

import Chapter3_二叉树问题.Tree;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/05/2020 19:51
 **/

public class Traverse {
    public static void inTraverse(Tree root) {
        if (root == null) {
            return;
        }
        Tree node = configureTreeInPostTraverse(root);
        while (node != null) {
            System.out.print(" " + node.value);
            node = node.right;
            if (getRightestNodeInLeftSubTree(node) != null) {
                //当前最右节点的右指针不指向自己，则树不满足需求，重新配置
                if (getRightestNodeInLeftSubTree(node).right != node) {
                    node = configureTreeInPostTraverse(node);
                } else {
                    //该节点已经输出，则把树恢复成原来
                    getRightestNodeInLeftSubTree(node).right = null;
                }
            }

        }
    }

    /**
     * 前序遍历实现方式，重点在于在配置过程中就要打印值
     *
     * @param root
     */
    public static void preTraverse(Tree root) {
        if (root == null) {
            return;
        }
        Tree node = configureTreePreTraverse(root);
        while (node != null) {
            if (getRightestNodeInLeftSubTree(node) == null) {
                System.out.print(" " + node.value);
            }
            node = node.right;
            if (getRightestNodeInLeftSubTree(node) != null) {
                //当前最右节点的右指针不指向自己，则树不满足需求，重新配置
                if (getRightestNodeInLeftSubTree(node).right != node) {
                    node = configureTreePreTraverse(node);
                } else {
                    //该节点已经输出，则把树恢复成原来
                    getRightestNodeInLeftSubTree(node).right = null;
                }
            }
        }
    }

    /**
     * 后续遍历，重点在于在回归子树根节点时采用逆序打印左子树有边界的方式来输出后续排列，最后要加上整棵树的右边界来完成整个后续输出
     * @param root
     */
    public static void postTraverse(Tree root) {
        if (root == null) {
            return;
        }

        Tree node = configureTreeInPostTraverse(root);
        while (node != null) {
            node = node.right;
            if (getRightestNodeInLeftSubTree(node) != null) {
                //当前最右节点的右指针不指向自己，则树不满足需求，重新配置
                if (getRightestNodeInLeftSubTree(node).right != node) {
                    node = configureTreeInPostTraverse(node);
                } else {
                    //该节点已经输出，则把树恢复成原来
                    getRightestNodeInLeftSubTree(node).right = null;
                    printLeftSubTreeRightEdge(node);
                }
            }
        }
        printReversedLinkedList(root);
    }

    /**
     * 函数用于输出左子树的右边界
     * @param root
     */
    public static void printLeftSubTreeRightEdge(Tree root){
        if(root == null || root.left == null){
            return;
        }
        printReversedLinkedList(root.left);
    }

    /**
     * 逆序输出链表，在打印完后再逆序一次进行恢复，链表是从左节点的右指针构成的
     * @param root
     */
    public static void printReversedLinkedList(Tree root){
        if(root == null){
            return;
        }
        Tree first = null;
        Tree mid = root;
        Tree last = null;
        while (mid != null){
            last = mid.right;
            mid.right = first;
            first = mid;
            mid = last;
        }


        Tree head = first;
        while (first != null){
            System.out.print(" "+first.value);
            first = first.right;
        }


        first = null;
        mid = head;
        last = null;
        while (mid != null){
            last = mid.right;
            mid.right = first;
            first = mid;
            mid = last;
        }
    }

    /**
     * 把树节点配置成左子树中最右节点连接到自己的特种树,用于前序遍历，因为在配置过程中就需要打印值
     *
     * @param root
     * @return
     */
    public static Tree configureTreePreTraverse(Tree root) {
        if (root == null) {
            return null;
        }
        while (getRightestNodeInLeftSubTree(root) != null) {
            System.out.print(" " + root.value);
            Tree temp = getRightestNodeInLeftSubTree(root);
            temp.right = root;
            root = root.left;
        }
        return root;
    }

    /**
     * 把树节点配置成左子树中最右节点连接到自己的特种树,用于中序遍历和后续遍历，不需要配置过程中打印值
     *
     * @param root
     * @return
     */
    public static Tree configureTreeInPostTraverse(Tree root) {
        while (getRightestNodeInLeftSubTree(root) != null) {
            Tree temp = getRightestNodeInLeftSubTree(root);
            temp.right = root;
            root = root.left;
        }
        return root;
    }

    /**
     * 找出当前节点中左子树中最右节点，判断条件节点的右指针指向空或者右指针执行当前节点，则该节点就是就满足需要，返回就可以.
     *
     * @param root
     * @return
     */
    public static Tree getRightestNodeInLeftSubTree(Tree root) {
        if (root == null || root.left == null) {
            return null;
        }
        Tree right = root.left;
        while (right.right != root && right.right != null) {
            right = right.right;
        }
        return right;
    }

    public static void main(String[] args) {
        Tree t7 = new Tree(7);
        Tree t5 = new Tree(5);
        Tree t6 = new Tree(6, t5, t7);
        Tree t3 = new Tree(3);
        Tree t1 = new Tree(1);
        Tree t2 = new Tree(2, t1, t3);
        Tree t4 = new Tree(4, t2, t6);
        inTraverse(t4);
        System.out.println();
        preTraverse(t4);
        System.out.println();
        postTraverse(t4);
    }
}
