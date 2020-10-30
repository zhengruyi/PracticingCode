package Chapter10_动态规划.Q213_打家劫舍II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/10/2020 20:03
 **/

public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        //由于首尾相连，所以存在两种可能，抢劫第一家，则可抢劫的区间是0~nums.length-1
        //不抢劫第一家,那么抢劫的区间是1~nums.length,选择两者之间的最大值返回即可
        int m1 = getMax(nums,0,nums.length -1);
        int m2 = getMax(nums,1,nums.length);
        return Math.max(m1,m2);
    }
    public int getMax(int[] nums, int start, int end){
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        int dp_i = 0;
        for(int i = end -1 ;i >=start ; i--){
            dp_i = Math.max(dp_i,nums[i]+dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}
