package Chapter14_深度搜索和广度搜索.Q547_朋友圈;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/12/2020 16:17
 **/

public class Solution {
    public int findCircleNum(int[][] M) {
        if(M.length == 0 || M[0].length == 0){
            return 0;
        }
        int len = M.length;
        int[] visited = new int[len];
        int ans = 0;
        for(int i =0; i< len; i++){
            //由于每次深度搜索都会将相连的点全部设置成1，所以每次遇到未访问的节点
            //都代表一个新的朋友圈
            if(visited[i] == 0){
                dfs(M,i,visited);
                ans++;
            }
        }
        return ans;
    }
    //深度搜索，每个访问过的节点都需要标记成已访问
    public void dfs(int[][] M, int i, int[] visited){
        visited[i] = 1;
        for(int j = 0; j < M.length; j++){
            if(M[i][j] == 1 && visited[j] == 0){
                dfs(M,j,visited);
            }
        }
    }
}
