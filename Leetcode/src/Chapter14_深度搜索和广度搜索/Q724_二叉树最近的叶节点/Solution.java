package Chapter14_深度搜索和广度搜索.Q724_二叉树最近的叶节点;

import java.util.*;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/02/2021 23:40
 **/

public class Solution {
    //使用哈希表来构建双向链表来构建树的父子关系
    HashMap <TreeNode, List <TreeNode>> map;

    /**
     * 本质就是通过哈希表老构建此案父子关系,然后通过广度遍历找到最近的叶子节点
     * @param root
     * @param k
     * @return
     */
    public int findClosestLeaf(TreeNode root, int k) {
        map = new HashMap<>();
        //深度遍历建立关系树
        dfs(root,null);
        Queue <TreeNode> queue = new LinkedList <>();
        Set<TreeNode> set = new HashSet <>();
        //找到值为k的起始点
        for(TreeNode t : map.keySet()){
            if(t != null && t.val == k){
                queue.offer(t);
                set.add(t);
            }
        }
        //通过父子关系进行广度遍历,找到最近的叶子节点
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            if(t != null){
                //由于父节点的存在,所以链表长度不是0
                if(map.get(t).size() <= 1){
                    return t.val;
                }
                for(TreeNode tmp : map.get(t)){
                    //广度遍历找到最近的叶子节点,集合用来防止走回头路
                    if(!set.contains(tmp)){
                        queue.offer(tmp);
                        set.add(tmp);
                    }
                }
            }
        }
        return -1;
    }
    public void dfs(TreeNode root, TreeNode parent){
        if(root == null){
            return;
        }
        //构建父子关系
        if(!map.containsKey(root)){map.put(root,new LinkedList<>());}
        if(!map.containsKey(parent)){map.put(parent,new LinkedList<>());}
        map.get(root).add(parent);
        map.get(parent).add(root);
        dfs(root.left,root);
        dfs(root.right,root);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}