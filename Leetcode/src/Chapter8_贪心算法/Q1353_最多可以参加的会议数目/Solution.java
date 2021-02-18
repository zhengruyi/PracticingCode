package Chapter8_贪心算法.Q1353_最多可以参加的会议数目;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/02/2021 22:16
 **/

public class Solution {
    /**
     * 贪心思想:将同一时刻开始的会议放入队列中,然后选取结束最早的会议计数
     * @param events
     * @return
     */
    public int maxEvents(int[][] events) {
        //对数组排序
        Arrays.sort(events,(a, b) -> a[0] - b[0]);
        int res = 0, n = events.length, last = 1, i = 0;
        //创建优先队列,小顶堆优先读取结束最早的会议
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        while(i < n || !pq.isEmpty()){
            //将同一起始时刻的会议放入队列
            while(i < n && events[i][0] == last){
                pq.offer(events[i++][1]);
            }
            //将结束时刻在起始之前的会议弹出
            while(!pq.isEmpty() && pq.peek() < last){
                pq.poll();
            }
            //选取结束最早的弹出,总数目加1
            if(!pq.isEmpty()){
                pq.poll();
                res++;
            }
            last ++;
        }
        return res;
    }
}
