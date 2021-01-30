package Chapter10_动态规划.Q1024_视频拼接;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/01/2021 21:14
 **/

public class Solution {
    public int videoStitching(int[][] clips, int T) {
        //按照视频的起始时间排序
        Arrays.sort(clips,(a, b) -> a[0] - b[0]);
        //由于视频持续时间最大为100,所以设置初始值最大值200
        int upper = 200;
        //创建动态规划数组
        int[] dp = new int[T+1];
        //填充初始值,然后dp[0] = 0;
        Arrays.fill(dp,upper);
        dp[0] = 0;
        for(int i = 0; i < clips.length; i++){
            int start = clips[i][0];
            int end = clips[i][1];
            //更新dp[j]，表示到达j分钟所需要的最少片段数目
            for(int j = start + 1; j <= end && j <= T; j++){
                //dp[j]表示到j分所需要的最少片段数
                dp[j] = Math.min(dp[j],dp[start] + 1);
            }
        }
        return dp[T] == upper ? -1 : dp[T];
    }
}
