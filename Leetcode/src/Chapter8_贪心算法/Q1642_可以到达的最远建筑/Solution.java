package Chapter8_贪心算法.Q1642_可以到达的最远建筑;

import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/03/2021 23:19
 **/

public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if(heights.length <= 1){
            return 0;
        }
        PriorityQueue <Integer> pq = new PriorityQueue();
        for(int i = 1; i < heights.length; i++){
            if(heights[i] > heights[i-1]){
                //将高度差放入优先队列
                pq.offer(heights[i] - heights[i-1]);
                //表示到当前位置时,需要的阔过的高度差超过了梯子的数目,那么如果砖头足够多
                //可以将最短的那段高度差用砖头，其余用梯子
                if(pq.size() > ladders){
                    int min = pq.poll();
                    //统一定量的砖头代替梯子
                    if(bricks >= min){
                        bricks -= min;
                    }else{
                        return i - 1;
                    }
                }
            }
        }
        return heights.length - 1;
    }
}
