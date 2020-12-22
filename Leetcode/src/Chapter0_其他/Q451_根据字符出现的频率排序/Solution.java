package Chapter0_其他.Q451_根据字符出现的频率排序;

import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/12/2020 23:26
 **/

public class Solution {
    public String frequencySort(String s) {
        int len = s.length();
        int[] times = new int[128];
        //统计单词出现频率
        for(char c : s.toCharArray()){
            times[c]++;
        }
        //因为这里要求所有出现频率相同的单词靠在一起，所以这里用堆排序,大顶堆，堆顶的是最大值
        PriorityQueue <Character> pq = new PriorityQueue<>(128,(o1, o2)-> times[o2] - times[o1]);
        for(int i = 0; i < times.length;i++){
            if(times[i] != 0){
                //这里用强制转化将int转化成char型
                pq.offer((char)i);
            }
        }
        StringBuilder builder = new StringBuilder();
        while(!pq.isEmpty()){
            //获取频率最高的字符，填充字符串
            char c = pq.poll();
            while(times[c]-- > 0){
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
