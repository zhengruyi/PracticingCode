package Chapter4_双指针技巧.Q611_有效三角形的个数;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 00:35
 **/

public class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                //如果不攒足条件则k = i+2,则k - j - 1 = 0，但如果一开始k就满足构成三角形的条件
                //那么由于数组是递增的,所以所偶遇后续都满足条件,则k递增到末尾，统计可以构成三角形的数量
                count += k - j - 1;
            }
        }
        return count;
    }
}
