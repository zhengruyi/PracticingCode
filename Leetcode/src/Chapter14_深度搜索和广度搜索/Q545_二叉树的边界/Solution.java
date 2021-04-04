package Chapter14_深度搜索和广度搜索.Q545_二叉树的边界;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/04/2021 22:40
 **/

public class Solution {
    /**
     * 分别用来存放左边界，根节点和右边界的列表
     */
    List <Integer> left;
    LinkedList <Integer> right;
    List <Integer> leaves;

    public List <Integer> boundaryOfBinaryTree(TreeNode root) {
        left = new LinkedList <>();
        right = new LinkedList <>();
        leaves = new LinkedList <>();
        dfs(root, 0);
        //合并结果生成答案
        left.addAll(leaves);
        left.addAll(right);
        return left;
    }

    public void dfs(TreeNode root, int flag) {
        if (root == null) {
            return;
        }
        //根节点和左边界节点放入左边界列表中
        if (flag == 0 || flag == 1) {
            left.add(root.val);
            //右边界节点倒序插入
        } else if (flag == 2) {
            right.addFirst(root.val);
            //叶子节点放入叶子节点列表
        } else if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        //前序方式遍历左右子树
        dfs(root.left, leftFlag(root, flag));
        dfs(root.right, rightFlag(root, flag));
    }

    /**
     * 这里flag = 0 表示根节点,1表示是左边界,2表示是右边界,3是其他节点
     * 左边界的定义:
     *
     * 1. 根节点的左子节点在左边界中。如果根节点不含左子节点，那么左边界就为 空 。
     * 2. 如果一个节点在左边界中，并且该节点有左子节点，那么它的左子节点也在左边界中。
     * 3. 如果一个节点在左边界中，并且该节点 不含 左子节点，那么它的右子节点就在左边界中。
     * 4. 最左侧的叶节点 不在 左边界中。
     *
     * @param root
     * @param flag
     * @return
     */
    public int leftFlag(TreeNode root, int flag) {
        //根节点也放在左边界列表中,其余的符合条件2
        if (flag == 0 || flag == 1) {
            return 1;
            //右边界的定义
        } else if (flag == 2 && root.right == null) {
            return 2;
            //其他节点
        } else {
            return 3;
        }
    }

    /**
     * 右边界的定义:
     * 1. 右边界是根节点右子树的右侧部分；
     * 2. 叶节点 不是 右边界的组成部分；
     * 3. 如果根节点不含右子节点，那么右边界为 空
     * @param root
     * @param flag
     * @return
     */
    public int rightFlag(TreeNode root, int flag) {
        if (flag == 0 || flag == 2) {
            return 2;
        } else if (flag == 1 && root.left == null) {
            return 1;
        } else {
            return 3;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}