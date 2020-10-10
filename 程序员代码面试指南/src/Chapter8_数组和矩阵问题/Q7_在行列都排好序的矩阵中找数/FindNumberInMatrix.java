package Chapter8_数组和矩阵问题.Q7_在行列都排好序的矩阵中找数;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/06/2020 16:53
 **/

public class FindNumberInMatrix {
    public boolean find(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int i = 0, j = columns - 1;
        while (i < rows && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

    @Test
    void test(){
        int[][] matrix = {{0,1,2,5},{2,3,4,7},{4,4,4,8},{5,7,7,9}};
        Assertions.assertTrue(find(matrix,5));
        Assertions.assertFalse(find(matrix,10));
    }
}
