package Chapter4_递归和动态规划.Q9_最小的编辑代价;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/06/2020 22:47
 **/

public class MinimumCost {
    public int minimumCost(String str1,String str2, int ic, int dc, int rc){
        if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0){
            return -1;
        }
        int rows = str1.length();
        int columns = str2.length();
        int[][] dp = new int[rows][columns];
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            dp[i][0] = i * dc;
        }
        for (int i = 0; i < columns; i++) {
            dp[0][i] = i * ic;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                int res = max;
                res = Math.min(dc + dp[i-1][j],dp[i][j-1]+ic);
                if(str1.charAt(i-1) != str2.charAt(j-1)){
                    res = Math.min(res,dp[i-1][j-1]+rc);
                }else{
                    res = Math.min(res,dp[i-1][j-1]);
                }
                dp[i][j] = res;
            }
        }
        return dp[rows-1][columns-1];
    }

    @Test
    void test(){
        Assertions.assertEquals(2,minimumCost("abc","adc",5,3,2));
        Assertions.assertEquals(0,minimumCost("abc","abc",5,3,2));
        Assertions.assertEquals(8,minimumCost("abc","adc",5,3,100));
    }
}
