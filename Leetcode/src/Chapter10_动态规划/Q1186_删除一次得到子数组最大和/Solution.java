package Chapter10_动态规划.Q1186_删除一次得到子数组最大和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/02/2021 23:08
 **/

public class Solution {
    public int maximumSum(int[] arr) {
        int len = arr.length;
        int[][] dp = new int[len][2];
        //dp[i][0]表示从0..i不删除一个元素所能得到的最大子数组和
        dp[0][0] = arr[0];
        //dp[i][1]表示从0..i删除一个
        dp[0][1] = -1_00000;
        //起始值是数组的第一个元素
        int res = Math.max(dp[0][0],dp[0][1]);
        for(int i = 1; i < len; i++){
            //表示从0..i目前为止的最大子数组和
            dp[i][0] = Math.max(dp[i-1][0] + arr[i],arr[i]);
            //从0..i中的删除一个元素后的最大子数组和等于要么删掉中间一个元素
            // dp[i-1][1]或者删掉最后一个元素dp[i-1][0]
            dp[i][1] = Math.max(dp[i-1][1] + arr[i], dp[i-1][0]);
            //更新最大值
            res = Math.max(res,Math.max(dp[i][0],dp[i][1]));
        }
        return res;
    }
}
