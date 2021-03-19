package Chapter10_动态规划.Q361_轰炸敌人;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/03/2021 23:28
 **/

public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        //分别表示从上,下,左，右四个方向上到当前位置可以炸死的敌人数目
        //分两次循环,分别从左边和上边进行遍历,
        //另外一组从右下进行 遍历
        //最后靠这四个数组进行计算,可以炸死的敌人的总数目
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 'W'){
                    up[i][j] = 0;
                    left[i][j] = 0;
                    continue;
                } else if(grid[i][j] == '0'){
                    up[i][j] = i == 0 ? 0 : up[i-1][j];
                    left[i][j] = j == 0 ? 0 : left[i][j-1];
                }else if(grid[i][j] == 'E'){
                    up[i][j] = i == 0 ? 1 : up[i-1][j] + 1;
                    left[i][j] = j == 0 ? 1 : left[i][j-1] + 1;
                }
            }
        }
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(grid[i][j] == 'W'){
                    down[i][j] = 0;
                    right[i][j] = 0;
                    continue;
                } else if(grid[i][j] == '0'){
                    down[i][j] = i == m-1 ? 0 : down[i+1][j];
                    right[i][j] = j == n-1 ? 0 : right[i][j+1];
                }else if(grid[i][j] == 'E'){
                    down[i][j] = i == m-1 ? 1 : down[i+1][j] + 1;
                    right[i][j] = j == n-1 ? 1 : right[i][j+1] + 1;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '0'){
                    res = Math.max(res,up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        return res;
    }
}
