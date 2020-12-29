package Chapter8_贪心算法.Q621_任务调度器;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/12/2020 21:22
 **/

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] times = new int[26];
        //统计出现次数
        for(char c : tasks){
            times[c-'A']++;
        }
        //根据频率排序
        Arrays.sort(times);
        //出现频率最多的任务
        int maxTimes = times[25];
        //和最大出现频率一样的任务个数
        int maxCount = 1;
        for(int i = 25; i > 0; i--){
            if(times[i] == times[i-1]){
                maxCount++;
            }else{
                break;
            }
        }
        //任务分配存在两种情况，没有足够任务来填充空隙时，计算公式时
        //(maxTimes-1) *(n+1) + maxCount,当任务种类足够多时
        //总耗时就是全部任务的长度,取两者的最大值
        return Math.max((maxTimes - 1) * (n + 1) + maxCount,tasks.length);
    }
}
