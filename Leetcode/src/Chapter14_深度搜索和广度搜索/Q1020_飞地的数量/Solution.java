package Chapter14_深度搜索和广度搜索.Q1020_飞地的数量;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/01/2021 18:49
 **/

public class Solution {
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    int m;
    int n;
    public int numEnclaves(int[][] A) {
        m = A.length;
        n = A[0].length;
        /**
         * 基本思路就是沿着边界，通过dfs来将所有和边界相连的
         * 陆地全部淹没，然后在搜索全体矩阵，剩下的陆地就是非第数目
         */
        //遍历上下两行的边界，用dfs进行搜索
        for(int j = 0; j < n; j++){
            if(A[0][j] == 1){
                dfs(A,0,j);
            }
            if(A[m-1][j] == 1){
                dfs(A,m-1,j);
            }
        }
        //遍历左右边界，将所有相连的陆地淹没
        for(int i = 0; i < m; i++){
            if(A[i][0] == 1){
                dfs(A,i,0);
            }
            if(A[i][n-1] == 1){
                dfs(A,i,n-1);
            }
        }
        //搜索剩余的陆地，剩余的陆地就都是飞地
        int res = 0;
        for(int i = 1; i < m-1; i++){
            for(int j = 1; j < n-1; j++){
                if(A[i][j] == 1){
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(int[][] A, int r, int c){
        A[r][c] = 0;
        for(int i = 0; i < dx.length; i++){
            int newX = r + dx[i];
            int newY = c + dy[i];
            if(newX >= 0 && newX < m && newY >= 0 && newY < n && A[newX][newY] == 1){
                dfs(A,newX,newY);
            }
        }
    }
}
