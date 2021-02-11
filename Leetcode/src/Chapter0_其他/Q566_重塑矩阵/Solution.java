package Chapter0_其他.Q566_重塑矩阵;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/02/2021 23:49
 **/

public class Solution {
    /**
     * 根据就算i,j的位置计算总的元素数目,然后在根据原来要求的新的矩阵的维度计算
     * 新的矩阵作为结果
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if(m *n != r * c){
            return nums;
        }
        int[][] matrix = new int[r][c];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int sum = i * n + j;
                matrix[sum / c][sum - (sum/c) * c] = nums[i][j];
            }
        }
        return matrix;
    }
}
