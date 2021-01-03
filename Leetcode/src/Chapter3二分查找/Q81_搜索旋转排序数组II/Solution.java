package Chapter3二分查找.Q81_搜索旋转排序数组II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/01/2021 22:59
 **/

public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) /2;
            if(nums[mid] == target){
                return true;
            }
            //由于存在重复元素，所以遇到这种特殊情况时需要排除首元素
            //所以这时对于最坏的情况，时间复杂度退化成O(N)
            if(nums[start] == nums[mid]){
                start++;
                continue;
            }
            if(nums[start] < nums[mid]){
                //确定target在前半区间
                if(nums[start] <= target && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                //确定target在后半区间
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
