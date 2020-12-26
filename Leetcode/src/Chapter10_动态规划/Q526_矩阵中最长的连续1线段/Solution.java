package Chapter10_动态规划.Q526_矩阵中最长的连续1线段;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/12/2020 21:43
 **/

public class Solution {
    public int longestLine(int[][] M) {
        if(M.length == 0 || M[0].length == 0){
            return 0;
        }
        int m = M.length;
        int n = M[0].length;
        int res = 0;
        //创建四个二维数组用来分别表示横竖对角线和反对角线上的动态规划过程
        int[][] horizontal = new int[m][n];
        int[][] vertical  = new int[m][n];
        int[][] diagonal = new int[m][n];
        int[][] inverseDiagonal = new int[m][n];
        for(int i = 0; i < m; i++){
            //由于反对脚线需要用到j+1位置的结果，所以需要反向遍历j
            for(int j = n-1; j >= 0; j--){
                //由于是连续1，所以一旦当前位置为0,则所有动态规划的结果都为0
                if(M[i][j] == 1){
                    horizontal[i][j] = 1;
                    vertical[i][j] = 1;
                    diagonal[i][j] = 1;
                    inverseDiagonal[i][j] = 1;
                    res = Math.max(res,1);
                    //每次都需要验证位置的有效性
                    if(j + 1 < n){
                        horizontal[i][j] = horizontal[i][j+1] + 1;
                        res = Math.max(res,horizontal[i][j]);
                    }
                    if(i-1 >= 0){
                        vertical[i][j] = vertical[i-1][j] + 1;
                        res = Math.max(res, vertical[i][j]);
                    }
                    if(i-1 >= 0 && j -1 >= 0){
                        diagonal[i][j] = diagonal[i-1][j-1] + 1;
                        res = Math.max(res, diagonal[i][j]);
                    }
                    if(i-1 >= 0 && j + 1 < n){
                        inverseDiagonal[i][j] = inverseDiagonal[i-1][j+1] + 1;
                        res = Math.max(res, inverseDiagonal[i][j]);
                    }
                }
            }
        }
        return res;
    }
}
