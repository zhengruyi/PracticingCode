package Chapter10_动态规划.Q1388_3n块披萨;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 31/10/2020 22:22
 **/

public class Solution {
    /**
     * 这题先要转换成打家劫舍问题，在应用Q213_打家劫舍—II的思想，
     *     由于首尾相连，所以答案在（0，end-1)和(1,end)中较大的一个
     */
    public int maxSizeSlices(int[] slices) {
        //分别得到不同区间的值
        int max1 = getMax(slices,slices.length -1, 0);
        int max2 = getMax(slices,slices.length-1, 1);
        return Math.max(max1,max2);
    }
    public int getMax(int[] nums, int len, int offset){
        //计算拿取的披萨数目
        int choose = (len+1)/3;
        int[][] dp = new int[len+1][choose+1];
        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= choose; j++){
                // dp[i][j] = max(dp[i-1][j],dp[i-2][j-1]+nums[i])
                dp[i][j] = Math.max(dp[i-1][j], (i-2 >= 0 ? dp[i-2][j-1] : 0) + nums[i-1     +offset]);

            }
        }
        return dp[len][choose];
    }
}
