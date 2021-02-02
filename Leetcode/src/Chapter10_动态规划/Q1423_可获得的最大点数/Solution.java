package Chapter10_动态规划.Q1423_可获得的最大点数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/02/2021 23:42
 **/

public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int[][] dp = new int[len + 2][2];
        //从左往右计算前缀和
        for(int i = 0; i < len; i++){
            dp[i+1][0] = dp[i][0] + cardPoints[i];
        }
        //从右往左计算前缀和
        for(int i = len - 1; i >= 0; i--){
            dp[i+1][1] = dp[i+2][1] + cardPoints[i];
        }
        int res = 0;
        for(int i = 0; i <= k; i++){
            //由于牌都分给一个人，所以大致可以分成左边拿走left张,右边拿 k - left 张
            int left = i;
            int right = len - (k - i) + 1;
            //所以宗的分数等于两个前缀和数组的总和
            res = Math.max(res,dp[left][0] + dp[right][1]);
        }
        return res;
    }
}
