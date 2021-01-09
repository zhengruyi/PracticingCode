package Chapter0_其他.Q867_转置矩阵;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/01/2021 00:18
 **/

public class Solution {
    /**
     * 简单的调换横纵坐标
     * @param A
     * @return
     */
    public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] matrix = new int[n][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[j][i] = A[i][j];
            }
        }
        return matrix;
    }
}
