package Chapter0_其他.Q692_前K个高频单词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/12/2020 21:29
 **/

public class Solution {
    public List <String> topKFrequent(String[] words, int k) {
        HashMap <String,Integer> map = new HashMap<>();
        //统计单词出现频率
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        //根据单词出现频率排序，是大顶堆，堆顶元素出现频率最大
        //如果出现频率相等，那么就按照字符排序
        PriorityQueue <String> pq = new PriorityQueue<>((o1, o2) -> {
            if(map.get(o1) != map.get(o2)){
                return map.get(o2) - map.get(o1);
            }else{
                return o1.compareTo(o2);
            }
        });
        //最后添加所有元素
        for(String key : map.keySet()){
            pq.add(key);
        }
        //取前k位作为结果返回
        List<String> res = new ArrayList <>();
        for(int i = 0; i < k; i++){
            res.add(pq.poll());
        }
        return res;
    }
}
