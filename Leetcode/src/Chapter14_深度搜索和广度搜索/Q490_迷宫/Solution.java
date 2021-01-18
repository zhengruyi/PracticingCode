package Chapter14_深度搜索和广度搜索.Q490_迷宫;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/01/2021 22:03
 **/

public class Solution {
    /**
     * 和一般的广度遍历相似，这里的问题主要在于选择一个方向后
     * 需要用到while循环来沿着指定的方向来进行搜索知道碰到边界或者遇到墙壁
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0){
            return false;
        }
        int m = maze.length;
        int n = maze[0].length;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        boolean[][] visited = new boolean[m][n];
        Queue <int[]> queue = new LinkedList <>();
        visited[start[0]][start[1]] = true;
        queue.offer(start);
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            //检测是否到达终点
            if(tmp[0] == destination[0] && tmp[1] == destination[1]){
                return true;
            }
            for(int i = 0; i < dx.length; i++){
                int newX = tmp[0] + dx[i];
                int newY = tmp[1] + dy[i];
                //往指定的方向移动知道遇到边界挥着碰到墙停下
                while(newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == 0){
                    newX+= dx[i];
                    newY+= dy[i];
                }
                //将到达的点标记成已访问并且入队列，等待下一次广度遍历
                if(!visited[newX - dx[i]][newY - dy[i]]){
                    visited[newX - dx[i]][newY - dy[i]] = true;
                    queue.offer(new int[]{newX - dx[i],newY - dy[i]});
                }
            }
        }
        return false;
    }
}
