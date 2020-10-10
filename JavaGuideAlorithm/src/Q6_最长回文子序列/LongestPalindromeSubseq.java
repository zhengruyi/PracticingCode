package Q6_最长回文子序列;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/05/2020 10:32
 **/

public class LongestPalindromeSubseq {
    /*
    分为两种情况考虑：

1.如果str的最后一个元素和第一个元素是相同的，则有：[公式]例如字符串序列“AABACACBA”，第一个元素和最后一个元素相同，其中lps(1,n-2)表示加粗部分的最长回文子序列的长度；
2.如果str的最后一个元素和第一个元素是不相同的，则有：

[公式]例如字符串序列“ABACACB”，其中表示去掉第一元素的子序列，表示去掉最后一个元素的子序列。DP采用两重循环，第一重循环枚举区间长度，从1到n-1。第二重循环枚举要考察的区间起点，从0到n-i。于是，我们有如下DP：
   */
    public int getLength(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int length = s.length();
        char[] chars = s.toCharArray();
        //第一维度表示起点，第二维度表示终点dp[i][j]表示以i为起点j为终点的最大回文子序列的长度
        int[][] dp = new int[length][length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        // 表示遍历指定长度的子序列
        for (int i = 1; i <length; i++) {
            // 确定起始位置
            for (int j = 0; j + i < length; j++) {
                if (chars[j] == chars[j + i]) {
                    dp[j][j + i] = dp[j + 1][j + i - 1] + 2;
                } else {
                    dp[j][j + i] = Math.max(dp[j][j + i - 1],dp[j + 1][j + i]);
                }
            }
        }
        return dp[0][length-1];
    }
    @Test
    void test(){
        Assertions.assertEquals(4,getLength("bbbab"));
        Assertions.assertEquals(2,getLength("cbbd"));
    }
}
