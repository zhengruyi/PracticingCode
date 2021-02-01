package Chapter14_深度搜索和广度搜索.Q934_最短的桥;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/02/2021 23:10
 **/

public class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    Queue <int[]> queue;
    boolean[][] visited;
    int m;
    int n;

    /**
     * 首先广度遍历找到第一个岛屿的全部坐标，然后从这个岛屿的坐标出发广度遍历
     * 第一次碰到另外一个岛屿就是要把两个岛屿连在一起所必须的经过的0的数目
     * @param A
     * @return
     */
    public int shortestBridge(int[][] A) {
        int step = -1;
        queue = new LinkedList <>();
        m = A.length;
        n = A[0].length;
        visited = new boolean[m][n];
        //找到第一个岛屿
        find:
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(A[i][j] == 1){
                    dfs(A,i,j);
                    break find;
                }
            }
        }
        //从第一个岛屿出发进行广度遍历,第一次接触到另外一个岛所经过的路径就是把两个岛连在一起
        //所系要经过的最短路径
        while(!queue.isEmpty()){
            int size = queue.size();
            step++;
            for(int i = 0; i < size; i++){
                int[] tmp = queue.poll();
                int x = tmp[0];
                int y = tmp[1];
                for(int j = 0; j < dx.length; j++){
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY]){
                        continue;
                    }
                    if(A[newX][newY] == 1){
                        return step;
                    }
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX,newY});
                }
            }
        }
        return step;
    }
    public void dfs(int[][] A, int x, int y){
        visited[x][y] = true;
        queue.offer(new int[]{x,y});
        for(int i = 0; i < dx.length; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX < m && newX >= 0 && newY < n && newY >= 0 && !visited[newX][newY] && A[newX][newY] == 1){
                dfs(A,newX,newY);
            }
        }
    }
}
