package Chapter4_递归和动态规划.Q2_矩阵的最小路径和;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/06/2020 10:34
 **/

public class MinimumPath {
    public int getPathSum(int[][] matrix){
        int[] row = new int[matrix[0].length];
        //由于题目要求必须从(0,0)开始，所以初始化是从(0,0)到当前节点的和
        for (int j = 0; j < matrix[0].length; j++) {
            if(j == 0){
                row[j] = matrix[0][j];
            }else{
                row[j] = row[j - 1]+matrix[0][j];
            }
        }
        //数组滚动生成最小值，row[j-1]是从左侧到当前节点的最小路径和
        //row[j](还未更新)则表示的是从上边到当前的最短路径和
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(j == 0){
                    row[j] = row[j] + matrix[i][j];
                }else{
                    row[j] = Math.min(row[j-1],row[j]) + matrix[i][j];
                }
            }
        }
        return row[row.length - 1];
    }

    @Test
    void test(){
        int[][] matrix = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        Assertions.assertEquals(12,getPathSum(matrix));
    }
}
