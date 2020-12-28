package Chapter0_其他.Q240_搜索二维矩阵II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/12/2020 23:03
 **/

public class Solution {
    /**
     * 这里的终点是从右上角开始搜索
     * 如果target大于右上角的值则去除一横行，(右上角的值在该行中最大)
     * 如果target小于右上角的值则去除一列(右上角的值在该列中最小)
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
        int i = 0;
        int j = n-1;
        while(i < m && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
