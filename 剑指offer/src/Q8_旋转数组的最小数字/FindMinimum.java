package Q8_旋转数组的最小数字;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/04/2020 19:27
 **/

public class FindMinimum {
    public static int find(int[] nums) throws Exception {
        if (nums == null || nums.length == 0)
            throw new Exception("invalid input");
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;
        if (nums[start] < nums[end]) {
            return nums[start];
        } else if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
            int temp = nums[start];
            for (int i = start + 1; i < nums.length; i++) {
                if (temp > nums[i])
                    temp = nums[i];
            }
            return temp;
        }

        while (end - start > 1) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start] && nums[mid] >= nums[end])
                start = mid;
            if (nums[mid] <= nums[start] && nums[mid] <= nums[end])
                end = mid;

        }
        return nums[end];
    }

    @Test
    void test() throws Exception {
        int[] nums = {3, 4, 4, 4, 5, 1, 2, 2, 2, 3, 3};
        Assertions.assertEquals(1, find(nums));
        Assertions.assertThrows(Exception.class, () -> find(null));

        int[] list = {1, 2, 3, 4};
        Assertions.assertEquals(1, find(list));

        int[] list1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1};
        Assertions.assertEquals(0, find(list1));
        int[] list2 = {2};
        Assertions.assertEquals(2, find(list2));
    }
}
