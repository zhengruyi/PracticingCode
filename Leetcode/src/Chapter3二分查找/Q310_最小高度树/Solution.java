package Chapter3二分查找.Q310_最小高度树;

import java.util.*;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/01/2021 22:51
 **/

public class Solution {
    /**
     * 基本思路就是在树上进行二分搜索，对所有度为1的节点进行广度遍历
     * 这样相当于从树的两端向中间遍历，那么最后一轮留下的节点就是最小高度树的根
     * @param n
     * @param edges
     * @return
     */
    public List <Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList <>();
        if(edges == null || edges.length == 0){
            res.add(0);
            return res;
        }
        //哈希表构建图
        Map <Integer,List<Integer>> graph = new HashMap <>();
        for(int i = 0; i < n; i++){
            graph.put(i,new ArrayList<>());
        }
        //记录节点的度，即这个节点和多少个节点相连
        int[] degree = new int[n];
        for(int[] edge : edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        //队列用于广度遍历
        Queue <Integer> queue = new LinkedList<>();
        for(int i = 0; i < degree.length; i++){
            if(degree[i] == 1){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            res = new ArrayList<>();
            for(int i = 0; i < size; i++){
                int root = queue.poll();
                res.add(root);
                for(int neighbor : graph.get(root)){
                    //更新相连节点的度
                    degree[neighbor]--;
                    //如果节点的度为1，则添加到队列中，进行广度遍历
                    if(degree[neighbor] == 1){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }
}
