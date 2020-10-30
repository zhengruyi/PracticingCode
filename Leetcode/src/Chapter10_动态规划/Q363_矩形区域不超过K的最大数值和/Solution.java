package Chapter10_动态规划.Q363_矩形区域不超过K的最大数值和;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/10/2020 19:56
 **/

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int N = matrix.length;
        int M = matrix[0].length;
        //和本录下的Q1724一样，用一位数组来存储矩阵的一列元素之和
        int[] nums = new int[M];
        int max = Integer.MIN_VALUE;
        for(int i =0; i < N; i++){
            Arrays.fill(nums,0);
            for(int j = i;  j < N; j++){
                for(int l = 0; l < M;l++){
                    nums[l] += matrix[j][l];
                }
                //得到当前子矩阵下，不超过k的最大值
                int res = getMax(nums,k);
                //保存全局最大值
                max = res > max ? res : max;
            }
        }
        return max;
    }
    public int getMax(int[] nums, int k){
        int sum = 0;
        int max = 0;
        //先求数组的最大子数组和
        for(int i = 0; i < nums.length; i++){
            sum = Math.max(0,sum) + nums[i];
            max = sum > max ? sum : max;
        }
        //如果最大子数组和小于等于k 直接返回
        if(max <= k){
            return max;
        }
        //暴力遍历数组，找出子数组和小于等于k的最大值返回
        max = Integer.MIN_VALUE;
        for(int i =0; i < nums.length; i++){
            sum = 0;
            for(int j =i; j< nums.length; j++){
                sum += nums[j];
                if(sum > max && sum <= k){
                    max = sum;
                }
                if(max == k){
                    return k;
                }
            }
        }
        return max;

    }
}
