package Chapter12_数组和字符串.Q0108_零矩阵;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/11/2020 16:29
 **/

public class Solution {
    public void setZeroes(int[][] matrix) {
        //这里主要使用第一行和第一列来标记要清除的行和列
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        //判断第一列是否有0
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0){
                isFirstColZero = true;
                break;
            }
        }
        //判断第一行是否有0
        for(int j =0; j< cols; j++){
            if(matrix[0][j] == 0){
                isFirstRowZero = true;
                break;
            }
        }
        //当某个元素为0时，把对应的第一行和第一列标记一下
        for(int i = 1; i < rows; i++){
            for(int j = 1; j< cols; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //执行清零操作
        for(int i = 1; i < rows; i++){
            for(int j = 1; j< cols; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        //对第一行进行操作
        if(isFirstRowZero){
            for(int j = 0; j<cols; j++){
                matrix[0][j] = 0;
            }
        }
        //对第一列进行操作
        if(isFirstColZero){
            for(int i =0; i< rows; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
