package Q18_树的子结构;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/04/2020 18:21
 **/

public class SubTree {
    public static boolean hasSubTree(Tree rootParent, Tree subTreeRoot) {
        if (rootParent == null || subTreeRoot == null)
            return false;
        boolean result = false;
        if (rootParent.value == subTreeRoot.value) {
            result = doesSameTree(rootParent, subTreeRoot);
        }
        if(!result){
            result = hasSubTree(rootParent.left, subTreeRoot) || hasSubTree(rootParent.right, subTreeRoot);
        }
        return result;
    }

    public static boolean doesSameTree(Tree root, Tree subRoot) {
        //可能存在root和subRoot同时为null,这是仍然包含子树，所以结果为true
        if (subRoot == null)
            return true;

        if (root == null)
            return false;

        if (root.value == subRoot.value) {
            return doesSameTree(root.left, subRoot.left) && doesSameTree(root.right,subRoot.right);
        } else
            return false;
    }

    @Test
    void test() {
        Tree leaf1 = new Tree(4, null, null);
        Tree leaf2 = new Tree(3, null, null);
        Tree t2 = new Tree(2, leaf2, leaf1);

        Tree leaf3 = new Tree(6, null, null);
        Tree leaf4 = new Tree(7, null, null);
        Tree t5 = new Tree(5, leaf3, leaf4);
        Tree root = new Tree(1, t2, t5);

        Assertions.assertTrue(hasSubTree(root, t2));
        Assertions.assertTrue(hasSubTree(root, t5));

        Tree n1 = new Tree(4, null, null);
        Tree n2 = new Tree(4, null, null);
        Tree n3 = new Tree(2, n2, n1);
        Assertions.assertFalse(hasSubTree(root,n3));

    }

    public static void main(String[] args) {
        Tree leaf1 = new Tree(4, null, null);
        Tree leaf2 = new Tree(3, null, null);
        Tree t2 = new Tree(2, leaf2, leaf1);

        Tree leaf3 = new Tree(6, null, null);
        Tree leaf4 = new Tree(7, null, null);
        Tree t5 = new Tree(5, leaf3, leaf4);
        Tree root = new Tree(1, t2, t5);

        Tree n1 = new Tree(4, null, null);
        Tree n2 = new Tree(3, null, null);
        Tree n0 = new Tree(2, n2, n1);
        System.out.println(hasSubTree(root,n0));
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