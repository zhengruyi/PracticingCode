import Chapter13_二叉树.TreeNode;

import java.math.BigInteger;
import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public int[][] generateMatrix(int n) {
        int startRow =0, startCol = 0;
        int endRow = n-1, endCol = n-1;
        int num = 1;
        int[][] matrix = new int[n][n];
        while(startRow <= endRow){
            if(startCol > endCol){
                break;
            }
            for(int j = startCol; j <= endCol; j++){
                matrix[startRow][j] = num++;
            }
            startRow++;
            if(startRow > endRow){
                break;
            }
            for(int i = startRow; i <= endRow; i++){
                matrix[i][endCol] = num++;
            }
            endCol--;
            if(startCol > endCol){
                break;
            }
            for(int j = endCol; j>= startCol;j--){
                matrix[endRow][j] = num++;
            }
            endRow--;
            if(startRow > endRow){
                break;
            }
            for(int i = endRow; i>= startRow; i--){
                matrix[startCol][i] = num++;
            }
            startCol++;
        }
        return matrix;
    }
    @org.junit.jupiter.api.Test
    void test(){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        generateMatrix(3);
    }
}
