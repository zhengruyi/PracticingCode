package Chapter0_其他.Q1480_一维数组的动态和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/02/2021 22:15
 **/

public class Solution {
    //简单的求前缀和数组
    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            res[i] = res[i-1] + nums[i];
        }
        return res;
    }
}
