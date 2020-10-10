package Q31_连续子数组的最大和;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/04/2020 10:31
 **/

public class FindMaxSum {
    public int find(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Error");
        else if (nums.length == 1)
            return nums[0];

        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }

            max = sum > max ? sum : max;
        }
        return max;
    }
    @Test
    void test(){
        int[] nums = {1, -2, 3, 10, -4, 7, 2, -5};
        Assertions.assertEquals(18,find(nums));
        nums = new int[]{1, 1, 1, 1, 1, 2};
        Assertions.assertEquals(7,find(nums));
        nums = new int[]{-1, -2, -3, -4};
        Assertions.assertEquals(-1, find(nums));
    }


}
