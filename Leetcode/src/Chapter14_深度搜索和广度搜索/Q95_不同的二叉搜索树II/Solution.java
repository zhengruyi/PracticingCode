package Chapter14_深度搜索和广度搜索.Q95_不同的二叉搜索树II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/01/2021 20:10
 **/

public class Solution {
    /**
     * 运用二叉搜索树的性质，和利用中序的前序遍历重建二叉树一样，递归构建左右子树
     * @param n
     * @return
     */
    public List <TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList <>();
        }
        //因为数字是从1..n
        return dfs(n, 1, n);
    }

    public List <TreeNode> dfs(int n, int start, int end) {
        List <TreeNode> res = new ArrayList <>();
        //空列表返回null的列表
        if (start > end) {
            res.add(null);
            return res;
        }
        //列表中只有一个节点
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        for (int i = start; i <= end; i++) {
            //左边列表构建成子树
            List <TreeNode> left = dfs(n, start, i - 1);
            //右边列表构建成子树
            List <TreeNode> right = dfs(n, i + 1, end);
            //结果是求总的数目，所以等于左右子树种类的乘积
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
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