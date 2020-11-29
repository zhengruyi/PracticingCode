package Chapter12_数组和字符串.Q0107_旋转矩阵;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/11/2020 16:27
 **/

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return;
        }
        int r = (n >> 1 ) - 1;
        int c = (n - 1) >> 1;
        for(int i = 0; i<= r; i++){
            for(int j = 0; j <= c; j++){
                //这里重点是如何根据横轴对称和纵轴对称，中心对称来计算出选转后对应的位置
                //具体计算方法看 https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/c-tu-jie-yuan-di-cao-zuo-ji-bai-shuang-bai-vv-by-t/
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
