package Chapter0_其他.Q74_搜索二维矩阵;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/01/2021 19:48
 **/

public class Solution {
    /**
     * 右上角坐标是重点
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n-1;
        while(row < m && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}
