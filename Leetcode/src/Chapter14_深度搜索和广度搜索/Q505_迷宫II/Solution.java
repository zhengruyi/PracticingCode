package Chapter14_深度搜索和广度搜索.Q505_迷宫II;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/02/2021 23:26
 **/

public class Solution {
    /**
     * 不可以用BFS,因为BFS是求的撞墙次数最少的路径,而这里要用到floyde算法
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] distance = new int[m][n];
        //其实设定所有值都是最大
        for(int i = 0; i < m; i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        Queue <int[]> queue = new LinkedList <>();
        distance[start[0]][start[1]] = 0;
        queue.offer(start);
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            //往四个方向遍历
            for(int i =0; i < dx.length; i++){
                int count = 1;
                int newX = x + dx[i];
                int newY = y + dy[i];
                //计算沿着这个方向可以到达的坐标
                while(newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == 0){
                    count++;
                    newX += dx[i];
                    newY += dy[i];
                }
                count--;
                newX -= dx[i];
                newY -= dy[i];
                //计算这种新的到达方式是否能够缩短两点之间的距离
                if(count + distance[x][y] < distance[newX][newY]){
                    distance[newX][newY] = count + distance[x][y];
                    queue.offer(new int[]{newX,newY});
                }
            }
        }
        //查看最短需要经过的步数
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}
