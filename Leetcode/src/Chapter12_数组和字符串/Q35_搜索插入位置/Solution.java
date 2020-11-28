package Chapter12_数组和字符串.Q35_搜索插入位置;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/11/2020 22:32
 **/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length ;
        //二分搜索，如果能找到就会返回对应的索引,如果找不到，那么就会返回对应的插入位置
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                return mid;
            }
        }
        return left;
    }
}
