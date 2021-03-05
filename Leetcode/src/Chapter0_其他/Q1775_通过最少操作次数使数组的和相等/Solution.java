package Chapter0_其他.Q1775_通过最少操作次数使数组的和相等;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/03/2021 23:04
 **/

public class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        //求两者的数组元素和
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        //保证 sum1的和小于sum2
        if(sum1 > sum2){
            return minOperations(nums2,nums1);
        }
        //两个数组对应位置的元素的差值的最大值，统计这个差值的频率
        int[] freq = new int[6];
        //数组和的差值,一定是正的
        int diff = sum2 - sum1;
        //因为一定是正的且sum2 > sum1，所以对于n1的元素最大可以变成6，那么两者之间的差值减少 6 - num
        for(int num : nums1){
            ++ freq[6 - num];
        }
        //因为一定是正的且sum2 > sum1，所以对于n2的元素最小可以变成1，那么两者之间的差值减少 num - 1
        for(int num : nums2){
            ++ freq[num - 1];
        }
        int res = 0;
        //贪心,尽可能每次将差值尽可能的减少
        for(int i = 5; i >= 0 && diff > 0; i--){
            while(diff > 0 && freq[i] > 0){
                diff -= i;
                --freq[i];
                res++;
            }
        }
        return diff > 0 ? -1 : res;
    }
}
