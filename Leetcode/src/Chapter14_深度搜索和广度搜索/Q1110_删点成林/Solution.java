package Chapter14_深度搜索和广度搜索.Q1110_删点成林;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/02/2021 22:56
 **/

public class Solution {
    Set <Integer> set;
    List <TreeNode> res;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet();
        res = new ArrayList();
        for(int num : to_delete){
            set.add(num);
        }
        dfs(root,null);
        return res;
    }

    /**
     * 当parent为null时表示，这个节点是一颗离散树，所以要加入结果集中
     * @param node
     * @param parent
     * @return
     */
    public TreeNode dfs(TreeNode node,TreeNode parent){
        if(node == null){
            return null;
        }
        //检查当前节点是否要被删除
        TreeNode next = node;
        if(set.contains(node.val)){
            next = null;
        }
        //返回左右子树的结果
        TreeNode left = dfs(node.left,next);
        TreeNode right = dfs(node.right,next);
        node.left = left;
        node.right = right;
        //如果父节点是要被删除的节点，且当前节点不会被删除，就把当前节点加入结果集
        if(parent == null && next != null){
            res.add(node);
            //当前节点要删除，那么久返回null
        }else if(next == null){
            return null;
        }
        //返回当前节点作为根节点的树
        return node;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}