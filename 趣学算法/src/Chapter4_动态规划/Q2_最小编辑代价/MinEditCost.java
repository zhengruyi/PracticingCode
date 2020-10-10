package Chapter4_动态规划.Q2_最小编辑代价;

import jdk.jfr.StackTrace;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/07/2020 17:55
 **/

public class MinEditCost {
    public int minCost(String s1, String s2, int ic, int dc, int rc){
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dc * i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i*ic;
        }
        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <= len2 ; j++) {
                int min = Math.min(dp[i][j-1]+ic,dp[i-1][j]+dc);
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    min = Math.min(min,dp[i-1][j-1]);
                }else{
                    min = Math.min(min,dp[i-1][j-1]+rc);
                }
                dp[i][j] = min;
            }
        }
        return dp[len1][len2];
    }

    @Test
    public void test(){
        Assert.assertEquals(2,minCost("abc","adc",5,3,2));
        Assert.assertEquals(8,minCost("abc","adc",5,3,100));
        Assert.assertEquals(0,minCost("abc","abc",5,3,2));
    }
}
