package Chapter0_其他.Q1267_统计参与通信的服务器;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/01/2021 18:27
 **/

public class Solution {
    public int countServers(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        //两个数组用来统计行和列上存在的服务器
        int[] countRow = new int[m];
        int[] countCol = new int[n];
        //统计当前左边的同一行和同一列的服务器数目
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    countCol[j] ++;
                    countRow[i] ++;
                }
            }
        }
        int res = 0;
        //在一次遍历列表，当当前的行或者列的服务器数目大于1，说明当前服务器可以通信
        //所以总的可通信服务器数目加1
        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                if(grid[i][j] == 1 && (countRow[i] > 1 || countCol[j] > 1)){
                    ++res;
                }
            }
        }
        return res;
    }
}
