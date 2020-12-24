package Q52_把数字翻译成字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 00:40
 **/

public class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len + 1];
        //边界条件为空字符串可以翻译成一种
        dp[0] = 1;
        for(int i = 0; i < len; i++){
            //如果可以和前面构成两位数就可以多一种可能行为do[i-1]这里i位置的字符对应的结果为do[i+1]
            if(i-1 >= 0 && (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '5'))){
                dp[i+1] += dp[i-1];
            }
            dp[i+1] += dp[i];
        }
        return dp[len];
    }
}
