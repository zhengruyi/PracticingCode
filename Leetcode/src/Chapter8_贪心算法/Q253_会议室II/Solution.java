package Chapter8_贪心算法.Q253_会议室II;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/12/2020 23:55
 **/

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //首先按照开始时间升序排列,如果开始时间相同在按结束时间降序排列
        Arrays.sort(intervals,(o1, o2)-> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        //设置小顶堆，即对顶元素是全局的最小值
        PriorityQueue <Integer> pq = new PriorityQueue<>(new Comparator <Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });
        for(int i = 0; i < intervals.length; i++){
            //如果队列为空，或者当前会议的最早结束时间小于下个会议的开始时间
            //那么这件会议室可以复用
            if(!pq.isEmpty() && pq.peek() <= intervals[i][0]){
                pq.poll();
            }
            //如果不行的话就需要多开一间会议室
            pq.offer(intervals[i][1]);
        }
        //最终堆的体积就是最少需要的会议室数目
        return pq.size();
    }
}
