package Chapter10_动态规划.Q19_秋叶收藏集;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/01/2021 23:17
 **/

public class Solution {
    public int minimumOperations(String leaves) {
        int length = leaves.length();
        //dp[0][i]表示从0..i所有叶子都是红叶所需要的最小操作次数
        //dp[1][i]表示从0..i所偶遇叶子先红再黄所需要的最小操作次数
        //dp[2][i]表示从0..i所遇到的叶子先红再黄再红所需要的最小操作次数
        int[][] dp = new int[3][length];
        for(int i = 0; i < length; i++){
            if(i < 1){
                dp[0][i] = (leaves.charAt(i) != 'r' ? 1 : 0);
            }else{
                dp[0][i] = dp[0][i-1] + (leaves.charAt(i) != 'r' ? 1 : 0);
            }

            if(i < 1){
                //由于是先红后黄，所以i == 0的结果等于dp[0][i]
                dp[1][i] = dp[0][i];
            }else{
                dp[1][i] = Math.min(dp[1][i-1] + (leaves.charAt(i) != 'y' ? 1 : 0), dp[0][i-1] + (leaves.charAt(i) != 'y' ? 1 : 0));
            }
            if(i < 2){
                //由于是先红后黄再红，所以前两个结果等于dp[1][i]
                dp[2][i] = dp[1][i];
            }else{
                dp[2][i] = Math.min(dp[2][i-1] + (leaves.charAt(i) != 'r' ? 1 : 0), dp[1][i-1] + (leaves.charAt(i) != 'r' ? 1 : 0));
            }
        }
        return dp[2][length-1];
    }
}
