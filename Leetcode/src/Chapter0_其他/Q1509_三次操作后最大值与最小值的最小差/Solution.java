package Chapter0_其他.Q1509_三次操作后最大值与最小值的最小差;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/03/2021 22:45
 **/

public class Solution {
    public int minDifference(int[] nums) {
        //长度大小小于4,那么可以通过三次调整,
        // 把所有数字调整成一样的,所以最大最小值的绝对值差等于0
        if(nums.length <= 4){
            return 0;
        }
        //对数组排序
        Arrays.sort(nums);
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i <= 3; i++){
            // 总共三次机会,分别对最小值使用0..3次,
            // 那么对应的最大值的调整就是3..0次,分别用调整后的最大和最小值计算绝对差值的最小值
            res = Math.min(res, nums[len - 1 + i - 3] - nums[i]);
        }
        return res;
    }
}
