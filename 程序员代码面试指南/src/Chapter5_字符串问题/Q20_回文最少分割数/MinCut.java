package Chapter5_字符串问题.Q20_回文最少分割数;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/06/2020 14:42
 **/

public class MinCut {
    public int getMinCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chas = s.toCharArray();
        int len = chas.length;
        boolean[][] isPalindrome = new boolean[len][len];
        int[] dp = new int[len+1];
        // 保证dp[len] +1 = 0
        dp[len] = -1;
        for (int i = len - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (chas[i] == chas[j] && (j - i < 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    min = Math.min(min, dp[j + 1] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }

    @Test
    void test() {
        Assertions.assertEquals(0, getMinCut("ABA"));
        Assertions.assertEquals(2, getMinCut("ACDCDCDAD"));
    }
}
