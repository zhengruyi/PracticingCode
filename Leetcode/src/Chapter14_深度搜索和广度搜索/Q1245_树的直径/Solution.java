package Chapter14_深度搜索和广度搜索.Q1245_树的直径;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/12/2020 20:45
 **/

public class Solution {
    HashMap <Integer, List <Integer>> map = new HashMap<>();
    int res = 0;
    public int treeDiameter(int[][] edges) {
        for(int[] edge : edges){
            //哈希表构造图
            List<Integer> tmp = map.getOrDefault(edge[0],new ArrayList <>());
            tmp.add(edge[1]);
            map.put(edge[0], tmp);
            tmp = map.getOrDefault(edge[1],new ArrayList<>());
            tmp.add(edge[0]);
            map.put(edge[1],tmp);
        }
        dfs(map,0,new boolean[map.size()]);
        return res;
    }
    public int dfs(HashMap<Integer,List<Integer>> map, int index, boolean[] visited){
        visited[index] = true;
        int max1 = 0;
        int max2 = 0;
        //获取所有和他相连节点的最长的两个子链长度
        for(int next : map.get(index)){
            if(!visited[next]){
                int num = dfs(map,next,visited);
                if(num > max1){
                    max2 = max1;
                    max1 = num;
                }else if(num > max2){
                    max2 = num;
                }
            }
        }
        //树的最大长度等于最长的两个子链长度的和
        res = Math.max(res,max1 + max2);
        //返回上层时只能选择子链中长度最长的其中一个，当上当前节点
        return Math.max(max1,max2) + 1;
    }
}
