package Chapter4_递归和动态规划.Q1_斐波那契系列问题的递归和动态规划;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/06/2020 21:02
 **/

public class Fibonacci {
    /**
     * 递归的解法，时间复杂度O(N^2)
     * @param n Fibonacci的级数
     * @return
     */
    public int getNumberWithRecursive(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        return getNumberWithRecursive(n-1)+getNumberWithRecursive(n-2);
    }

    /**
     * 动态规划的解法。时间复杂度O(N)
     * @param n Fibonacci的级数
     * @return
     */
    public int getNumberWithDynamicPlan(int n){
        if(n == 1){
            return 1;
        }
        int[] fibonacci = new int[n+1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        return fibonacci[n];
    }

    /**
     * 使用矩阵来进行加速计算，时间复杂度O(LogN)
     * @param n Fibonacci的级数
     * @return
     */
    public int getNumberWithMatrixPower(int n){
        if(n <1){
            return 0;
        }
        if(n == 1 || n== 2){
            return 1;
        }
        int[][] base = {{1,1},{1,0}};
        int[][] res = matrixPower(base,n-2);
        return res[0][0] + res[1][0];
    }
    public int[][] matrixPower(int[][] m, int p){
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            res[i][i] = 1;
        }
        int[][] temp = m;
        for (;p!=0; p >>= 1){
            if((p&1) != 0){
                res = multiMatrix(res,temp);
            }
            temp = multiMatrix(temp,temp);
        }
        return res;
    }
    public int[][] multiMatrix(int[][] m1, int[][] m2){
        int[][] res= new int[m1.length][m2[0].length];
        for (int i = 0; i < m2[0].length; i++) {
            for (int j = 0; j < m1.length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    @Test
    void fibonacciRecursive(){
        assertEquals(2,getNumberWithRecursive(3));
        assertEquals(8,getNumberWithRecursive(6));

    }

    @Test
    void fibonacciDP(){
        assertEquals(2,getNumberWithDynamicPlan(3));
        assertEquals(8,getNumberWithDynamicPlan(6));
    }
    @Test
    void fibonacciMatrix(){
        assertEquals(2,getNumberWithMatrixPower(3));
        assertEquals(8,getNumberWithMatrixPower(6));
    }
    @Test
    void testMultiMatrix(){
        int[][] m1 = {{1,2,3},{4,5,6}};
        int[][] m2 = {{1,1},{1,0},{1,0}};
        multiMatrix(m1,m2);
    }


}
