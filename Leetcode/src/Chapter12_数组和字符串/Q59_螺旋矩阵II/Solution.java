package Chapter12_数组和字符串.Q59_螺旋矩阵II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/12/2020 18:41
 **/

public class Solution {
    public int[][] generateMatrix(int n) {
        //确定上下两行和左右两列的范围
        int startRow =0, startCol = 0;
        int endRow = n-1, endCol = n-1;
        int num = 1;
        int[][] matrix = new int[n][n];
        while(startRow <= endRow){
            //确定左上到右上的这一行未被遍历
            if(startCol > endCol){
                break;
            }
            for(int j = startCol; j <= endCol; j++){
                matrix[startRow][j] = num++;
            }
            startRow++;
            //确定右上到右下这一列未被遍历
            if(startRow > endRow){
                break;
            }
            for(int i = startRow; i <= endRow; i++){
                matrix[i][endCol] = num++;
            }
            endCol--;
            //最顶右下到左下这一行为被遍历
            if(startCol > endCol){
                break;
            }
            for(int j = endCol; j>= startCol;j--){
                matrix[endRow][j] = num++;
            }
            endRow--;
            //确定从左下到左上未被遍历
            if(startRow > endRow){
                break;
            }
            for(int i = endRow; i>= startRow; i--){
                matrix[i][startCol] = num++;
            }
            startCol++;
        }
        return matrix;
    }
}
