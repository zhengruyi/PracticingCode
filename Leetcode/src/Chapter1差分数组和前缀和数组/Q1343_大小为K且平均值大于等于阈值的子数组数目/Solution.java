package Chapter1差分数组和前缀和数组.Q1343_大小为K且平均值大于等于阈值的子数组数目;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/01/2021 23:31
 **/

public class Solution {
    /**
     * 为了快速求区间的平均值，这里用到前缀和来快递求得区间的和。除以k来获得区间的平均值
     * @param arr
     * @param k
     * @param threshold
     * @return
     */
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length;
        int[] prefixSum = new int[len+1];
        //前缀和数组
        for(int i = 0; i < len; i++){
            prefixSum[i+1] = prefixSum[i] + arr[i];
        }
        int ans = 0;
        //固定的长度k用滑动窗口来表示
        for(int i = k; i <= len; i++){
            //利用前缀和快速减速区间平均值
            if((prefixSum[i] - prefixSum[i-k])/k >= threshold){
                ans++;
            }
        }
        return ans;
    }
}
