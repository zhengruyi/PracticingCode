package Chapter4_递归和动态规划.Q11_龙与地下城游戏问题;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/06/2020 13:37
 **/

public class MinimumHP {
    public int getMinimumHp(int[][] map) {
        if (map == null) {
            return -1;
        }
        int rows = map.length;
        int columns = map[0].length;
        int[][] dp = new int[rows][columns];
        dp[rows - 1][columns - 1] = 1 - map[rows - 1][columns - 1];
        for (int j = columns - 2; j >= 0; j--) {
            dp[rows - 1][j] = Math.max(dp[rows - 1][j + 1] - map[rows - 1][j], 1);
        }
        for (int i = rows - 2; i >= 0; i--) {
            dp[i][columns - 1] = Math.max(dp[i + 1][columns - 1] - map[i][columns - 1], 1);
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = columns - 2; j >= 0; j--) {
                int right = Math.max(dp[i][j + 1] - map[i][j], 1);
                int bottom = Math.max(dp[i + 1][j] - map[i][j], 1);
                dp[i][j] = Math.min(right, bottom);
            }
        }
        return dp[0][0];
    }

    @Test
    void test() {
        int[][] matrix = {{-2,-3,3},{-5,-10,1},{0,30,-5}};
        Assertions.assertEquals(7,getMinimumHp(matrix));
    }
}
