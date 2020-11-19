package Chapter10_动态规划.Q525_连续数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/11/2020 22:52
 **/

public class Solution {
    public int findMaxLength(int[] nums) {
        Map <Integer,Integer> map = new HashMap <Integer,Integer>();
        int count = 0;
        int res = 0;
        map.put(0,-1);
        //每遇到1则count加1，如果遇到0则count减1，当有遇到重复的count时，则表示中间有相等数目的0和1
        //这里将(0,-1)放入的目的是因为每次存入的是数组索引，那么对应部分的长度是就是当前索引+1，那么
        //这里将初始0的索引设置成-1，那么每次计算长度时直接用当前索引减去对应的值就可以
        //这里只保留初次的索引下标，是因为题目要求求出最长的子数组长度
        for(int i =0; i< nums.length; i++){
            count+= nums[i] == 1 ? 1 : -1;
            if(map.containsKey(count)){
                res = Math.max(res,i - map.get(count));
            }else{
                map.put(count,i);
            }
        }
        return res;
    }
}
