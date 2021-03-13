package Chapter0_其他.Q1647_字符频次唯一的最小删除次数;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/03/2021 23:15
 **/

public class Solution {
    public int minDeletions(String s) {
        int[] times = new int[26];
        //统计所偶遇字符的出现次数
        for(int i = 0; i < s.length(); i++){
            times[s.charAt(i) - 'a']++;
        }
        //对频率进行统计
        Arrays.sort(times);
        //字符出现频率的最大值
        int max = times[25];
        int res = 0;
        //从后往前遍历，因为只能删除，所以从后往前遍历
        for(int i = 24; i >= 0; i--){
            //前面的也都是0,，直接跳出
            if(times[i] == 0){
                break;
            }
            //更新当前频率的最大值，超出则需要减去，直到为0
            max = max > 0 ?  -- max : 0;
            //累加需要删去的字符数目
            if(times[i] > max){
                res +=  times[i] - max;
            }
            //更新下一个字符的出现频率的最大值
            max = Math.min(times[i],max);
        }
        return res;
    }
}
