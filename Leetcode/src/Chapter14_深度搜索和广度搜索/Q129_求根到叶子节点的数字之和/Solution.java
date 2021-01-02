package Chapter14_深度搜索和广度搜索.Q129_求根到叶子节点的数字之和;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/01/2021 22:58
 **/

public class Solution {
    List <Integer> list;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        list = new ArrayList <>();
        dfs(root,0);
        int sum = 0;
        //对列表的数字进行求和
        for(int num : list){
            sum += num;
        }
        return sum;
    }

    /**
     * dfs从根到叶子，把所有数字都保存到列表中
     * @param root
     * @param prefix
     */
    public void dfs(TreeNode root, int prefix){
        if(root.left == null && root.right == null){
            list.add(prefix * 10 + root.val);
            return;
        }
        if(root.left != null){
            dfs(root.left,prefix * 10 + root.val);
        }
        if(root.right != null){
            dfs(root.right,prefix * 10 + root.val);
        }
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
