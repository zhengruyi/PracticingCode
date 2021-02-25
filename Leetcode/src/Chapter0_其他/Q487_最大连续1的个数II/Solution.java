package Chapter0_其他.Q487_最大连续1的个数II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/02/2021 21:13
 **/

public class Solution {
    /**
     * 用一个变量记录窗口中的0的个数,如果窗口中的0的个数大于1，那么就
     * 继续收缩左边界,直到窗口中的0的个数小于等于1,最长的窗口就是答案
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int number0 = 0;
        int left = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                number0++;
            }
            while(number0 > 1){
                if(nums[left] == 0){
                    number0--;
                }
                left++;
            }
            res = Math.max(res,i - left + 1);
        }
        return res;
    }
}
