package Chapter14_深度搜索和广度搜索.Q1293_网格中的最短路劲;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/12/2020 18:47
 **/

public class Solution {
    /**
     * 如图的最佳路径搜索，网格最小步数搜索等一般使用BFS
     * @param grid
     * @param k
     * @return
     */
    public int shortestPath(int[][] grid, int k) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n ==1){
            return 0;
        }
        //用来记录到达某个坐标时剩下的跨越障碍数目
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = -1;
            }
        }
        //记录到达某个点的最小步数
        int minSteps = 0;
        //初始条件
        visited[0][0] = k;
        //广度遍历时必须的队列
        Queue <Point> queue = new LinkedList <>();
        Point start = new Point(0,0,0);
        queue.offer(start);
        //上下左右四个方向的偏移量
        int[] dx = {-1,0,1,0};
        int[] dy = {0, 1, 0,-1};
        while(!queue.isEmpty()){
            //每遍历完一层后，步数就要增加1
            minSteps++;
            //缺额定要遍历的数目
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point current = queue.poll();
                int x = current.x;
                int y = current.y;
                int count = current.count;
                //对当前点的四个方向进行遍历
                for(int j = 0; j < dx.length;j++){
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    //新计算出点是否有效
                    if(newX < 0 || newX >=m || newY < 0 || newY >= n){
                        continue;
                    }
                    //到达终点返回最先步数
                    if(newX == m-1 && newY == n-1){
                        return minSteps;
                    }
                    //如果新点遇到障碍，查看是否可以通过
                    if(grid[newX][newY] == 1 && count >= k){
                        continue;
                    }
                    //计算到达新点，要通过的障碍数目
                    int newCount = grid[newX][newY] == 1 ? count+1 : count;
                    //如果该点的visited不是-1，说明该点已经到达过了，那么根据贪心算法，我妈们只记录到达该点
                    //保留通过障碍次数最多的方式
                    if(visited[newX][newY] != -1 && visited[newX][newY] >= k - newCount){
                        continue;
                    }else{
                        visited[newX][newY] = k - newCount;
                    }
                    //将新点加入队列
                    queue.offer(new Point(newX,newY,newCount));
                }
            }
        }
        return -1;
    }
}
class Point{
    //x坐标
    int x;
    // y坐标
    int y;
    //到达(x,y)需要通过的障碍数目
    int count;
    public Point(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
