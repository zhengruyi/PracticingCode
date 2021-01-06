package Chapter0_其他.Q703_数据流中的第K大元素;

import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/01/2021 18:41
 **/

class KthLargest {
    private PriorityQueue <Integer> pq;
    private int limit;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>(k);
        this.limit = k;
        for(int num : nums){
            this.add(num);
        }
    }

    /**
     * 本质就是小顶堆，堆顶元素就是最小的元素,也就是目标答案
     * @param val
     * @return
     */
    public int add(int val) {
        if(pq.size() < limit){
            pq.add(val);
        }else if(val > pq.peek()){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
