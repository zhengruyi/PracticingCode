package Chapter10_动态规划.Q918_环形子数组的最大和;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/10/2020 20:12
 **/

public class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int curr = 0;
        int res = 0;
        //遍历一遍数组，找到其中的最大子数组和，此时最大子数组和不再循环数组中
        for(int i =0; i < A.length; i++){
            curr = Math.max(curr,0)+A[i];
            res = Math.max(curr, res);
        }
        //如果此时res = 0,代表数组中全部都为负数，那么可以选择其中最大的一个数字直接返回
        if(res == 0){
            return Arrays.stream(A).max().getAsInt();
        }
        int currMin = 0;
        int resMin = 0;
        //数组和为定值，要想获取子数组和最大和等同于数组全部元素和减去最小子数组，此时对应的最大子数组和在循环数组中
        for(int i = 0; i < A.length; i++) {
            currMin = Math.min(currMin, 0) + A[i];
            resMin = Math.min(resMin, currMin);
        }
        int sum = Arrays.stream(A).sum();
        //比较循环和非循环数组的最大值
        return Math.max(res,sum - resMin);
    }

}
