package Q13_二维数组查找;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/05/2020 21:03
 **/
/*
leetcode : https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/submissions/
 */
public class FindInMatrix {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean result = false;
        int row = 0;
        int column = columns;
        while(row < rows && column > 0){
            if(matrix[row][column - 1] == target){
                return true;
            }else if(matrix[row][column - 1] > target){
                column--;
            }else{
                row++;
            }
        }
        return result;
    }
}
