package Chapter0_其他.Q959_由斜杠划分区域;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/02/2021 23:49
 **/

public class Solution {
    public int regionsBySlashes(String[] grid) {
        int m = grid.length;
        int[][] graph = new int[m*3][m*3];
        //将每个单元小格用更大的3*3填充，然后将题目转化成岛屿数目
        //那么求独立的水域个数就是最终的答案
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(grid[i].charAt(j) == '/'){
                    graph[i*3][j*3+2] = 1;
                    graph[i*3+1][j*3+1] = 1;
                    graph[i*3+2][j*3] = 1;
                }else if(grid[i].charAt(j) == '\\'){
                    graph[i*3][j*3] = 1;
                    graph[i*3+1][j*3 + 1] = 1;
                    graph[i*3+2][j*3+2] = 1;
                }
            }
        }
        //dfs求独立的水域个数
        int res = 0;
        for(int i = 0; i < 3 * m; i++){
            for(int j = 0; j < 3 * m; j++){
                if(graph[i][j] == 0){
                    dfs(graph,i,j,m);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(int[][] graph, int i, int j, int len){
        if(i >= 0 && i < 3 * len && j >= 0 && j < 3 * len && graph[i][j] == 0){
            graph[i][j] = 1;
            dfs(graph,i+1,j,len);
            dfs(graph,i-1,j,len);
            dfs(graph,i,j+1,len);
            dfs(graph,i,j-1,len);
        }
    }
}
