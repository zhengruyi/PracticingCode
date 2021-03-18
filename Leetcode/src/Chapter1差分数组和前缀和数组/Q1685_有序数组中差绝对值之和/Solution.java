package Chapter1差分数组和前缀和数组.Q1685_有序数组中差绝对值之和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/03/2021 23:05
 **/

public class Solution {
    /**
     * 因为是有序数组，所以本质上可以采用前缀和数组来进行计算
     * @param nums
     * @return
     */
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
        int[] prefixSum = new int[len + 1];
        //计算前缀和数组
        for(int i = 1; i <= len; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        int[] res = new int[len];
        //计算时将绝对值差分成两部分,前半部分都小于nums[i],所以前半部分的绝对值和等于 i * nums[i] - prefixSum[i]
        // 后半段都大于nums[i],所以后半段差的绝对值的和等于 prefixSum[i] - i * nums[i]
        for(int i = 0; i < len; i++){
            int left = 0;
            if(i > 0){
                left = i * nums[i] - prefixSum[i];
            }
            int right = 0;
            if(i < len - 1){
                right = prefixSum[len] - prefixSum[i] - (len - i) * nums[i];
            }
            //宗的绝对值和等于左边加右边
            res[i] = left + right;
        }
        return res;
    }
}
