package Chapter3二分查找.Q1498_满足条件的子序列数目;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/03/2021 23:05
 **/

public class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long res = 0;
        int len = nums.length;
        long[] number = new long[len];
        number[0] = 1;
        //统计总共的子序列数目,为防止溢出这里用long
        for(int i = 1; i < len; i++){
            number[i] = (number[i-1] << 1) % 1000_000_007;
        }
        for(int i = 0; i < len; i++){
            int l = i;
            int r = nums.length;
            //找到满足条件的最左边的l值
            while(r - l > 1){
                int mid = l + (r - l)/2;
                if(nums[i] + nums[mid] <= target){
                    l = mid;
                }else{
                    r = mid;
                }
            }
            //确定l是符合条件的
            if(nums[l] + nums[i] <= target){
                res = (res + number[l - i]) % 1000_000_007;
            }
        }
        return (int)res;
    }
}
