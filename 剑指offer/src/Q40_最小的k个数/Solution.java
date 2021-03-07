package Q40_最小的k个数;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/03/2021 23:01
 **/

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr.length == 0){
            return new int[]{};
        }
        //设置大顶堆，堆的大小为k,如果小于堆顶元素就是前k个元素
        PriorityQueue <Integer> pq = new PriorityQueue(new Comparator <Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        //维护堆里面的元素,大于堆顶元素就直接忽略，小于则移除堆顶元素，加入新的元素
        //重新维护堆
        for(int num : arr){
            if(pq.size() < k){
                pq.offer(num);
            }else if(pq.peek() > num){
                pq.poll();
                pq.offer(num);
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }
        return res;
    }
}
