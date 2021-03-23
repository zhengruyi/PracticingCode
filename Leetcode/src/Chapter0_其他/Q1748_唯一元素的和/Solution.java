package Chapter0_其他.Q1748_唯一元素的和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/03/2021 23:51
 **/

public class Solution {
    /**
     * 简单的统计次数,然后取出只出现一次的数字,求和就可以
     * @param nums
     * @return
     */
    public int sumOfUnique(int[] nums) {
        int[] times = new int[101];
        for(int index : nums){
            times[index]++;
        }
        int res = 0;
        for(int i = 0; i < times.length; i++){
            if(times[i] == 1){
                res += i;
            }
        }
        return res;
    }
}
