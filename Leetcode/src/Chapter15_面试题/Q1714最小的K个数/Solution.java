package Chapter15_面试题.Q1714最小的K个数;

import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/01/2021 18:57
 **/

public class Solution {
    /**
     * 大顶堆，堆顶是最大的元素，如果当前元素比堆顶元素小
     * 那么就弹出堆顶元素，将较小的元素加入
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        if(k == 0){
            return res;
        }
        //堆默认是小顶堆，这里设置成大顶堆
        PriorityQueue <Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int num : arr){
            if(queue.size() < k){
                queue.add(num);
            }else if(queue.peek() > num){
                queue.poll();
                queue.add(num);
            }
        }
        int i = 0;
        while(!queue.isEmpty()){
            res[i++] = queue.poll();
        }
        return res;
    }
}
