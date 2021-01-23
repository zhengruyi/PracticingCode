package Chapter14_深度搜索和广度搜索.Q366_寻找二叉树的叶子节点;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/01/2021 21:17
 **/

public class Solution {
    List <List <Integer>> res;

    public List <List <Integer>> findLeaves(TreeNode root) {
        res = new ArrayList <>();
        dfs(root);
        return res;
    }

    /**
     * 反向计算深度,将深度相同的叶子节点放入相同的列表
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        //当前节点的深度等于做左右子树的深度的最大值加1
        int depth = Math.max(left, right) + 1;
        //如果当前深度不存在,那么就添加一个新的列表
        if (depth - 1 >= res.size()) {
            res.add(new ArrayList <>());
        }
        //将当前叶子节点的值放入对应的列表中
        res.get(depth - 1).add(root.val);
        return depth;
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