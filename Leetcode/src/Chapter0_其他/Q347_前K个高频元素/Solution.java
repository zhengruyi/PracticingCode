package Chapter0_其他.Q347_前K个高频元素;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 22:21
 **/

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> map = new HashMap<>();
        //统计出现频率
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        //根据出现频率进行排序,小顶堆，堆顶元素是所有堆中出现频率最小的
        PriorityQueue <Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for(int i : map.keySet()){
            if(pq.size() < k ){
                pq.offer(i);
            }else{
                if(map.get(i) > map.get(pq.peek())){
                    pq.poll();
                    pq.offer(i);
                }
            }
        }
        //遍历完后，堆中就是结果
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }
        return res;
    }
}
