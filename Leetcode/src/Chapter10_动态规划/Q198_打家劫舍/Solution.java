package Chapter10_动态规划.Q198_打家劫舍;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/10/2020 20:01
 **/

public class Solution {
    //备忘录保存已经计算过的值
    HashMap <Integer,Integer> map = new HashMap<>();
    public int rob(int[] nums) {
        return getMax(nums,0);
    }
    public int getMax(int[] nums, int i){
        if(i >= nums.length){
            return 0;
        }
        if(map.containsKey(i)){
            return map.get(i);
        }
        //如果抢劫当前这家，则只能抢劫第i+2家，不然就可以抢劫第i+1家
        int max = Math.max(nums[i]+getMax(nums,i+2), getMax(nums,i+1));
        //保存已经计算过的结果
        map.put(i,max);
        return max;
    }
}
