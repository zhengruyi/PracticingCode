package Chapter14_深度搜索和广度搜索.Q698_划分成k个相等的子集;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/01/2021 20:14
 **/

public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum % k > 0){
            return false;
        }
        //计算均分的值
        int target = sum/k;
        //排序，从大的元素开始放
        Arrays.sort(nums);
        int row = nums.length - 1;
        //优化从末尾扫描，去除单个元素就满足的值
        while(nums[row] == target){
            row--;
            k--;
        }
        return search(nums,row,new int[k],target);
    }
    public boolean search(int[] nums, int row, int[] groupes, int target){
        if(row < 0){
            return true;
        }
        int value = nums[row--];
        for(int i = 0; i < groupes.length; i++){
            if(groupes[i] + value <= target){
                groupes[i] += value;
                //将当前值放入桶中,然后递归尝试把下一个值放入下一个桶中
                if(search(nums,row,groupes,target)){
                    return true;
                }
                groupes[i] -= value;
            }
            //由于桶是平等的，如果当前桶中所有元素不满足情况，那么放入三号桶中也是一样
            //所以可以直接跳出来减枝优化
            if(groupes[i] == 0){
                break;
            }
        }
        return false;
    }
}
