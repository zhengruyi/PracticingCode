package Chapter0_其他.Q584_将数组分割成和相等的子数组;

import java.util.HashSet;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/03/2021 23:00
 **/

public class Solution {
    public boolean splitArray(int[] nums) {
        if(nums.length  < 7){
            return false;
        }
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        //前缀和数组
        for(int i = 1; i < n; i++){
            sum[i] = sum[i-1] + nums[i];
        }
        //遍历j所偶遇可能的位置
        for(int j = 3; j < n - 3; j++){
            HashSet <Integer> set = new HashSet();
            //遍历i所有可能的位置
            for(int i = 1; i < j - 1; i++){
                //如果可以切分成两个单独的数组,那么就将这个值存入set
                if(sum[j-1] - sum[i] == sum[i-1]){
                    set.add(sum[i-1]);
                }
            }
            //检查后面的数组,可以切分成和前面两个子数组和一样的子数组,如果可以就返回true
            for(int k = j+2; k < n-1; k++){
                if(sum[n-1] - sum[k] == sum[k-1] - sum[j] && set.contains(sum[n-1] - sum[k])){
                    return true;
                }
            }
        }
        return false;
    }
}
