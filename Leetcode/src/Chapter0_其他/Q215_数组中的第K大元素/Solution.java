package Chapter0_其他.Q215_数组中的第K大元素;

import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/12/2020 21:07
 **/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        //小顶堆，堆顶元素最小
        PriorityQueue <Integer> pq = new PriorityQueue<>(k);
        for(int i = 0; i < nums.length; i++){
            //里面容量为满，直接加入
            if(pq.size() < k){
                pq.offer(nums[i]);
                continue;
            }
            //开始更新，大于堆顶元素则替换掉堆顶元素
            if(nums[i] > pq.peek()){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}
