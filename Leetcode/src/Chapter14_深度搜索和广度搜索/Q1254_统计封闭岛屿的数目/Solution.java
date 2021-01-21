package Chapter14_深度搜索和广度搜索.Q1254_统计封闭岛屿的数目;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/01/2021 21:50
 **/

public class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    /**
     * 封闭岛屿要求，岛屿的周围全是海洋，但是边界上的岛屿不算做封闭
     * 所以可以现在边界上做dfs把所有和边界上相连的陆地全变变成海洋
     * 然后还剩下的陆地就是四周都是海洋的封闭岛屿
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        //边界dfs
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 0){
                dfs(i,0,grid,m,n);
            }
            if(grid[i][n-1] == 0){
                dfs(i,n-1,grid,m,n);
            }
        }
        for(int j = 0; j < n; j++){
            if(grid[0][j] == 0){
                dfs(0,j,grid,m,n);
            }
            if(grid[m-1][j] == 0){
                dfs(m-1,j,grid,m,n);
            }
        }
        //剩下的陆地都是封闭岛屿
        for(int i = 1; i < m ;i++){
            for(int j = 1; j < n; j++){
                if(grid[i][j] == 0){
                    ans++;
                    dfs(i,j,grid,m,n);
                }
            }
        }
        return ans;
    }
    public void dfs(int x, int y, int[][] grid, int m, int n){
        grid[x][y] = 1;
        for(int i = 0; i < dx.length; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX < m && newX >= 0 && newY < n && newY >=0 && grid[newX][newY] == 0){
                dfs(newX,newY,grid,m,n);
            }
        }
    }

}
