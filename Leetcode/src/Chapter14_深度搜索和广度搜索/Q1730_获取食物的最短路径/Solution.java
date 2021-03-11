package Chapter14_深度搜索和广度搜索.Q1730_获取食物的最短路径;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/03/2021 23:03
 **/

public class Solution {
    public int getFood(char[][] grid) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        Queue <int[]> queue = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        skip:
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '*'){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                    break skip;
                }
            }
        }
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                for(int j = 0; j < dx.length; j++){
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] != 'X' && !visited[newX][newY]){
                        //在这里进行搜索可以缩短遍历的长度,节省时间
                        if(grid[newX][newY] == '#'){
                            return res + 1;
                        }
                        queue.offer(new int[]{newX,newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
