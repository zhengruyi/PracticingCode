package Chapter10_动态规划.Q1074_元素和为目标值的子矩阵数量;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/11/2020 17:00
 **/

public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int res = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] sum = new int[cols];
        //把矩阵降维，从二维降低到一维,sum数组保存从j开始的每列数据和
        for(int i =0; i < rows; i++){
            Arrays.fill(sum,0);
            for(int j = i; j < rows; j++){
                //更新每列数据和
                for(int k = 0; k < cols; k++){
                    sum[k] += matrix[j][k];
                }
                for(int k = 0; k < sum.length; k++){
                    int sum1 = 0;
                    for(int l = k; l < sum.length; l++){
                        //穷举每个区间和，符合条件就加一
                        sum1+=sum[l];
                        if(sum1 == target){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
