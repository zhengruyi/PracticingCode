package Chapter5_滑动窗口算法.Q1558_所有奇数长度子数组的和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/03/2021 22:20
 **/

public class Solution {
    /**
     * 前缀和和固定窗口滑动
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n+1];
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + arr[i-1];
        }
        int res = 0;
        for(int i = 1; i <= n; i+= 2){
            for(int j = 0; j + i <= n; j++){
                res += sum[j+i] - sum[j];
            }
        }
        return res;
    }
}
