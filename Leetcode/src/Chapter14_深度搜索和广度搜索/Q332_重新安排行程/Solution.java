package Chapter14_深度搜索和广度搜索.Q332_重新安排行程;

import java.util.*;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/01/2021 19:23
 **/

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new LinkedList <>();
        if(tickets == null || tickets.size() == 0){
            return res;
        }
        //由于按照字符顺序从小到大排列
        Map <String, PriorityQueue <String>> map = new HashMap <>();
        for(List <String> ss : tickets){
            //将机票按出发点归类到目的地堆中,堆按照字符顺序排序
            if(map.containsKey(ss.get(0))){
                map.get(ss.get(0)).add(ss.get(1));
            }else{
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(ss.get(1));
                map.put(ss.get(0),pq);
            }
        }
        //由于必须把所有路线走一遍，且在这个条件下按字符顺序排列路线
        dfs(map,"JFK",res);
        return res;
    }
    public void dfs(Map<String,PriorityQueue<String>> map,String src, List<String> res){
        PriorityQueue<String> pq = map.get(src);
        while(pq != null && pq.size() > 0){
            String dest = pq.poll();
            dfs(map,dest,res);
        }
        //这里是防止路虽然字符顺序在前，但却是终点所以就逆序插入
        res.add(0,src);
    }
}
