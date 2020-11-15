package Chapter10_动态规划.Q174_地下城游戏;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/11/2020 18:08
 **/

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        //dp[i][j]表示最小的其实质能从i,j这点走到末尾
        int[][] dp = new int[rows][cols];
        //倒序遍历，最后一个节点的值等于终点的倒数
        dp[rows-1][cols-1] = Math.max(0,-dungeon[rows-1][cols-1]);
        //处理最后一列的边界条件
        for(int i = rows-2; i >= 0; i--){
            dp[i][cols-1] = Math.max(dp[i + 1][cols-1] - dungeon[i][cols-1], 0);
        }
        //处理最后一行的边界条件
        for(int j = cols - 2; j >= 0; j--){
            dp[rows-1][j] = Math.max(dp[rows-1][j+1] - dungeon[rows-1][j], 0);
        }
        //反向遍历求出起始点的最小健康值
        for(int i = rows -2; i >= 0; i--){
            for(int j = cols-2; j >= 0; j--){
                dp[i][j] = Math.max(Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j], 0);
            }
        }
        return dp[0][0] + 1;
    }
}
