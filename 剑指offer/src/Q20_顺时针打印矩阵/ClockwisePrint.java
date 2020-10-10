package Q20_顺时针打印矩阵;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/04/2020 10:25
 **/

public class ClockwisePrint {
    public static void print(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        while (rows > start * 2 && columns > start * 2) {
            printCircle(matrix, start, rows, columns);
            ++start;
        }
        System.out.println();
    }

    public static void printCircle(int[][] matrix, int start, int rows, int columns) {
        int startX = start;
        int startY = start;
        //默认输出
        while(startY <= columns-1-start){
            System.out.println(matrix[startX][startY]);
            startY++;
        }
        startY--;

        // 要求终止行数大于初始行数
        if(rows - 1 - start > start){
            while (startX < rows - 1 - start){
                ++startX;
                System.out.println(matrix[startX][startY]);

            }
        }

        //要求终止行数大于初始行数且终止列数大于初始列数
        if(rows - 1 - start > start && columns-1-start > start){
            while (startY > start){
                --startY;
                System.out.println(matrix[startX][startY]);
            }
        }

        //要求终止行数至少大于初始行数加1
        if(rows - 1 - start > start+1){
            while (startX > start+1){
                --startX;
                System.out.println(matrix[startX][startY]);

            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        print(matrix);
        System.out.println();
        matrix = new int[][]{{5, 6, 7}, {9, 10, 11}, {13, 14, 15}};
        print(matrix);
        matrix = new int[][]{{5, 6, 7, 8, 9}, {10, 11, 12, 13, 14}, {16, 17, 18, 19, 20}};
        print(matrix);
    }
}
