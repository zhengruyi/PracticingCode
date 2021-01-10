package Chapter0_其他.Q1481_不同整数的最少的数目;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/01/2021 20:26
 **/

public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map <Integer,Integer> map = new HashMap <>();
        //对数字出现频率进行统计
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //将数字的频率放入到堆中,采用贪心的概念，优先将出现频率较低的字符移出去来减少
        //字符的种类
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        for(int time : map.values()){
            pq.add(time);
        }
        while(!pq.isEmpty() && k >= pq.peek()){
            k -= pq.poll();
        }
        //剩下的堆的大小就是不同字符的种类
        return pq.size();
    }
}
