package Chapter10_动态规划.Q325_和等于k的最长子数组长度;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/11/2020 21:00
 **/

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map <Integer,Integer> map = new HashMap <Integer,Integer>();
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            //表示从0到当前位置的和刚好等于k,则这个值肯定是当前情况下的最大值
            if(sum == k){
                ans = i + 1;
            }
            //判断是否可以和前面某个数字构成区间和，使他刚好等于k
            if(map.containsKey(sum - k)){
                //这里不是i - map.get(sum - k)+1,因为对于前缀和来说，减出来的值刚好等于区间长度
                ans = Math.max(ans, i - map.get(sum - k));
            }
            //后续不用更新，因为要求出最长的子数组
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return ans;
    }
}
