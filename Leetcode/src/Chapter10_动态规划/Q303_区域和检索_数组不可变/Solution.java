package Chapter10_动态规划.Q303_区域和检索_数组不可变;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/11/2020 20:39
 **/

public class Solution {
    class NumArray {
        int[] sum;
        public NumArray(int[] nums) {
            sum = new int[nums.length+1];
            for(int i =1; i <= nums.length; i++){
                //前缀和数字，sum[i]是包含nums[i]在内的和
                sum[i] = sum[i-1] + nums[i-1];
            }
        }

        public int sumRange(int i, int j) {
            //nums数组中的i，j分别对应到sum数组中的i-1和j-1,而num[i:j]的数组和等于sum[j+1]-sum[i]
            return sum[j+1] - (i == 0 ? 0 : sum[i]);
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
