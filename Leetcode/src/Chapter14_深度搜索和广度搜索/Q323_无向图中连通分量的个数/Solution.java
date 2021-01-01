package Chapter14_深度搜索和广度搜索.Q323_无向图中连通分量的个数;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/01/2021 22:45
 **/

public class Solution {
    HashMap<Integer, List <Integer>> map;
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        map = new HashMap <>();
        //哈希表构建图
        for(int i = 0; i < n; i++){
            map.put(i,new ArrayList <>());
        }
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        //深度遍历来访问图,每一次但单独的访问就是一个连通分量
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i,visited);
                count++;
            }
        }
        return count;
    }
    /**
     *记录图,用visited数组来记录哪些点已经访问过
     */
    public void dfs(int start,boolean[] visited){
        visited[start] = true;
        for(int neighbor : map.get(start)){
            if(!visited[neighbor]){
                dfs(neighbor,visited);
            }
        }
    }
}
