package Chapter14_深度搜索和广度搜索.Q994_腐烂的橘子;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/01/2021 19:58
 **/

public class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        //计算当开始到现在度过的时间
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        //新鲜的橘子个数
        int num = 0;
        //四个方向的偏移量
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        //广度遍历所需要用到的队列
        Queue <int[]> queue = new LinkedList <>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //找到所有的新鲜橘子数目，并且将腐烂橘子的坐标放入
                //队列
                if(grid[i][j] == 1){
                    num++;
                }else if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        if(num == 0){
            return 0;
        }
        //每次搜索四个方向，如果是新鲜橘子，则表示当前橘子腐烂
        //同时将新鲜橘子个数减到0
        while(!queue.isEmpty()){
            int size = queue.size();
            time++;
            //记录每轮要搜索的节点
            for(int j = 0; j < size; j++){
                int[] position = queue.poll();
                for(int i = 0; i < dx.length; i++){
                    int newX = position[0] + dx[i];
                    int newY = position[1] + dy[i];
                    if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1){
                        queue.offer(new int[] {newX,newY});
                        grid[newX][newY] = 2;
                        num--;
                    }
                }
            }
            if(num == 0){
                return time;
            }
        }
        return num == 0 ? time : -1;
    }
}
