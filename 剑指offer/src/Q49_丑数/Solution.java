package Q49_丑数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 23:24
 **/

public class Solution {
    /**
     * 这里注意i2,i3,i5指针要遍历的序列是dp数组，且每次确定值之后
     * 都要搜索i2,i3和i5,因为可能存在一种情况i2 * 2 = i3 * 3
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for(int i = 1; i < n; i++){
            int min = Math.min(2 * dp[i2],Math.min(dp[i3] * 3, dp[i5] * 5));
            if(dp[i2] * 2 == min){
                i2++;
            }
            if(dp[i3] * 3 == min){
                i3++;
            }
            if(dp[i5] * 5 == min){
                i5++;
            }
            dp[i] = min;
        }
        return dp[n-1];
    }
}
