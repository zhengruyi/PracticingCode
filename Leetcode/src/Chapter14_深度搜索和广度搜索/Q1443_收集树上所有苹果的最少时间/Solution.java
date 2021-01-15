package Chapter14_深度搜索和广度搜索.Q1443_收集树上所有苹果的最少时间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/01/2021 21:26
 **/

public class Solution {
    int ans = 0;
    public int minTime(int n, int[][] edges, List <Boolean> hasApple) {
        List<List<Integer>> nodeMap = new ArrayList <>(n);
        //创建无向图
        for(int i = 0; i < n; i++){
            nodeMap.add(new ArrayList<>());
        }
        //把点用边连起来
        for(int[] edge : edges){
            nodeMap.get(edge[0]).add(edge[1]);
            nodeMap.get(edge[1]).add(edge[0]);
        }
        //创建反向链接的数组，即从叶子通向根的路径
        int[] reverseEdge = new int[n];
        //初始值设置成-1
        Arrays.fill(reverseEdge,-1);
        //标记节点是否访问过
        boolean[] visited = new boolean[n];
        //因为不能保证数组中的第一个元素是起点，第二个元素是终点
        //所以用先构建图的方式找到反向链接的点
        builderReverseEdge(nodeMap,reverseEdge,0);
        //根节点标记成已访问
        visited[0] = true;
        for(int i = 0; i < n; i++){
            if(hasApple.get(i)){
                //如果当前叶子节点有苹果，那么往根方向遍历，知道遇到的节点已经访问过
                dfs(reverseEdge,visited,i);
            }
        }
        //中国走过的边数 * 2，因为往返
        return ans * 2;
    }
    public void builderReverseEdge(List<List<Integer>> nodeMap, int[] reverseEdge, int val){
        for(int connected : nodeMap.get(val)){
            //防止出现自环或者节点已访问过
            if(connected != val && reverseEdge[connected] == -1){
                reverseEdge[connected] = val;
                builderReverseEdge(nodeMap,reverseEdge,connected);
            }
        }
    }
    public void dfs(int[] reverseEdge, boolean[] visited, int start){
        //一直往根节点回溯，直到父节点已经被访问过
        if(!visited[start]){
            ans++;
            visited[start] = true;
            dfs(reverseEdge,visited,reverseEdge[start]);
        }
    }
}
