package Chapter10_动态规划.Q467_环绕字符串中唯一的子字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/03/2021 23:44
 **/

public class Solution {
    /**
     * 这里由于考虑唯一性,所以替换成求以这个字符结尾的最长连续子串
     * @param p
     * @return
     */
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int count = 0;
        for(int i = 0; i < p.length(); i++){
            // -26 % 26 = 0
            //表示和前面是连续的那么count加1
            if(i > 0 && (p.charAt(i) - p.charAt(i-1) -1) % 26 == 0){
                count++;
            }else{
                count = 1;
            }
            //计算索引下标
            int index = p.charAt(i) - 'a';
            //记录以这个字符结尾的,连续字符串的最多的子串个数
            dp[index] = Math.max(dp[index],count);
        }
        int res = 0;
        //以当前字符结尾的最长连续字符串的子串个数的和就是答案
        for(int num : dp){
            res += num;
        }
        return res;
    }
}
