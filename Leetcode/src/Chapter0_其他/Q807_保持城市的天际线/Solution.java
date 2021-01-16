package Chapter0_其他.Q807_保持城市的天际线;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/01/2021 20:27
 **/

public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //保存水平方向的最大值
        int[] horizon = new int[m];
        //保存垂直方向上的最大值
        int[] vertical = new int[n];
        for(int i = 0; i < m; i++){
            int max = -1;
            for(int j = 0; j < n; j++){
                max = Math.max(max,grid[i][j]);
            }
            horizon[i] = max;
        }
        for(int j = 0; j < n; j++){
            int max = -1;
            for(int i = 0; i < m; i++){
                max = Math.max(max,grid[i][j]);
            }
            vertical[j] = max;
        }
        int res = 0;
        //根据坐标找出当前行的最大值和当前列的最大值，他们中的最小值就是当前楼高度所达到的最大高度
        //两者之间的差值 就和就是题解
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res += Math.min(horizon[i],vertical[j]) - grid[i][j];
            }
        }
        return res;
    }
}
