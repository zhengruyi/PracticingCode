package Chapter10_动态规划.Q375_猜数字大小II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/03/2021 22:26
 **/

public class Solution {
    /**
     * 典型的区间动态规划
     * @param n
     * @return
     */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        //要猜的区间长度
        for(int len = 2; len <= n; len++){
            //根据区间长度计算,区间起始点的范围
            for(int start = 1; start <= n - len + 1; start++){
                int min = Integer.MAX_VALUE;
                //所有可能的分割点,求其中猜中数字需要最小的花费
                for(int pivot = start; pivot < start + len - 1; pivot++){
                    int res = pivot + Math.max(dp[start][pivot-1],dp[pivot+1][start+len-1]);
                    min = Math.min(res,min);
                }
                //求出在这个区间猜中数字需要的最少话费
                dp[start][start+len -1] = min;
            }
        }
        return dp[1][n];
    }
}
