package Chapter0_其他.Q1727_重新排列后的最大子矩阵;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/03/2021 23:20
 **/

public class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                //更新以这一行为底的矩形高度
                if(matrix[i][j] == 1){
                    matrix[i][j] += matrix[i-1][j];
                }
            }
        }
        int res = 0;
        for(int i = 0; i < m; i++){
            //对这一行的以这行为底的矩形高度从小到大排序
            Arrays.sort(matrix[i]);
            for(int j = n-1; j >= 0; j--){
                //因为高度是递减关系，所以整个矩形的高度都是这个最小值
                int height = matrix[i][j];
                //计算构成的矩形的最大面积
                res = Math.max((n - j) * height, res);
            }
        }
        return res;
    }
}
