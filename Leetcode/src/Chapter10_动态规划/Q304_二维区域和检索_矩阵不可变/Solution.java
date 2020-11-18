package Chapter10_动态规划.Q304_二维区域和检索_矩阵不可变;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/11/2020 20:45
 **/

public class Solution {
    class NumMatrix {
        int[][] sum;
        public NumMatrix(int[][] matrix) {
            if(matrix.length == 0 || matrix[0].length == 0){
                return;
            }
            int rows = matrix.length;
            int cols = matrix[0].length;
            //创建矩阵前缀和矩阵表示从(0,0)到(i,j)的所有数字和
            sum = new int[rows+1][cols+1];
            for(int i =0; i <rows; i++){
                for(int j =0; j < cols; j++){
                    //画图可以解释，左上角由于被重复减去两次，所以最后要在加上
                    sum[i+1][j+1] = sum[i][j+1] + sum[i+1][j] - sum[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            //同样的方法求解区间和
            return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}
