package Chapter0_其他.Q1046_最后一块石头的重量;

import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/04/2021 14:46
 **/

public class Solution {
    public int lastStoneWeight(int[] stones) {
        //因为采用Integer类型,所以这里用Integer.compare()方法来构建大顶堆
        PriorityQueue <Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2,o1));
        for(int stone : stones){
            pq.offer(stone);
        }
        //当堆里面的石头数量小于2才会停止
        while(pq.size() >= 2){
            int n1 = pq.poll();
            int n2 = pq.poll();
            int gap = Math.abs(n1 - n2);
            if(gap > 0){
                pq.offer(gap);
            }
        }
        if(pq.size() == 0){
            return 0;
        }
        return pq.poll();
    }
}
