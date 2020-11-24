import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public static String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        char[] chas = s.toCharArray();
        int start = 0;
        int[][] dp = new int[chas.length][chas.length];
        for(int i =0; i < chas.length; i++){
            dp[i][i] = 1;
        }
        int max = 0;
        for(int i = chas.length - 2; i >= 0; i--){
            for(int j = i+1; j < chas.length; j++){
                if(chas[i] == chas[j]){
                    dp[i][j] = dp[i+1][j-1] +2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
                if(dp[i][j] > max){
                    start = i;
                    max = dp[i][j];
                }
            }
        }
        return s.substring(start,start+max);
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
}
