package Chapter10_动态规划.Q978_最长湍流子数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/11/2020 16:42
 **/

public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        //dp[i][0/1]便是湍流数组的两种情况，0表示当前字符用大于前一个字符
        //1表示当前字符应该小于前一个字符
        int[][] dp = new int[len][2];
        //一个字符都算湍流字符，所以初始化为1
        for(int i = 0; i < len; i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        int max = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i-1]){
                //加上当改签字符后，后一个字符需要大于当前字符
                dp[i][1] = dp[i-1][0] + 1;
            }else if(arr[i] < arr[i-1]){
                //加上当改签字符后，后一个字符需要小于当前字符
                dp[i][0] = dp[i-1][1] + 1;
            }
            max = Math.max(max, Math.max(dp[i][0],dp[i][1]));
        }
        return max;
    }
}
