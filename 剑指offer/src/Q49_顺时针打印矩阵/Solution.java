package Q49_顺时针打印矩阵;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/12/2020 22:35
 **/

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m*n];
        int index = 0;
        int startRow = 0, startCol = 0;
        int endRow = m-1, endCol = n-1;
        while(startRow <= endRow){
            if(startCol > endCol){
                break;
            }
            for(int j = startCol; j <= endCol; j++){
                res[index++] = matrix[startRow][j];
            }
            startRow++;
            if(startRow > endRow){
                break;
            }
            for(int i = startRow;i <= endRow; i++){
                res[index++] = matrix[i][endCol];
            }
            endCol--;
            if(startCol > endCol){
                break;
            }
            for(int j = endCol; j>= startCol; j--){
                res[index++] = matrix[endRow][j];
            }
            endRow--;
            if(startRow > endRow){
                break;
            }
            for(int i = endRow; i>= startRow; i--){
                res[index++] = matrix[i][startCol];
            }
            startCol++;
        }
        return res;
    }
}
