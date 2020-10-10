package Chapter4_动态规划.Q4_矩阵连乘;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/07/2020 13:00
 **/

public class MatrixTimes {
    public static void matrixTime(int[] matrix, int nums) {
        int[][] minTimes = new int[nums][nums];
        int[][] record = new int[nums][nums];
        for (int i = 1; i < nums; i++) {
            minTimes[i - 1][i] = matrix[i - 1] * matrix[i] * matrix[i + 1];
            record[i - 1][i] = i ;
        }
        for (int i = 2; i < nums; i++) {
            for (int j = 0; j + i < nums; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = j; k < j + i; k++) {
                    int sum = minTimes[j][k] + minTimes[k + 1][j + i] + matrix[j + i + 1] * matrix[j] * matrix[k + 1];
                    if (min > sum) {
                        record[j][j + i] = k+1;
                        min = sum;
                    }
                }
                minTimes[j][j+i] = min;
            }
        }

        System.out.println(minTimes[0][nums-1]);
        printMatrixOrder(record,1,nums);
    }
    public static void printMatrixOrder(int[][] record, int i, int j){
        if(i == j){
            System.out.print("A["+i+"]");
            return;
        }
        System.out.print("(");
        printMatrixOrder(record,i,record[i-1][j-1]);
        printMatrixOrder(record,record[i-1][j-1]+1,j);
        System.out.print(")");
    }

    public static void main(String[] args) {
        int[] matrix = {3, 5, 10, 8, 2, 4};
        matrixTime(matrix,5);
    }
}
