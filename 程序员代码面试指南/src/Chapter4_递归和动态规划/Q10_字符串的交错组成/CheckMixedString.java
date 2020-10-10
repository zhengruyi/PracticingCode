package Chapter4_递归和动态规划.Q10_字符串的交错组成;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/06/2020 12:22
 **/

public class CheckMixedString {
    public boolean check(String s1, String s2, String target) {
        if (s1 == null || s2 == null || target == null || target.length() != s1.length() + s2.length()) {
            return false;
        }
        int rows = s1.length();
        int columns = s2.length();
        boolean[][] dp = new boolean[rows + 1][columns + 1];
        dp[0][0] = true;
        for (int i = 1; i <= rows; i++) {
            dp[i][0] = s1.substring(0, i).equals(target.substring(0, i));
        }
        for (int i = 1; i <= columns; i++) {
            dp[0][i] = s2.substring(0, i).equals(target.substring(0, i));
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (dp[i - 1][j] && s1.charAt(i - 1) == target.charAt(i + j - 1)) {
                    dp[i][j] = true;
                } else if (dp[i][j - 1] && s2.charAt(j - 1) == target.charAt(i + j - 1)) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[rows][columns];
    }



    @Test
    void test() {
        String s1 = "AB";
        String s2 = "12";
        Assertions.assertTrue(check(s1, s2, "AB12"));
        Assertions.assertTrue(check(s1, s2, "A1B2"));
        Assertions.assertTrue(check(s1, s2, "A12B"));
        Assertions.assertTrue(check(s1, s2, "1A2B"));
        Assertions.assertTrue(check(s1, s2, "1AB2"));
    }
}
