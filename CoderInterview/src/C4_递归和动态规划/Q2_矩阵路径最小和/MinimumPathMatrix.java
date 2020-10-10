package C4_递归和动态规划.Q2_矩阵路径最小和;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/05/2020 14:21
 **/

public class MinimumPathMatrix {
    public int findMinimumPath(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return  -1;
        int[][] path = new int[matrix.length][matrix[0].length];
        int rows = matrix.length;
        int columns = matrix[0].length;
        path[0][0] = matrix[0][0];
        for (int i = 1; i < rows; i++) {
            path[i][0] = matrix[i][0] + path[i-1][0];
        }
        for (int i = 1; i < columns; i++) {
            path[0][i] = matrix[0][i] + path[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                path[i][j] = Math.min(path[i-1][j], path[i][j-1]) + matrix[i][j];
            }
        }
        return path[rows - 1][columns - 1];
    }

    @Test
    void test(){
        int[][] matrix = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        Assertions.assertEquals(12,findMinimumPath(matrix));
    }
}
