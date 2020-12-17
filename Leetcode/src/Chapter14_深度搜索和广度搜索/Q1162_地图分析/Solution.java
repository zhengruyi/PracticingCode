package Chapter14_深度搜索和广度搜索.Q1162_地图分析;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/12/2020 22:43
 **/

public class Solution {
    public int maxDistance(int[][] grid) {
        //四个方向遍历偏移
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Queue <int[]> queue = new ArrayDeque <>();
        int m = grid.length;
        int n = grid[0].length;
        //将所有陆地都入队
        for(int i =0; i < m; i++){
            for(int j =0; j < n; j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        //默认没有海洋
        boolean hasOcean = false;
        //默认没有陆地
        int[] point = null;
        while(!queue.isEmpty()){
            //去除第一个陆地坐标
            point = queue.poll();
            int x = point[0];
            int y = point[1];
            //计算和陆地相连的四个方向
            for(int i = 0; i < dx.length; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0){
                    continue;
                }
                //将新的点到陆地的距离更新
                grid[newX][newY] = grid[x][y] + 1;
                //将新的点入队列
                queue.offer(new int[]{newX,newY});
                //确认有海洋
                hasOcean = true;
            }
        }
        //如果没有海洋或者陆地
        if(point == null || !hasOcean){
            return -1;
        }
        //找出遍历到的海洋，因为默认从陆地开始遍历，所以最后要减去1
        return grid[point[0]][point[1]] - 1;
    }
}
