package Chapter8_数组和矩阵问题.Q3_之字形打印矩阵;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/06/2020 20:53
 **/

public class PrintMatrixZigZag {
    public static void printMatrixZigZag(int[][] matrix) {
        int tr = 0;
        int tc = 0;
        int dr = 0;
        int dc = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (tr != endR+1) {
            printLevel(matrix, tr, tc, dr, dc, fromUp);
            //需要考虑四个值的更新顺序问题
            tr = tc == endC ? tr + 1 : tr;
            tc = tc == endC ? tc : tc + 1;
            dc = dr == endR ? dc + 1 : dc;
            dr = dr == endR ? dr : dr +1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void printLevel(int[][] m, int tr, int tc, int dr, int dc, boolean f) {
        if (f) {
            //按照斜线进行打印
            while (tr != dr + 1) {
                System.out.print(m[tr++][tc--] + " ");
            }
        } else {
            while (dr != tr - 1) {
                System.out.print(m[dr--][dc++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printMatrixZigZag(m);
    }
}
