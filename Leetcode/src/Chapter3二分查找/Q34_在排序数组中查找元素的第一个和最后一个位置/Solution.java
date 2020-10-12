package Chapter3二分查找.Q34_在排序数组中查找元素的第一个和最后一个位置;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/10/2020 15:28
 **/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums.length == 0){
            return res;
        }
        int left = 0;
        int right = nums.length -1;
        //寻找左侧边界,终止条件是left == right+1;
        while(left <= right){
            int mid = left+(right - left)/2;
            if(nums[mid] == target){
                //收缩右侧边界
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        //当left比所有元素都大时,left会超出边界，所以先判断是否越界,left指向左侧边界
        res[0] = left == nums.length || nums[left] != target ? -1 : left;

        left = 0;
        right = nums.length -1;
        //计算右侧边界
        while(left <= right){
            int mid = left+(right - left)/2;
            if(nums[mid] == target){
                //收缩左侧边界
                left = mid + 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid -1 ;
            }
        }
        //当right比所有元素还小时，要防止出现right == -1的情况
        res[1] = right == -1|| nums[right] != target  ? -1 : right;
        return res;
    }
}
