package Chapter15_面试题.Q1718_最短超串;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/03/2021 21:44
 **/

public class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        HashMap <Integer,Integer> need = new HashMap();
        //统计need字符串的总长度
        int diff = 0;
        //统计need字符串中的字符的出现种类和次数
        for(int num : small){
            need.put(num,need.getOrDefault(num,0) + 1);
            diff++;
        }
        int left = 0;
        int[] res = {};
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < big.length; i++){
            //更新窗口内的字符的出现次数
            if(need.containsKey(big[i])){
                int times = need.get(big[i]);
                //由于窗口中的字符的出现次数可能大于small字符串的出现次数
                //所以只有在在正数减少时，才能将diff减去1,负数部分不算
                if(times > 0){
                    diff--;
                }
                //更新出现次数
                need.put(big[i],--times);
            }
            //当diff = 0表示滑动窗口内的子串中包含了small所有的字符串
            while(diff == 0){
                //更新最短的区间长度
                if(i - left + 1< min){
                    min = i - left + 1;
                    //记录区间范围
                    res = new int[]{left,i};
                }
                //对剔除出去的字符进行记录,更新Need的出现次数
                //如果是从0变成1,那么就要修改diff++
                if(need.containsKey(big[left])){
                    if(need.get(big[left]) == 0){
                        diff++;
                    }
                    need.put(big[left],need.get(big[left]) + 1);
                }
                //更新左边界
                left++;
            }
        }
        return res;
    }
}
