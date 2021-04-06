package Chapter14_深度搜索和广度搜索.Q988_从叶结点开始的最小字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/04/2021 22:37
 **/

public class Solution {
    String min = "z";

    /**
     * 简单的dfs，从根遍历到叶子节点,然后将StringBuilder翻转来获得
     * 从叶子节点到根节点的字符串,这里注意对StringBuilder的翻转是永久性的
     * 所以要再次翻转回到从根节点到叶子节点的顺序,然后再删去当前位置的节点的值
     * @param root
     * @return
     */
    public String smallestFromLeaf(TreeNode root) {
        if(root == null){
            return "";
        }
        dfs(root,new StringBuilder());
        return min;
    }
    public void dfs(TreeNode root, StringBuilder builder){
        builder.append((char)(root.val + 'a'));
        if(root.left == null && root.right == null){
            String s = builder.reverse().toString();
            if(s.compareTo(min) < 0){
                min = s;
            }
            builder.reverse();
            builder.deleteCharAt(builder.length() - 1);
            return;
        }
        if(root.left != null){
            dfs(root.left, builder);
        }
        if(root.right != null){
            dfs(root.right,builder);
        }
        builder.deleteCharAt(builder.length() - 1);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}