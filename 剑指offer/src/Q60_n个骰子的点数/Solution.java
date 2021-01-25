package Q60_n个骰子的点数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/01/2021 22:53
 **/

public class Solution {
    public double[] dicesProbability(int n) {
        //dp[i][k]表示从i个骰子点数总和为k的出现次数
        int[][] dp = new int[n+1][n*6 + 1];
        //一个骰子时点数从1..6，且只有一种可能
        for(int i = 1; i <= 6; i++){
            dp[1][i] = 1;
        }
        //i从2..n个骰子的遍历
        for(int i = 2; i <= n; i++){
            //点数总和从最少i..6*i
            for(int j = i; j <= i * 6; j++){
                //每个骰子的点数从1到6
                for(int cur = 1; cur <= 6; cur++){
                    //由于cur是递增的，所以直接跳出循环
                    if(j - cur <= 0){
                        break;
                    }
                    //用i个骰子表示总数j所有可能的组合数 = 用前i-1个骰子表示j-cur,然后用一个骰子表示cur
                    dp[i][j] += dp[i-1][j - cur];
                }
            }
        }
        //计算所偶遇可能的组合数
        double total = Math.pow(6,n);
        //计算不同总数的出现概率
        double[] res = new double[n * 6 - n + 1];
        for(int i = n; i <= 6 * n; i++){
            res[i - n] = dp[n][i] / total;
        }
        return res;
    }
}
