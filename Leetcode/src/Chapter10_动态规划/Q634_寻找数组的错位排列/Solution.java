package Chapter10_动态规划.Q634_寻找数组的错位排列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/02/2021 21:31
 **/

public class Solution {
    /**
     * 将1..n中假设将n放到k的位置上，那么如果k也放到n位置上，那么问题转化成n-2的子问题
     * 如果k没有放到n的位置上,那么问题转化成n-1的子问题，所以:
     * dp[n] = (n-1) * (dp[n-1] + dp[n-2]) n-1表示 n-1个位置
     * @param n
     * @return
     */
    public int findDerangement(int n) {
        long dp_1 = 1;
        long dp_2 = 1;
        long res = 0;
        for(int i = 1; i <= n; i++){
            res = ((i - 1) * (dp_1 + dp_2))%1000_000_007;
            dp_2 = dp_1;
            dp_1 = res;
        }
        return (int) res;
    }
}
