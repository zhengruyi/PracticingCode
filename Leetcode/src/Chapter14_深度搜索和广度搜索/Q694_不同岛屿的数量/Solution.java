package Chapter14_深度搜索和广度搜索.Q694_不同岛屿的数量;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/02/2021 23:29
 **/

public class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public int numDistinctIslands(int[][] grid) {
        Set <String> set = new HashSet();
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                //发现新的岛屿
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    List <int[]> shape = new ArrayList();
                    dfs(grid,visited,shape,i,j);
                    StringBuilder builder = new StringBuilder();
                    //将岛屿的相对坐标量计算出来,然后做成字符串，来判断岛屿形状是否相等
                    for(int[] location : shape){
                        location[0] = location[0] - i;
                        location[1] = location[1] - j;
                        builder.append(location[0]).append(location[1]);
                    }
                    //添加岛屿形状
                    set.add(builder.toString());
                }
            }
        }
        return set.size();
    }

    /**
     * 从一个坐标开始将岛屿的所有坐标收集起来返回出去
     * @param grid
     * @param visited
     * @param shape
     * @param x
     * @param y
     */
    public void dfs(int[][] grid, int[][] visited, List<int[]> shape, int x, int y){
        shape.add(new int[]{x,y});
        visited[x][y] = 1;
        for(int i = 0; i < dx.length; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && visited[newX][newY] == 0 && grid[newX][newY] == 1){
                dfs(grid,visited,shape,newX,newY);
            }
        }
    }
}
