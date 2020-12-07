package Chapter12_数组和字符串.Q48_旋转图像;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/12/2020 18:24
 **/

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return;
        }
        //这里要注意行和列的遍历数目
        int r = (n >> 1) - 1;
        int c = (n - 1) >> 1;
        for(int i =0; i <= r; i++){
            for(int j =0; j <= c; j++){
                //顺序交换四个位置
                swap(matrix,i,j,j,n-1-i);
                swap(matrix,i,j,n-1-i,n-1-j);
                swap(matrix,i,j,n-1-j,i);
            }
        }
    }
    public void swap(int[][] matrix, int r1, int c1, int r2, int c2){
        int tmp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = tmp;
    }
}
