package Chapter0_其他.Q1630_等差子数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/03/2021 21:48
 **/

public class Solution {
    /**
     * 暴力的实现时通过System.arraycopy()将部分数组拷贝出来，然后排序检查这部分的数组
     * 是否是等差数列
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public List <Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        if(nums.length == 0 || nums.length == 1){
            return Arrays.asList(true);
        }
        int len = l.length;
        List<Boolean> res = new ArrayList();
        for(int i = 0; i < len; i++){
            int[] tmp = new int[r[i] - l[i] + 1];
            System.arraycopy(nums,l[i],tmp,0,r[i] - l[i] + 1);
            res.add(check(tmp));
        }
        return res;
    }
    public boolean check(int[] nums){
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i] - nums[i-1] != nums[i+1] - nums[i]){
                return false;
            }
        }
        return true;
    }
}
