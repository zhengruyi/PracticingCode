package Chapter15_面试题.Q1009_排序矩阵的查找;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/01/2021 21:10
 **/

public class Solution {
    /**
     * 如果左上角的值比目标值大，那么删除一列，否则删除一行
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n-1;
        while(row < m && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
