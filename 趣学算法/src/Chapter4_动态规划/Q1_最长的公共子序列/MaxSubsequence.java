package Chapter4_动态规划.Q1_最长的公共子序列;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/07/2020 11:06
 **/

public class MaxSubsequence {
    public static String maxSubsequence(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1][len2];
        dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
        //dp[i][j]表示s1[0...i]和s[0..j]之间的最小公共序列,所以只要有一个字符匹配上，后面的结果都是1
        for (int i = 1; i < len1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], s1.charAt(i) == s2.charAt(0) ? 1 : 0);
        }

        for (int i = 1; i < len2; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], s1.charAt(0) == s2.charAt(i) ? 1 : 0);
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        int size = dp[len1 - 1][len2 - 1];
        int i = len1 - 1;
        int j = len2 - 1;
        while (size > 0) {
            if (i > 0 && dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (j > 0 && dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                builder.append(s1.charAt(i));
                size--;
                i--;
                j--;
            }
        }
        return builder.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(maxSubsequence("BACDBA", "BACDBA"));
    }

}
