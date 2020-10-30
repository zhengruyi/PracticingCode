package Chapter10_动态规划.Q1724_最大子矩阵;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/10/2020 19:49
 **/

public class Solution {
    public int[] getMaxMatrix(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[] res = new int[4];
        //和矩阵的长度相等，用来存储包含的子矩阵的一列元素之和
        int[] nums = new int[M];
        int topLeftRow = 0;
        int topLeftCol = 0;
        int max = Integer.MIN_VALUE;
        for(int i =0; i< N; i++){
            Arrays.fill(nums,0);
            for(int j = i; j < N; j++){
                int sum = 0;
                //将每列所有数值加在一起，构成一位数组，把二维矩阵降级成一维数组
                for(int k = 0; k < M; k++){
                    //由于数组是矩阵的一列之和，对于新的一行，只需要在原有基础上加上新的元素就可以
                    nums[k] += matrix[j][k];
                    //意味着要换左上坐标，所以记录下来
                    if(sum <= 0){
                        topLeftRow = i;
                        topLeftCol = k;
                    }
                    sum = Math.max(sum,0)+nums[k];
                    //更新最大值的区间的左上和右下坐标
                    if(sum > max){
                        max = sum;
                        res[0] = topLeftRow;
                        res[1] = topLeftCol;
                        res[2] = j;
                        res[3] = k;
                    }
                }
            }
        }
        return res;
    }
}
