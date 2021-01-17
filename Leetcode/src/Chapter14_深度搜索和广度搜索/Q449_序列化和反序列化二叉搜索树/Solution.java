package Chapter14_深度搜索和广度搜索.Q449_序列化和反序列化二叉搜索树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/01/2021 21:05
 **/

public class Solution {
    /**
     * 二叉搜索树的前序遍历就是单调递增序列,所以前序遍历就是一种
     * 序列化方法，然而对于一般的二叉树，至少需要中序和前序或者后序中的一种
     * 才能唯一确定一种二叉树结构
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        build(root, builder);
        //末尾会多出一个空格，所以要用trim()方法去掉
        return builder.toString().trim();
    }

    public void build(TreeNode root, StringBuilder builder) {
        if (root == null) {
            return;
        }
        //采用空格作为分隔符，因为节点的值可能不只有一位
        builder.append(root.val);
        builder.append(" ");
        build(root.left, builder);
        build(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        //按照空格切分字符串，并且用函数把字符串转化成数字数组
        String[] strs = data.split("\\s+");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        //构建根节点
        TreeNode root = new TreeNode(nums[start]);
        int index = start + 1;
        //找到左右子树的分界点
        while (index <= end && nums[index] < nums[start]) {
            index++;
        }
        //递归构造左右子树
        root.left = dfs(nums, start + 1, index - 1);
        root.right = dfs(nums, index, end);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}