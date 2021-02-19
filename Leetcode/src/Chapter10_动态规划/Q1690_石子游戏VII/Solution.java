package Chapter10_动态规划.Q1690_石子游戏VII;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/02/2021 23:11
 **/

public class Solution {
    public int stoneGameVII(int[] stones) {
        int len = stones.length;
        int[][] dp = new int[len][len];
        int[][] sum = new int[len][len];
        //dp[i][j]表示从i..j的区间里面先拿的人比后一个人的分差最大值
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                //sum[i][j]表示从i..j的区间和
                if(i == j){
                    sum[i][j] = stones[i];
                }else{
                    sum[i][j] = sum[i][j-1] + stones[j];
                }
            }
        }
        for(int i = len - 1; i >= 0; i--){
            for(int j = i+1; j < len; j++){
                //由于只有两个石头，先拿的人获得另外一个石头的分数，后一个人0份,所以最大的分数差就是石头的值
                if(j == i + 1){
                    dp[i][j] = Math.max(stones[i],stones[j]);
                }else{
                    //不然考虑两个可能性，那个可能性的值最大就是当前状态值
                    dp[i][j] = Math.max(sum[i+1][j] - dp[i+1][j],sum[i][j-1] - dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
