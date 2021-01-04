package Chapter0_其他.Q268_丢失的数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/01/2021 21:07
 **/

public class Solution {
    public int missingNumber(int[] nums) {
        //num 是0..n的整个异或结果，和数组中的元素异或后得到缺失的元素
        int num = 0;
        for(int i = 1; i <= nums.length; i++){
            num ^= i;
            num ^= nums[i-1];
        }
        return num;
    }
}
