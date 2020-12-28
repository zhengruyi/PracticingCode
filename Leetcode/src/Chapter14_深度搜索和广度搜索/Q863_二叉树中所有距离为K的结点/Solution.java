package Chapter14_深度搜索和广度搜索.Q863_二叉树中所有距离为K的结点;

import java.util.*;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/12/2020 23:12
 **/

public class Solution {
    Map <TreeNode, TreeNode> parent;
    public List <Integer> distanceK(TreeNode root, TreeNode target, int K) {
        //根据当前节点来找到父节点
        parent = new HashMap <>();
        dfs(root,null);
        //广度遍历来找到所有距离为k的节点
        LinkedList <TreeNode> queue = new LinkedList<>();
        //排除已经遍历过的节点
        Set<TreeNode> set = new HashSet <>();
        //添加起始节点
        queue.offer(target);
        set.add(target);
        int dist = 0;
        //每轮遍历，距离就会加1，知道等于k,此时队列中的节点就是所有到目标距离为k的节点集合
        while(!queue.isEmpty()){
            int size = queue.size();
            if(dist == K){
                List<Integer> res =  new ArrayList<>();
                for(int i = 0; i < size; i++){
                    res.add(queue.poll().val);
                }
                return res;
            }else{
                for(int i = 0; i < size; i++){
                    TreeNode tmp = queue.poll();
                    if( tmp.left != null && !set.contains(tmp.left)){
                        set.add(tmp.left);
                        queue.offer(tmp.left);
                    }
                    if(tmp.right != null && !set.contains(tmp.right)){
                        set.add(tmp.right);
                        queue.offer(tmp.right);
                    }
                    TreeNode par = parent.get(tmp);
                    if(par != null && !set.contains(par)){
                        set.add(par);
                        queue.offer(par);
                    }
                }
            }
            dist++;
        }
        return new ArrayList<>();
    }

    /**
     * 建立子节点到父节点的指针
     * @param node
     * @param par
     */
    public void dfs(TreeNode node,TreeNode par){
        if(node != null){
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right,node);
        }
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}