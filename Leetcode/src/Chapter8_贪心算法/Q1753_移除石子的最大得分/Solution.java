package Chapter8_贪心算法.Q1753_移除石子的最大得分;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/03/2021 22:59
 **/

public class Solution {
    public int maximumScore(int a, int b, int c) {
        int[] nums = {a,b,c};
        Arrays.sort(nums);
        //如果较小的两个元素小于第三个元素，那么最大的分数就是两个较小的元素之和
        if(nums[0] + nums[1] <= nums[2]){
            return nums[0] + nums[1];
        }else{
            //如果较小的两个元素大于较大的元素，那么在将最大的石头堆全部取完后,两个较小的石头堆还可以取剩下的总数的一半
            return nums[2] + (nums[0] + nums[1] - nums[2]) /2;
        }
    }
}
