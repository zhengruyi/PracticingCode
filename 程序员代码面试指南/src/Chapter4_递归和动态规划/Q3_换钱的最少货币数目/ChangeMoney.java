package Chapter4_递归和动态规划.Q3_换钱的最少货币数目;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/06/2020 15:47
 **/

public class ChangeMoney {
    /**
     * 每张零钱可以使用无数次，很难，看不懂
     * @param arr
     * @param aim
     * @return
     */
    public int change(int[] arr, int aim){
       if(arr == null || arr.length == 0 || aim < 0){
           return -1;
       }
       int n = arr.length;
       int max = Integer.MAX_VALUE;
       int[][] dp = new int[n][aim +1];
       //初始化，行表示可以使用到的零钱种类，列表示当前的数字最少需要的零钱数目
        for (int i = 1; i <= aim; i++) {
            dp[0][i] = max;
            if(i - arr[0] >=0 && dp[0][i - arr[0]] != max){
                dp[0][i] = dp[0][i - arr[0]] +1;
            }
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim ; j++) {
                left = max;
                if(j - arr[i] >=0 && dp[i][j-arr[i]] != max){
                    left = dp[i][j-arr[i]] +1;
                }
                dp[i][j] = Math.min(left,dp[i-1][j]);
            }
        }
        return dp[n-1][aim] != max ? dp[n-1][aim] : -1;
    }

    /**
     * 每张零钱只能使用一次
     * @param arr
     * @param aim
     * @return
     */
    public int changeLevelTwo(int[] arr, int aim){
        if(arr == null || arr.length == 0 || aim < 0){
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim +1];
        for (int i = 1; i <= aim; i++) {
            dp[0][i] = max;
        }
        if(arr[0] <= aim){
            dp[0][arr[0]] =1;
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim ; j++) {
                left = max;
                if(j - arr[i] >=0 && dp[i-1][j-arr[i]] != max){
                    left = dp[i-1][j-arr[i]] +1;
                }
                dp[i][j] = Math.min(left,dp[i-1][j]);
            }
        }
        return dp[n-1][aim] != max ? dp[n-1][aim] : -1;
    }
    @Test
    void test(){
        int[] money = {5,2,3};
        Assertions.assertEquals(4,change(money,20));
        Assertions.assertEquals(2,change(money,10));
        Assertions.assertEquals(-1,change(money,1));
    }
    @Test
    void testLevelTwo(){
        int[] money = {5,2,3};
        Assertions.assertEquals(-1,changeLevelTwo(money,20));
        Assertions.assertEquals(3,changeLevelTwo(money,10));
    }
}
