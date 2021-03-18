package Chapter0_其他.Q1590_使数组和能被P整除;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/03/2021 22:56
 **/

public class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int num : nums){
            sum += num;
        }
        //计算整个数组和对p求余数,如果这个余数为0，那么就可以直接返回0
        int mod = (int)(sum % p);
        if(mod == 0){
            return 0;
        }
        HashMap <Integer,Integer> map = new HashMap();
        sum = 0;
        //当i到达数组最后一个元素时,gap计算等于0，此时res = nums.length
        //这种情况要用这种方法进行特殊处理
        map.put(0,-1);
        int res = nums.length;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int curMod = (int)(sum % p);
            //求得前面的数组和对p的余数,然后计算和全数组和的余数之间的差值
            //如果数组中存在这个值，表示将中间的一段数字删除后，剩余的就是数字和
            //可以被数字p整除
            int gap = curMod >= mod ? curMod - mod : curMod - mod + p;
            if(map.containsKey(gap)){
                res = Math.min(res, i - map.get(gap));
            }
            map.put(curMod,i);
        }
        //当res == nums.length，表示没有一个子数组可以满足要求
        return res == nums.length ? -1 : res;
    }
}
