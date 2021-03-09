package Chapter15_面试题.Q0401_节点间通路;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/03/2021 23:08
 **/

public class Solution {
    /**
     * 首先用hashMap来构建有向连接图,最后用广度遍历来搜索可达性
     * 如果是无向图，可以用并查集来验证可达性
     * @param n
     * @param graph
     * @param start
     * @param target
     * @return
     */
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        HashMap<Integer, List <Integer>> map = new HashMap();
        for(int[] edge : graph){
            if(!map.containsKey(edge[0])){
                map.put(edge[0],new ArrayList());
            }
            map.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList <>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(curr == target){
                return true;
            }
            visited[curr] = true;
            if(map.containsKey(curr)){
                for(int next : map.get(curr)){
                    if(!visited[next]){
                        queue.offer(next);
                    }
                }
            }
        }
        return false;
    }
}
