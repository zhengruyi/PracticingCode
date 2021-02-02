package Chapter15_面试题.Q1709_第k个数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/02/2021 23:26
 **/

public class Solution {
    /**
     * 就是一种丑数的形式,创建三个指针分别指向动态数组的初始位置,每次取三个指针中的数字计算后
     * 的结果的最小值,然后依次更新三个指针的位置
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int i3 = 0,i5 = 0, i7 = 0;
        for(int i = 1; i <k; i++){
            int num = Math.min(dp[i3] * 3, Math.min(dp[i5] * 5, dp[i7] * 7));
            dp[i] = num;
            if(dp[i3] * 3 == num){
                i3++;
            }
            if(dp[i5] * 5 == num){
                i5++;
            }
            if(dp[i7] * 7 == num){
                i7++;
            }
        }
        return dp[k-1];
    }
}
