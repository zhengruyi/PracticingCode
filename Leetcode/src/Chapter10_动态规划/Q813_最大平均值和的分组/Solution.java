package Chapter10_动态规划.Q813_最大平均值和的分组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/11/2020 23:14
 **/

public class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        if(A.length == 0){
            return 0;
        }
        int len = A.length;
        //前缀和数组，方便求区间的子数组和元素和
        double[] sum = new double[len+1];
        for(int i =1; i <= len; i++){
            sum[i] = sum[i-1] + A[i-1];
        }
        //dp[i][k]把元素i..len-1分成k+1组后等得到的最大子数组平均数和
        double [][] dp = new double[len][K];
        //dp[i][0]代表i..len-1的平均数和
        for(int i = 0; i < len; i++){
            dp[i][0] = (sum[len] - sum[i])/(len - i);
        }
        // k取值范围从0..K-1
        for(int k = 1; k < K; k++){
            //倒序遍历，因为计算时需要用到过去的状态
            for(int i = len - 1; i >=0; i--){
                double max = 0;
                //获取分割后的最大子数组平均和
                for(int j = i + 1; j < len; j++){
                    max = Math.max(max,dp[j][k-1] + (sum[j] - sum[i])/(j-i));
                }
                dp[i][k] = max;
            }
        }
        return dp[0][K-1];
    }
}
