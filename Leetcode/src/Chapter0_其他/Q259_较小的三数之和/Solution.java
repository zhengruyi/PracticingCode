package Chapter0_其他.Q259_较小的三数之和;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/02/2021 18:13
 **/

public class Solution {
    /**
     *  时间复杂度是O(N^2),因为j和k最多遍历一遍
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        //先排序来保证后续双指针的作用
        Arrays.sort(nums);
        int res = 0;
        //i的范围是 i..len-2
        for(int i = 0; i < nums.length - 2; i++){
            //后续两个指针的和不得超过sum
            int sum = target - nums[i];
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = nums.length - 1; k > j; k--){
                    //直接计算元组数目,跳出
                    if(nums[j] + nums[k] < sum){
                        res += k - j;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
