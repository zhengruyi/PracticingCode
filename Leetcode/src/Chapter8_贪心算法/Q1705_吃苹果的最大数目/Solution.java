package Chapter8_贪心算法.Q1705_吃苹果的最大数目;

import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/02/2021 23:45
 **/

public class Solution {
    /**
     * 贪心算法，优先吃快要过期的苹果
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue <int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int index = 0;
        int res = 0;
        while(true){
            //将今天生长的苹果加上过期的日子,放在一起,存在优先队列中
            if(index < apples.length && apples[index] > 0){
                pq.offer(new int[]{index + days[index], apples[index]});
            }
            //如果后续不存在新苹果且所偶遇苹果都已经腐烂,就退出
            if(index >= apples.length && pq.isEmpty()){
                break;
            }
            //将优先队列中那些已经腐烂的苹果,和已经吃完的苹果,全部剔除出去
            while(!pq.isEmpty() && (pq.peek()[0] <= index || pq.peek()[1] <= 0)){
                pq.poll();
            }
            //吃掉一个苹果,计数加1
            if(!pq.isEmpty()){
                pq.peek()[1] -= 1;
                res++;
            }
            index++;
        }
        return res;
    }
}
