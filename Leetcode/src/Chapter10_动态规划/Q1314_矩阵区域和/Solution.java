package Chapter10_动态规划.Q1314_矩阵区域和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/11/2020 17:04
 **/

public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] res = new int[rows][cols];
        if(mat.length == 0 || mat[0].length == 0){
            return res;
        }
        int[][] sum = new int[rows+1][cols+1];
        //二维矩阵的前缀和计算公式
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= cols; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
            }
        }
        //求出二维矩阵的区间和计算公式，由于考虑到包含范围，所以x0,y0的计算要包含-1这个选项
        //画图可以理解计算公式
        for(int i = 1; i <= rows; i++){
            for(int j =1; j <= cols; j++){
                int x0 = Math.max(i-K-1,0);
                int y0 = Math.max(j-K-1,0);
                int x1 = Math.min(i+K,rows);
                int y1 = Math.min(j+K, cols);
                res[i-1][j-1] = sum[x1][y1] - sum[x1][y0] - sum[x0][y1] + sum[x0][y0];
            }
        }
        return res;
    }
}
