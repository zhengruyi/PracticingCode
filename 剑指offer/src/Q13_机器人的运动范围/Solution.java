package Q13_机器人的运动范围;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/01/2021 23:20
 **/

public class Solution {
    int count = 0;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    /**
     * 简单的深度搜搜，只是额外增加一个条件要求横纵坐标的数位和小于等于k
     * 向四个方向搜索的要点就是保存横纵坐标的偏移量
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(0,0,m,n,k,visited);
        return count;
    }
    public void dfs(int i, int j, int m, int n, int k, boolean[][] visited){
        visited[i][j] = true;
        count++;
        for(int l = 0; l < dx.length; l++){
            int newX = i + dx[l];
            int newY = j + dy[l];
            if(newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && getSum(newX,newY) <= k){
                dfs(newX,newY,m,n,k,visited);
            }
        }
    }

    public int getSum(int i, int j){
        int sum = 0;
        while(i != 0 || j != 0){
            sum +=(i % 10 + j % 10);
            i = i / 10;
            j = j / 10;
        }
        return sum;
    }
}
