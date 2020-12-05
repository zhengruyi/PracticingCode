package Chapter0_其他.Q200_岛屿数量;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/12/2020 17:42
 **/

public class Solution {
    /**
     * 深度优先搜索，在每个经过的路径上都将'1'改成'0'
     */
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int res = 0;
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                //由于一次深度遍历就会将所有相连位置的'1'改成'0'
                //所以在遍历过程中遇到的'1'的数目就等于岛屿的数目
                if(grid[i][j] == '1'){
                    ++res;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid,int i, int j){
        int nr = grid.length;
        int nc = grid[0].length;
        grid[i][j] = '0';
        if(i-1 >= 0 && grid[i-1][j] =='1'){
            dfs(grid,i-1,j);
        }
        if(i+1 < nr && grid[i+1][j] == '1'){
            dfs(grid,i+1,j);
        }
        if(j-1 >= 0 && grid[i][j-1] == '1'){
            dfs(grid,i,j-1);
        }
        if(j+1 < nc && grid[i][j+1] == '1'){
            dfs(grid,i,j+1);
        }
    }
}
