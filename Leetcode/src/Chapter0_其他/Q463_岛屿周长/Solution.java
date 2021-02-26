package Chapter0_其他.Q463_岛屿周长;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/02/2021 23:50
 **/

public class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    /**
     * 找出所有为1的点，然后计算出这个点对整个岛屿的周长的贡献
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int length = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    length += getNumber(grid,i,j);
                }
            }
        }
        return length;
    }

    /**
     * 一个点和周长都等于4-周围相邻是1的个数
     * @param grid
     * @param x
     * @param y
     * @return
     */
    public int getNumber(int[][] grid, int x, int y){
        int res = 0;
        for(int i = 0; i < dx.length; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1){
                continue;
            }
            res++;
        }
        return res;
    }
}
