package Chapter3二分查找.Q33_搜索旋转排序数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/12/2020 22:16
 **/

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int start = 0;
        int end = nums.length - 1;
        while(left <= right){
            //计算中间值
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            //判断中间点落在前半段
            if(nums[mid] >= nums[start]){
                //目标在mid后面
                if(nums[mid] < target){
                    left = mid + 1;
                }else{
                    //目标在mid前面
                    if(target >= nums[start]){
                        right = mid - 1;
                    }else{
                        //目标在mid后面
                        left = mid+1;
                    }
                }
            }else{
                //判断中间点落在后半段
                if(nums[mid] < target){
                    //目标在mid后面
                    if(target <= nums[end]){
                        left = mid + 1;
                    }else{
                        //目标在mid前面
                        right = mid - 1;
                    }
                }else{
                    //目标在mid前面
                    right = mid -1;
                }
            }
        }
        return  -1;
    }
}
