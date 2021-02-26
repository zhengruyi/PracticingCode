package Chapter0_其他.Q743_网络延迟时间;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/02/2021 23:31
 **/

public class Solution {
    /**
     * 先用哈希表构建好有向图,然后将到目的地的组合放入堆中,堆中优先是距离，然后是目的地
     * 每次取出距离最小的点，然后记入哈希表中，根据当前点的邻居，构建距离-目的地的数组放入堆中
     * 计算距离时要加上起始点到当前点的距离. 这就是dijstra算法没用来计算单点到其他点的最短距离
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap <Integer, List <int[]>> map = new HashMap();
        //构建有向图
        for(int[] path : times){
            if(!map.containsKey(path[0])){
                map.put(path[0],new ArrayList());
            }
            map.get(path[0]).add(new int[]{path[1],path[2]});
        }
        //记录点是否去过
        boolean[] visited = new boolean[n+1];
        HashMap<Integer,Integer> res = new HashMap();
        //创建根据到所有点的最短距离排序的堆
        PriorityQueue <int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.offer(new int[]{0,k});
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int dist = tmp[0];
            int node = tmp[1];
            //目的地的最短距离已经构成，不需要在修改
            if(res.containsKey(node)){
                continue;
            }
            //到node的最短距离
            res.put(node,dist);
            if(map.containsKey(node)){
                //将所有邻居的距离和目的地构成数组放入堆中
                for(int[] neighbor : map.get(node)){
                    if(!res.containsKey(neighbor[0])){
                        pq.offer(new int[]{dist + neighbor[1],neighbor[0]});
                    }
                }
            }
        }
        //查看是否所有点都能到达
        if(res.size() != n){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        //选取到达单点的最长时间
        for(int dist : res.values()){
            max = Math.max(dist,max);
        }
        return max;
    }
}
