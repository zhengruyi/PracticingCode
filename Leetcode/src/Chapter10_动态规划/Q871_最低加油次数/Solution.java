package Chapter10_动态规划.Q871_最低加油次数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/11/2020 23:07
 **/

public class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target){
            return 0;
        }
        int len = stations.length;
        //表示加i次油最远可以跑出的距离
        int[] dp = new int[len+1];
        dp[0] = startFuel;
        for(int i = 0 ;i < len; i++){
            //倒序遍历的原因，是防止正序遍历时出现叠加的情况
            for(int j = i; j >= 0; j--){
                if(dp[j] >= stations[i][0]){
                    //表示在当前加油站加油后最远可以抛出的距离
                    dp[j+1] = Math.max(dp[j+1],dp[j]+stations[i][1]);
                }
            }
        }
        //只要dp[j]大于等于target，则i就是所求结果
        for(int i = 0; i<= len; i++){
            if(dp[i] >= target){
                return i;
            }
        }
        return -1;
    }
}
