package Chapter0_其他.Q1191_K次串联后最大子数组之和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/01/2021 18:32
 **/

public class Solution {
    /**
     * 因为可以重复K次数组，所以当k >= 2时,可以将两个数组拼在一起
     * 此时拼接后的数组中的最大子数组和是起点，后续根据数组全场是否大于0
     * 因为子数组要求必须连续，所以当数组和大于0,那么可以将后续的数组也包含在内
     * 否则就不包含后续数组
     * @param arr
     * @param k
     * @return
     */
    public int kConcatenationMaxSum(int[] arr, int k) {
        long res = 0;
        int length = arr.length;
        //特别注意处理一下 k = 1这种特殊情况
        //把两个数组拼在一起是因为两个数组包含在一起，会包含所有的子数组情况
        long count = Math.min(2,k) * length;
        long cur = 0;
        long sum = 0;
        //求取数组和，后续根据sum > 0或者 sum < 0分成两者不同情况考虑
        for(int num : arr){
            sum += num;
        }
        //最大子数组和的逻辑就是简单dp，如果前缀和为大于0就保持，否则就设置成0
        for(int i = 0; i < count; i++){
            cur = cur + arr[i % length] > 0 ? cur + arr[i % length] : 0;
            res = Math.max(res,cur);
        }
        //当 k >= 2 且 sum > 0,那么就将sum *(k-2)加上
        if(sum > 0 && k >= 2){
            res = (res + sum * (k-2)) % 1_000_000_007;
        }
        return (int) res;
    }
}
