package Chapter0_其他.Q362_敲击计数器;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/12/2020 23:18
 **/

public class HitCounter {
    Queue <Integer> queue;
    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList <>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        //这里由于采用的是时间戳递增的序列，所以使用队列来存储，可以用很少的空间来存跨度较大的数据
        while(!queue.isEmpty() && timestamp - queue.peek() + 1 > 300){
            queue.poll();
        }
        return queue.size();
    }
}
