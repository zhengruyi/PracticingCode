package Chapter10_动态规划.Q351_安卓系统手势解锁;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 23:17
 **/

public class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        //这里skip[i][j]表示九宫格上从i..j中间需要跨过的字符
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[7][3] = skip[3][7] = skip[4][6] = skip[6][4] = skip[2][8] = skip[8][2] = 5;
        boolean[] visited = new boolean[10];
        int res = 0;
        for(int i = m; i <=n ;i++){
            //从1,3,7,9出发情况相同
            res += dfs(skip,visited,1,i-1) * 4;
            //从2，4，6，8出发情况相同
            res += dfs(skip,visited,2,i-1) * 4;
            //从5出发一种特殊情况
            res += dfs(skip,visited,5,i-1);
        }
        return res;

    }
    public int dfs(int[][] skip, boolean[] visited, int cur, int remain){
        if(remain == 0){
            return 1;
        }
        //标记已访问
        visited[cur] = true;
        int res = 0;
        for(int i = 1; i <= 9; i++){
            int crossNumber = skip[cur][i];
            //当目标位置未访问过且中间的间隔节点已经访问过或者中间没有间隔节点时可以访问目标
            if(!visited[i] && (crossNumber == 0 || visited[crossNumber])){
                //便是以当前点为起点，remain-1个点的长度可以构成的有效序列
                res += dfs(skip,visited,i,remain-1);
            }
        }
        //回溯，撤销选择
        visited[cur] = false;
        return res;
    }
}
