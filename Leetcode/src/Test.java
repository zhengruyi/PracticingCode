import Chapter13_二叉树.TreeNode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    @org.junit.jupiter.api.Test
    void test() {
        int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        numDistinctIslands(grid);
    }

    public static void main(String[] args) {
        System.out.println(IntStream.range(0,4).sum());
    }
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public int numDistinctIslands(int[][] grid) {
        Set<List<int[]>> set = new HashSet();
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    List<int[]> shape = new ArrayList();
                    dfs(grid,visited,shape,i,j);
                    for(int[] location : shape){
                        location[0] = location[0] - i;
                        location[1] = location[1] - j;
                    }
                    set.add(shape);
                }
            }
        }
        return set.size();
    }
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