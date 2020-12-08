package Chapter14_深度搜索和广度搜索.Q695_岛屿的最大面积;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/12/2020 23:45
 **/

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //对于每个元素为1的位置开始深度搜索
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(grid,i,j));
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid, int i, int j){
        //当前为1，所以最小面积为1
        int sum = 1;
        //将自己位置设为0,防止左右左右这种死循环
        grid[i][j] = 0;
        //往上搜索
        if(i - 1 >= 0 && grid[i-1][j] == 1){
            sum += dfs(grid,i-1,j);
        }
        //往下搜索
        if(i+1 < grid.length && grid[i+1][j] == 1){
            sum += dfs(grid,i+1,j);
        }
        //往左搜索
        if(j-1 >= 0 && grid[i][j-1] == 1){
            sum += dfs(grid,i,j-1);
        }
        //往右搜索
        if(j+1 < grid[0].length && grid[i][j+1] == 1){
            sum += dfs(grid,i,j+1);
        }
        //返回所有相连的岛屿最大面积
        return sum;
    }
}
