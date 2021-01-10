package Q53_0到n减1中缺失的数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/01/2021 21:30
 **/

public class Solution {
    /**
     * 规则很简单,按照下标i+1就是0~n的所有数字，那么与数组元素异或过后剩下的值就是缺失的数字
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum ^ i+1 ^ nums[i];
        }
        return sum;
    }
}
