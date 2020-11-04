package Chapter10_动态规划.Q91_解码方法;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/11/2020 18:58
 **/

public class Solution {
    public int numDecodings(String s) {
        char[] chas = s.toCharArray();
        //如果开头第一个字符就是'0'，那么无论如何都无法译码
        if(chas.length == 0 || chas[0] == '0'){
            return 0;
        }
        int[] dp = new int[chas.length+1];
        Arrays.fill(dp,1);
        for(int i = 1; i < chas.length; i++){
            //如果当前字符就是'0',则只能和前一个字符合并译码
            if(chas[i] == '0'){
                //如果前一个字符不是'1'或者'2',那么无法译码，直接返回0
                if(chas[i-1] != '1' && chas[i-1] != '2'){
                    return 0;
                }
                //由于当前i和i-1合并，所以当前译码种类和i-2处相同
                dp[i+1] = dp[i-1];
                //如果当前字符不是'0'且前一个字符为'1',那么译码种类等于i-1处的种类
                //加上i-2处的种类
            }else if(chas[i-1] == '1'){
                dp[i+1] = dp[i]+dp[i-1];
                //前一个字符为'2'且当前字符小于'6'，那么当前译码种类数等于i-1和i-2处的数目和
            }else if(chas[i-1] == '2'){
                if(chas[i] <='6'){
                    dp[i+1] = dp[i]+dp[i-1];
                }else{
                    //不然则只能单独译码，所以种类和i-1相同
                    dp[i+1] = dp[i];
                }
            }else{
                //以上天剑都不满足，则i处只能单独译码，种类和i-1处相同
                dp[i+1] = dp[i];
            }
        }
        return dp[chas.length];
    }
}
