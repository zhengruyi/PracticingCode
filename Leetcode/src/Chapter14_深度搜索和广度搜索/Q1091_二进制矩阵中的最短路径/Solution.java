package Chapter14_深度搜索和广度搜索.Q1091_二进制矩阵中的最短路径;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/02/2021 20:24
 **/

public class Solution {
    /**
     * 简单的广度遍历,这里因为矩阵中为0元素的地方才可以遍历到
     * 所以这里直接用原来的矩阵来存储计算结果的值,不再另外用一个矩阵来标记当前点是否已经访问过
     * 所以通过最后一个点的值来判断,如果可以到达就大于0，范泽便是不可达
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return -1;
        }
        Queue <int[]> queue = new LinkedList <>();
        int[] dx = {0,0,1,1,1,-1,-1,-1};
        int[] dy = {1,-1,1,0,-1,1,0,-1};
        queue.offer(new int[]{0,0});
        grid[0][0] = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] tmp = queue.poll();
                int x = tmp[0];
                int y = tmp[1];
                int preLength = grid[x][y];
                for(int j = 0; j < dx.length; j++){
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 0){
                        grid[newX][newY] = preLength + 1;
                        queue.offer(new int[]{newX,newY});
                    }
                }
            }
        }
        return grid[m-1][n-1] == 0 ? -1 : grid[m-1][n-1];
    }
}
