package Chapter10_动态规划.Q1140_石子游戏II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/02/2021 22:33
 **/

public class Solution {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        //dp[i][j]表示从i..len - 1的区间,起始可以拿j堆石子
        //所能或得到的最大数目
        int[][] dp = new int[len][len+1];
        //sum表示从i..len的所有堆的所有石头堆数目总和
        int sum = 0;
        for(int i = len - 1; i >= 0; i--){
            sum += piles[i];
            for(int M = 1; M <= len; M++){
                //由于最多可以拿2*M堆石头，所以这种情况表示一次性可以拿光后面的石头堆
                if(i + 2 * M >= len){
                    dp[i][M] = sum;
                }else{
                    //当不能一次性拿光时,需要分对此拿，那么当前所能能拿取的石头堆数是
                    //1.. 2 * M,所以让对手拿到的数目最小就可以,而sum - dp[i+x][Math.max(x,M)]
                    //就是自己这次能拿到的最大值
                    for(int x = 1; x <= 2 * M; x++){
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i+x][Math.max(x,M)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
