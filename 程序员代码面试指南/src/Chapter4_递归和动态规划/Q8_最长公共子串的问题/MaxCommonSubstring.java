package Chapter4_递归和动态规划.Q8_最长公共子串的问题;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/06/2020 21:05
 **/

public class MaxCommonSubstring {
    public String findMaxCommonSubstring(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return null;
        }
        int[][] dp = process(s1, s2);
        String result = generateSubstring(s1, s2, dp);
        return result;
    }

    public int[][] process(String s1, String s2) {
        int rows = s1.length();
        int columns = s2.length();
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < columns; i++) {
            dp[0][i] = s2.charAt(i) == s1.charAt(0) ? 1 : 0;
        }
        for (int i = 0; i < rows; i++) {
            dp[i][0] = s1.charAt(i) == s2.charAt(0) ? 1 : 0;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = s1.charAt(i) == s2.charAt(j) ? dp[i - 1][j - 1] + 1 : 0;
            }
        }
        return dp;
    }

    public String generateSubstring(String s1, String s2, int[][] dp) {
        int max = 0;
        int end = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    end = i;
                }
            }
        }
        return s1.substring(end - max + 1, end + 1);
    }
    public String getMaxSubString(String s1, String s2){
        char[] sch1 = s1.toCharArray();
        char[] sch2 = s2.toCharArray();
        int row = 0;
        int column = s2.length() - 1;
        int max = 0;
        int end = 0;
        while (row < s1.length()){
            int i = row;
            int j = column;
            int len = 0;
            while (i < sch1.length && j< sch2.length){
                if(sch1[i] != sch2[j]){
                    len =0;
                }else{
                    len++;
                }
                //记录最大长度出现的地方，用来获取最后的值
                if(len > max){
                    max = len;
                    end =i;
                }
                i++;
                j++;
            }
            //从右上角沿着斜线遍历下去，所以先列数减少在行数递增
            if(column >0){
                column --;
            }else{
                row ++;
            }
        }
        return s1.substring(end - max +1, end+1);
    }
    @Test
    void test(){
        Assertions.assertEquals("2345",findMaxCommonSubstring("1AB2345CD","12345EF"));
        Assertions.assertEquals("2345",getMaxSubString("1AB2345CD","12345EF"));
    }
}
