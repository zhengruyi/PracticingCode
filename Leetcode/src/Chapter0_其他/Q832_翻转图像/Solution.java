package Chapter0_其他.Q832_翻转图像;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/01/2021 23:18
 **/

public class Solution {
    /**
     * 翻转数组值后取相反数
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++){
            for(int j = 0; A[0].length - j -1 >= j; j++){
                swap(A,i,j,i,A[0].length - j - 1);
            }
        }
        return A;
    }

    public void swap(int[][] matrix, int i1, int j1, int i2, int j2){
        int tmp = matrix[i1][j1];
        //只取末尾一位数字
        matrix[i1][j1] = ~matrix[i2][j2] & 0x1;
        matrix[i2][j2] = ~tmp & 0x1;
    }
}
