package Chapter8_数组和矩阵问题.Q2_将正方形矩阵顺时针转动90度数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/06/2020 20:12
 **/

public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int tr = 0;
        int dr = matrix.length - 1;
        int tc = 0;
        int dc = matrix[0].length - 1;
        while (tr <= dr && tc <= dc){
            exchange(matrix,tr++,dr--,tc++,dc--);
        }
    }
    public static void exchange(int[][] matrix, int tr, int dr, int tc, int dc){
        for (int i = 0; i < dr - tr; i++) {
            int tmp = matrix[dr - i][tc];
            matrix[dr - i][tc] = matrix[dr][dc-i];
            matrix[dr][dc-i] = matrix[tr + i][dc];
            matrix[tr + i][dc] = matrix[tr][tc + i];
            matrix[tr][tc + i] = tmp;
        }
    }
    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(matrix);
        rotate(matrix);
        printMatrix(matrix);
    }
}
