package C4_递归和动态规划.Q1_斐波那契矩阵解法;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/05/2020 13:19
 **/

public class Matrix {
    public int[][] matrixPower(int[][] m, int p){
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        while(p != 0){
            if( (p & 1) != 0)
                res = multiMatrix(res, tmp);
            tmp = multiMatrix(tmp, tmp);
            p >>= 1;

        }
        return res;
    }

    public int[][] multiMatrix(int[][]m1, int[][] m2){
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m2[0].length; i++) {
            for (int j = 0; j < m1.length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
    public int fibonaci(int n){
        if( n < 1)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        int[][] base = {{1, 1},{1, 0}};
        int[][] res = matrixPower(base, n-2);
        return res[0][0] + res[1][0];
    }

    @Test
    void test(){
        Assertions.assertEquals(3,fibonaci(4));
    }
}
