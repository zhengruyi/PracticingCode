package Q27_二叉搜索树与双向链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/04/2020 13:14
 **/

public class DoubleLinkedList {
    public static Node tranformTreeToLinkedList(Tree root, int value) {
        if (root == null)
            return null;
        Node mid = new Node(root.value, null, null);
        if (root.left != null) {
            Node temp = tranformTreeToLinkedList(root.left, value);
            mid.prev = temp;
            temp.next = mid;
        }

        if (root.right != null) {
            Node temp = tranformTreeToLinkedList(root.right, value);
            mid.next = temp;
            temp.prev = mid;
        }
        if(root.value < value && root.right != null){
            return mid.next;
        }
        else if(root.value > value && root.left != null){
            return mid.prev;
        }
        else
            return mid;
    }

    public static void main(String[] args) {
        Tree leaf4 = new Tree(4, null, null);
        Tree leaf8 = new Tree(8, null, null);
        Tree leaf12 = new Tree(12, null, null);
        Tree leaf16 = new Tree(16, null, null);
        Tree t6 = new Tree(6, leaf4, leaf8);
        Tree t14 = new Tree(14, leaf12, leaf16);
        Tree root = new Tree(10, t6, t14);
        Node mid = tranformTreeToLinkedList(root,10);
        while (mid.prev != null){
            mid = mid.prev;
        }
        while (mid != null){
            System.out.println(mid.value);
            mid = mid.next;
        }

    }
}


class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int value, Node next, Node prev) {
        this.value = value;
        this.prev = prev;
        this.next = next;
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
