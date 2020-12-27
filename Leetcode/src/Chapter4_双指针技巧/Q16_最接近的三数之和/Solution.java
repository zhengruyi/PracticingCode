package Chapter4_双指针技巧.Q16_最接近的三数之和;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 22:27
 **/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //先排序，然后固定一个元素，剩下进行双指针搜索来找到最接近目标的三数之和
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = -50000;
        for(int i = 0; i < nums.length-2; i++){
            //固定nums[i],然后left 和 right 双指针向中间进行搜索
            left = i + 1;
            right = nums.length -1;
            sum = target - nums[i];
            int offset = Integer.MAX_VALUE;
            int twoSum = 0;
            while(left < right){
                //比较偏差，选择较小偏差的两数之和
                if(offset > Math.abs(sum - nums[left] - nums[right])){
                    offset = Math.abs(sum - nums[left] - nums[right]);
                    twoSum = nums[left] + nums[right];
                }
                //小于目标则左指针向中间靠拢，大于目标则右指针向中间靠拢
                if(nums[left] + nums[right] == sum){
                    return target;
                }else if(nums[left] + nums[right] < sum){
                    left ++;
                }else{
                    right --;
                }
            }
            //保存最接近的三数之和
            if(Math.abs(target - res) > Math.abs(target - twoSum - nums[i])){
                res = twoSum + nums[i];
            }
        }
        return res;
    }
}
