package Chapter10_动态规划.Q32_最长有效括号;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/11/2020 22:06
 **/

public class Solution {
    /**
     * 动态规划即使在定义好dp数组后，合理思考所有的情况，总结动态转移方程
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int max = 0;
        for(int i = 1; i < chars.length; i++){
            //对于'('，dp[i]= 0，所以直接跳过
            if(chars[i] == ')'){
                //对于()这种情况，dp[i] = dp[i-2]+2;
                if(chars[i-1] == '('){
                    dp[i] = (i-2 >= 0 ? dp[i-2] : 0) +2;
                }else if(i - dp[i-1] -1 >= 0){
                    //对于(())这种情况，要计算出(对应的位置,为 i-dp[i-1]-1
                    //这里尤其注意()(())这种情况，需要把前面的括号连接起来算作最长的括号序列
                    //所以要考虑 dp[i - dp[i-1] -2]处的值
                    if(chars[i - dp[i-1] -1] == '('){
                        dp[i] = dp[i-1] + 2 + (i - dp[i-1] -2 >= 0 ? dp[i - dp[i-1] -2] : 0 );
                    }
                }
            }
            //返回全局最长的长度
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
