package Chapter0_其他.Q73_矩阵置零;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/02/2021 23:25
 **/

public class Solution {
    public void setZeroes(int[][] matrix) {
        //记录第一行第一列是否要清零
        boolean firstRow = false;
        boolean firstColumn = false;
        int m = matrix.length;
        int n = matrix[0].length;
        //检查第一列是否有0
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                firstColumn = true;
                break;
            }
        }
        //检查第一行是否有0
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                firstRow = true;
                break;
            }
        }
        //遍历矩阵，如果有0就对应的第一行和第一列对应位置设成0
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //清零操作
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        //处理第一行和第一列
        if(firstRow){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
        if(firstColumn){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
