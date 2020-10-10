package Q6_重建二叉树;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/04/2020 21:27
 **/

public class ReconstructBinaryTree {
    public Tree reconstruct(int[] preOrder, int[] inOrder, int length) throws Exception {
        if (preOrder == null || inOrder == null || length <= 0)
            return null;
        return constructCore(preOrder, inOrder, 0, length - 1, 0, length - 1);
    }

    public Tree constructCore(int[] preOrder, int[] inOrder, int startPre, int endPre, int startIn, int endIn) throws Exception {
        // 前序遍历的第一个值是根节点
        int rootValue = preOrder[startPre];
        Tree root = new Tree(rootValue, null, null);
        //如果当前序列中只有一个元素就返回，条件是前序遍历和中序遍历都只有一个元素
        if (startPre == endPre) {
            if (startIn == endIn && preOrder[startPre] == inOrder[startIn])
                return root;
            else
                throw new Exception("Invalid Input");

        }
        //在中序遍历中找到根节点的值，根节点左边都属于左子树，右侧都属于右侧子树
        int rootInorder = startIn;
        while (rootInorder <= endIn && inOrder[rootInorder] != rootValue)
            ++rootInorder;
        // 如果找不到对应的根节点值则无法重建子树
        if (rootInorder == endIn && inOrder[rootInorder] != rootValue)
            throw new Exception("Invalid Input");
        // 就算出左子树的长度
        int leftLength = rootInorder - startIn;
        //计算出左子树的末端
        int leftPreEnd = startPre + leftLength;
        //如果有左子树则迭代构建左子树
        if (leftLength > 0) {
            // startPre此时指向根节点，所以加1来指向左子树的根节点，此时rootInorder指向当前根节点，减1指向左子树的中序遍历末端
            root.left = constructCore(preOrder, inOrder, startPre + 1, leftPreEnd, startIn, rootInorder - 1);
        }
        if (leftLength < endPre - startPre) {
            // 前序遍历中右子树跟在左子树后面，中序遍历中右子树跟在根节点之后
            root.right = constructCore(preOrder, inOrder, leftPreEnd + 1, endPre, rootInorder + 1, endIn);
        }
        return root;
    }


    @Test
    void test() throws Exception {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4,7,2,1,5,3,8,6};
        int length = 8;
        Tree root = reconstruct(pre,in,length);
        Assertions.assertEquals(2,root.left.value);
        Assertions.assertEquals(3,root.right.value);
        Assertions.assertEquals(4,root.left.left.value);
        Assertions.assertEquals(5,root.right.left.value);
        Assertions.assertEquals(7,root.left.left.right.value);
    }
}

class Tree {
    public int value;
    public Tree left;
    public Tree right;

    Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
