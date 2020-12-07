package Chapter14_深度搜索和广度搜索.Q329_矩阵中的最长递增路径;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/12/2020 18:07
 **/

public class Solution {
    //从当前位置往四个方向进行搜索的偏移量，分别是右上左下
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int ans = 0;
        for(int i =0; i< m; i++){
            for(int j = 0; j < n; j++){
                //分别从当前为位置进行深度搜索,取所有结果中的最大值
                ans = Math.max(ans,dfs(matrix,memo,i,j));
            }
        }
        return ans;
    }

    /**
     * 记忆化深度搜索
     * @param matrix
     * @param memo
     * @param i
     * @param j
     * @return
     */
    public int dfs(int[][] matrix, int[][] memo, int i, int j){
        //说明当前点还没计算过
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        //每个的嘴上递增序列最少是1，即自己本身
        ++memo[i][j];
        for(int[] dir : dirs){
            //根据偏差，来计算出下一个要遍历的位置
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            //首先判断先的位置是否是一个有有效节点，然后必须新的节点的值要大于当前节点才能构成上升序列
            if(newRow >=0 && newRow < rows && newCol>=0 && newCol < cols && matrix[i][j] < matrix[newRow][newCol]){
                memo[i][j] = Math.max(memo[i][j],dfs(matrix,memo,newRow,newCol)+1);
            }
        }
        return memo[i][j];
    }
}
