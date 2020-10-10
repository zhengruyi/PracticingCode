package Chapter5_字符串问题.Q12_添加最少字符使字符串整体都是回文字符串;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/06/2020 20:01
 **/

public class InsertWordPalindrome {
    public String getPalindrome(String origin) {
        if (origin == null || origin.length() == 0) {
            return null;
        }
        int[][] dp = getDP(origin);
        return getString(dp, origin);
    }


    public int[][] getDP(String s) {
        char[] str = s.toCharArray();
        int[][] dp = new int[str.length][str.length];
        for (int j = 1; j < str.length; j++) {
            dp[j - 1][j] = str[j - 1] == str[j] ? 0 : 1;
            for (int i = j - 2; i > -1; i--) {
                if (str[i] == str[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp;
    }

    public String getString(int[][] dp, String s) {
        char[] chas = new char[dp[0][dp.length - 1] + s.length()];
        int length = chas.length;
        char[] origin = s.toCharArray();
        int start = 0;
        int end = origin.length - 1;
        int i = 0;
        int j = chas.length - 1;
        while (i <= j) {
            if (origin[start] == origin[end]) {
                chas[i] = origin[start];
                chas[j] = origin[start];
                start++;
                end--;
            } else {
                if (dp[start][end - 1] < dp[start + 1][end]) {
                    chas[i] = origin[end];
                    chas[j] = origin[end];
                    end--;
                } else {
                    chas[i] = origin[start];
                    chas[j] = origin[start];
                    start++;
                }
            }
            i++;
            j--;
        }
        return String.valueOf(chas);
    }

    public String getPalindromeTwo(String s, String subsequence) {
        char[] sub = subsequence.toCharArray();
        Stack <String> left = new Stack <>();
        Stack <String> right = new Stack <>();
        int start = 0;
        int end = s.length();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < (sub.length+1) / 2; i++) {
            char c = sub[i];
            int leftIndex = s.indexOf(c);
            int rightIndex = s.lastIndexOf(c);
            String leftPart = s.substring(start, leftIndex);
            String rightPart = s.substring(rightIndex + 1, end);
            left.add(leftPart + builder.append(rightPart).reverse().toString() + c);
            builder.delete(0, rightPart.length());
            //防止奇数长度的回文字符串,中间字符被多复制一次的问题
            if(sub.length % 2 == 1 && i == (sub.length+1) / 2 -1){
                right.add(rightPart + builder.append(leftPart).reverse().toString());
            }else{
                right.add(c + rightPart + builder.append(leftPart).reverse().toString());
            }

            builder.delete(0, leftPart.length());
            start = leftIndex + 1;
            end = rightIndex;
        }
        String result = "";
        while (!left.isEmpty()) {
            result = left.pop() + result + right.pop();
        }
        return result;
    }

    @Test
    void test() {
        Assertions.assertEquals("ABA", getPalindrome("AB"));
        Assertions.assertEquals("ABCBA", getPalindrome("ABCB"));
        Assertions.assertEquals("ADBCBDA", getPalindrome("ABCBD"));
        Assertions.assertEquals("AC1B2B1CA", getPalindromeTwo("A1B21C", "121"));
        Assertions.assertEquals("AC1B2B1CA", getPalindromeTwo("A1B2B1C", "1B2B1"));
    }
}
